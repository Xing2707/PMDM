package com.example.pmdm.ut04.Ej4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.concurrent.atomic.AtomicInteger;

public class u4e4Pinpon extends AppCompatActivity {
    Button u4e4PinponbtJugar;
    private int puntoFragme1 = 0, puntoFragme2 = 0;
    private final int PUNTO_EXTRA = 2;
    private int setDesempate = 10;
    private int puntoPartido = 11;
    u4e4ContadorPinpon u4e4Fragmev1,u4e4Fragmev2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u4e4_pinpon);
        u4e4PinponbtJugar = findViewById(R.id.u4e4PinponbtJugar);
        u4e4Fragmev1 = (u4e4ContadorPinpon) getSupportFragmentManager().findFragmentById(R.id.u4e4Fragmev1);
        u4e4Fragmev2 = (u4e4ContadorPinpon) getSupportFragmentManager().findFragmentById(R.id.u4e4Fragmev2);

        u4e4PinponbtJugar.setOnClickListener( view ->{
            if(u4e4Fragmev1 != null){
                u4e4Fragmev1.inicializarPartido();
            }
            if(u4e4Fragmev2 != null){
                u4e4Fragmev2.inicializarPartido();
            }
            u4e4PinponbtJugar.setEnabled(false);
        });

        u4e4Fragmev1.setPuntoListener(puntos -> {
            puntoFragme1 = puntos;
            jugar();
        });
        u4e4Fragmev2.setPuntoListener(puntos -> {
            puntoFragme2 = puntos;
            jugar();
        });

    }

    public void jugar(){
        if(puntoFragme1 == setDesempate && puntoFragme2 == setDesempate){
            puntoPartido += PUNTO_EXTRA;
            setDesempate += PUNTO_EXTRA;
        }

        if(puntoFragme1 == puntoPartido || puntoFragme2 == puntoPartido) {
            u4e4Fragmev1.desactivarView();
            u4e4Fragmev2.desactivarView();
        }
    }
}