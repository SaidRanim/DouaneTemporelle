package com.example.douanetemporelle;

import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nom, naissance, destination;
    Button inspecter;
    RadioGroup motif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nom = findViewById(R.id.edt_nom_rs);
        naissance = findViewById(R.id.edt_naissance_rs);
        destination = findViewById(R.id.edt_destination_rs);
        inspecter = findViewById(R.id.btn_inspecter_rs);
        motif = findViewById(R.id.rg_motif_rs);
        // Sélection du motif Tourisme par défaut
        motif.check(R.id.rb_tourisme_rs);

        inspecter.setOnClickListener(v -> {
            // vérification des champs obligatoires
            if (nom.getText().toString().trim().isEmpty()
                    || naissance.getText().toString().trim().isEmpty()
                    || destination.getText().toString().trim().isEmpty()) {

                nom.setError("Champ obligatoire");
                naissance.setError("Champ obligatoire");
                destination.setError("Champ obligatoire");
                return;
            }
            // un Intent pour ouvrir la page de vérification
            Intent i = new Intent(MainActivity.this,
                    VerificationActivity.class);

            // On transmet les informations du voyageur à la page de vérification

            i.putExtra(Cles.creerCle("6908", "NOM"),
                    nom.getText().toString());

            i.putExtra(Cles.creerCle("6908", "NAISSANCE"),
                    naissance.getText().toString());

            i.putExtra(Cles.creerCle("6908", "DESTINATION"),
                    destination.getText().toString());
            RadioButton choix = findViewById(motif.getCheckedRadioButtonId());

            String raison = choix.getText().toString();

            i.putExtra(Cles.creerCle("6908", "MOTIF"), raison);


            startActivity(i);
        });
    }
}
