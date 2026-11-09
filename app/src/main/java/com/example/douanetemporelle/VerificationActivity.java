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

        String nom = getIntent().getStringExtra("NOM");
        String naissance = getIntent().getStringExtra("NAISSANCE");
        String destination = getIntent().getStringExtra("DESTINATION");
        int age = Integer.parseInt("destination") - Integer.parseInt("naissance");


        resultat.setText("Nom : " + nom + "\nNaissance : " + naissance
                + "\nDestination : " + destination + "\nAge temporel : " + age + " ans");

        approuver.setOnClickListener(v -> {

            Intent i = new Intent(VerificationActivity.this,
                    ResultActivity.class);

            i.putExtra("NOM", nom);
            i.putExtra("ACCEPTE", true);

            startActivity(i);
        });

        refuser.setOnClickListener(v -> {

            Intent i = new Intent(VerificationActivity.this,
                    ResultActivity.class);
            i.putExtra("NOM", nom);
            i.putExtra("ACCEPTE", false);

            startActivity(i);
        });
    }
}