package com.example.pmdm.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm.R;

public class u2e5PediCitaCitaCorrecto extends AppCompatActivity {

    Button  u2e5btVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e5_pedi_cita_cita_correcto);
        u2e5btVolver = findViewById(R.id.u2e5btVolver);
        u2e5btVolver.setOnClickListener((View v) ->{
            Intent pediCita = new Intent(u2e5PediCitaCitaCorrecto.this,u2e5PediCita.class);
            startActivity(pediCita);
        });
    }
}