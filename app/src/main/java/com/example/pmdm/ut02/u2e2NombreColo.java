package com.example.pmdm.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.example.pmdm.R;

public class u2e2NombreColo extends AppCompatActivity {

    Button btCambio;
    TextView twSalida1;
    SeekBar sbR1;

    Switch shTextBlanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e2_nombre_colo);

        btCambio = findViewById(R.id.u2e2btCambio);
        twSalida1 = findViewById(R.id.u2e2twSalida1);
        sbR1 = findViewById(R.id.u2e2sbR);
        shTextBlanco = findViewById(R.id.u2e2sh1);

        btCambio.setOnClickListener((View v)->{
            twSalida1.setText(Integer.toString(sbR1.getProgress()));
            if(shTextBlanco.isChecked()){
                twSalida1.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                twSalida1.setTextColor(Color.parseColor("#000000"));
            }
        });

    }
}