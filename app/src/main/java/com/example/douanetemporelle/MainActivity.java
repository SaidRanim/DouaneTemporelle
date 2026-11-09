
package com.example.douanetemporelle;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nom, naissance, destination;
    Button inspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nom = findViewById(R.id.edt_nom_rs);
        naissance = findViewById(R.id.edt_naissance_rs);
        destination = findViewById(R.id.edt_destination_rs);
        inspecter = findViewById(R.id.btn_inspecter_rs);


        inspecter.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,
                    VerificationActivity.class);

            i.putExtra("NOM", nom.getText().toString());
            i.putExtra("NAISSANCE", naissance.getText().toString());
            i.putExtra("DESTINATION", destination.getText().toString());

            startActivity(i);
        });
    }
}
