package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    TextView resultat;
    Button approuver, refuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        resultat = findViewById(R.id.txt_resultat_rs);
        approuver = findViewById(R.id.btn_approuver_rs);
        refuser = findViewById(R.id.btn_refuser_rs);
        // On récupére les informations du voyageur
        String nom = getIntent().getStringExtra(Cles.creerCle("6908", "NOM"));
        String naissance = getIntent().getStringExtra(Cles.creerCle("6908", "NAISSANCE"));
        String destination = getIntent().getStringExtra(Cles.creerCle("6908", "DESTINATION"));
        String motif = getIntent().getStringExtra(Cles.creerCle("6908", "MOTIF"));
        int age = Integer.parseInt(destination) - Integer.parseInt(naissance);
        // Si le motif de voyage est modification du passé et si l'age est un nombre premier
        if (motif.equals("Modification du passé") && estPremier(age)) {
            // alors le bouton approuver est désactivé
            approuver.setEnabled(false);
        }

        // Affichage des informations
        resultat.setText("Nom : " + nom
                +"\nNaissance : " + naissance
                + "\nDestination : " + destination
                + "\nAge temporel : " + age + " ans"
                + "\nMotif : " + motif);

        approuver.setOnClickListener(v -> {

            Intent i = new Intent(VerificationActivity.this,
                    ResultActivity.class);
            // on transmet qu'il a approuvé avec son nom
            i.putExtra(Cles.creerCle("6908", "NOM"), nom);
            i.putExtra(Cles.creerCle("6908", "ACCEPTE"), true);

            startActivity(i);
        });

        refuser.setOnClickListener(v -> {

            Intent i = new Intent(VerificationActivity.this,
                    ResultActivity.class);
            // on transmet qu'il a refusé avec son nom
            i.putExtra(Cles.creerCle("6908", "NOM"), nom);
            i.putExtra(Cles.creerCle("6908", "ACCEPTE"), false);

            startActivity(i);
        });
    }
    // On vérifie si le nombre est premier ou non
    public boolean estPremier(int nombre) {
        //
        if (nombre <= 1) {
            return false;
        }

        for (int i = 2; i < nombre; i++) {
            if (nombre % i == 0) {
                return false;
            }
        }

        return true;
    }
}