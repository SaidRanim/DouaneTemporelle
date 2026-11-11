package com.example.douanetemporelle;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView message;
    Button nouveau;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        message = findViewById(R.id.txt_message_rs);
        nouveau = findViewById(R.id.btn_nouveau_rs);
        layout = findViewById(R.id.layout_resultat_rs);
        // Récupération du nom du voyageur et son choix
        String nom = getIntent().getStringExtra(Cles.creerCle("6908", "NOM"));

        boolean accepte = getIntent().getBooleanExtra(
                Cles.creerCle("6908", "ACCEPTE"), false);

        if (accepte) {
            message.setText("Voyage accepté ! Bienvenue " + nom);
            layout.setBackgroundColor(Color.GREEN);
        } else {
                message.setText("Voyage refusé ! " + nom);
                layout.setBackgroundColor(Color.RED);
            }
            nouveau.setOnClickListener(v -> {
                // un Intent pour retourner à la page principale
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                // On ferme les anciennes pages de l'application
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            });
        }
    }
