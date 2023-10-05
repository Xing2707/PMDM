package com.example.pmdm.ut02;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm.R;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class u2e3e4Propinatron extends AppCompatActivity {

    Button u2e3e4bt1,u2e3e4bt2,u2e3e4bt3,u2e3e4bt4,u2e3e4bt5,
            u2e3e4bt6,u2e3e4bt7,u2e3e4bt8,u2e3e4bt9,u2e3e4btR,
            u2e3e4bt0,u2e3e4btC,u2e3e4btCalcula;
    TextView u2e3e4twSalida1,u2e3e4twSalida2;

    RadioButton u2e3e4rbMalo,u2e3e4rbBueno,u2e3e4rbExcelente;

    View.OnClickListener manejado;

    private static final int UNO = 1, ZERO = 0;
    private static final double MALO = 0.10, BUENO = 0.15, EXCELENTE = 0.25;
    private static double provina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e3e4_propinatron);

        u2e3e4bt1 = findViewById(R.id.u2e3e4bt1);
        u2e3e4bt2 = findViewById(R.id.u2e3e4bt2);
        u2e3e4bt3 = findViewById(R.id.u2e3e4bt3);
        u2e3e4bt4 = findViewById(R.id.u2e3e4bt4);
        u2e3e4bt5 = findViewById(R.id.u2e3e4bt5);
        u2e3e4bt6 = findViewById(R.id.u2e3e4bt6);
        u2e3e4bt7 = findViewById(R.id.u2e3e4bt7);
        u2e3e4bt8 = findViewById(R.id.u2e3e4bt8);
        u2e3e4bt9 = findViewById(R.id.u2e3e4bt9);
        u2e3e4btR = findViewById(R.id.u2e3e4btR);
        u2e3e4bt0 = findViewById(R.id.u2e3e4bt0);
        u2e3e4btC = findViewById(R.id.u2e3e4btC);
        u2e3e4btCalcula = findViewById(R.id.u2e3e4btCalcula);
        u2e3e4twSalida1 = findViewById(R.id.u2e3e4twSalida1);
        u2e3e4twSalida2 = findViewById(R.id.u2e3e4twSalida2);
        u2e3e4rbMalo = findViewById(R.id.u2e3e4rbMalo);
        u2e3e4rbBueno = findViewById(R.id.u2e3e4rbBueno);
        u2e3e4rbExcelente = findViewById(R.id.u2e3e4rbExcelente);

        manejado = (View boton) ->{
            if(boton.getId() == R.id.u2e3e4btR){
                String caracte = u2e3e4twSalida1.getText().toString();
                caracte = caracte.substring(ZERO,caracte.length()-UNO);
                u2e3e4twSalida1.setText(caracte);
                u2e3e4twSalida2.setText("");
            } else if (boton.getId() == R.id.u2e3e4btC) {
                u2e3e4twSalida1.setText("");
                u2e3e4twSalida2.setText("");
            }else if(boton.getId() == R.id.u2e3e4btCalcula) {
                if(!u2e3e4twSalida1.getText().toString().isEmpty()){
                    if(u2e3e4rbMalo.isChecked()){ provina = getTotal(u2e3e4twSalida1.getText().toString(),MALO);}
                    else if (u2e3e4rbBueno.isChecked()) {provina = getTotal(u2e3e4twSalida1.getText().toString(),BUENO);}
                    else if(u2e3e4rbExcelente.isChecked()){ provina = getTotal(u2e3e4twSalida1.getText().toString(),EXCELENTE);}

                    u2e3e4twSalida2.setText(String.format("Provina: %.2f €", provina));
                }
            }else {
                Button btText = (Button) boton;
                u2e3e4twSalida1.append(btText.getText());
            }
        };

        u2e3e4bt1.setOnClickListener(manejado);
        u2e3e4bt2.setOnClickListener(manejado);
        u2e3e4bt3.setOnClickListener(manejado);
        u2e3e4bt4.setOnClickListener(manejado);
        u2e3e4bt5.setOnClickListener(manejado);
        u2e3e4bt6.setOnClickListener(manejado);
        u2e3e4bt7.setOnClickListener(manejado);
        u2e3e4bt8.setOnClickListener(manejado);
        u2e3e4bt9.setOnClickListener(manejado);
        u2e3e4btR.setOnClickListener(manejado);
        u2e3e4bt0.setOnClickListener(manejado);
        u2e3e4btC.setOnClickListener(manejado);
        u2e3e4btCalcula.setOnClickListener(manejado);

    }

    private double getTotal(String total, double provina){
        double ParseDoubleTotal = Double.parseDouble(total);
        return provina *= ParseDoubleTotal;
    }
}