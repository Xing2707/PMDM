package com.example.pmdm.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pmdm.R;

public class u2e2NombreColo extends AppCompatActivity {

    Button btCambio;
    TextView twSalida1,twSalida2;
    SeekBar sbR,sbG,sbB;

    EditText etEntrada;
    Switch shTextBlanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e2_nombre_colo);

        btCambio = findViewById(R.id.u2e2btCambio);
        twSalida1 = findViewById(R.id.u2e2twSalida1);
        twSalida2 = findViewById(R.id.u2e2twSalida2);
        etEntrada = findViewById(R.id.u2e2etEntrada1);
        sbR = findViewById(R.id.u2e2sbR);
        sbG = findViewById(R.id.u2e2sbG);
        sbB = findViewById(R.id.u2e2sbB);
        shTextBlanco = findViewById(R.id.u2e2sh1);

        btCambio.setOnClickListener((View v) -> {
            int R, G, B, color;
            R = sbR.getProgress();
            G = sbG.getProgress();
            B = sbB.getProgress();
            color = Color.rgb(R, G, B);
            twSalida1.setBackgroundColor(color);
            twSalida1.setText(etEntrada.getText());
        });

        sbR.setOnSeekBarChangeListener(new sbListener());
        sbG.setOnSeekBarChangeListener(new sbListener());
        sbB.setOnSeekBarChangeListener(new sbListener());

        shTextBlanco.setOnClickListener((View v) ->{
            if (shTextBlanco.isChecked()) {
                twSalida1.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                twSalida1.setTextColor(Color.parseColor("#000000"));
            }
        });
    }
    private class sbListener implements SeekBar.OnSeekBarChangeListener{
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            twSalida2.setBackgroundColor(Color.rgb(sbR.getProgress(),sbG.getProgress(),sbB.getProgress()));
        }
        public void onStartTrackingTouch(SeekBar seekBar) {}

        public void onStopTrackingTouch(SeekBar seekBar) {}
    }

}