package com.example.pmdm.ut03.Ej2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e2PedirHeladoResult extends AppCompatActivity {
    TextView u3e2twrSalida1;
    Button u3e2phrbtVolver;
    private static ArrayList<String> message = new ArrayList<>();
    private static int numVain,numFres,numChoc;
    private static String circuloSim,cucuSim,tarrinaSim;
    private static final int ZERO = 0, ONE = 1, TWO = 2, THREE = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e2_pedir_helado_result);

        u3e2twrSalida1 = findViewById(R.id.u3e2phrtwSalida1);
        u3e2phrbtVolver = findViewById(R.id.u3e2phrbtVolver);
        cucuSim = getResources().getString(R.string.CucuSim);
        circuloSim = getResources().getString(R.string.CirculoSim);
        tarrinaSim = getResources().getString(R.string.tarrinaSim);

        Bundle bundle = getIntent().getExtras();

        if(bundle == null) finish();

        message = bundle.getStringArrayList(u3e2PedirHelado.INTENTKEY);

        numVain = Integer.parseInt(message.get(ZERO).toString());
        if(numVain != ZERO) pintaHelado(Color.YELLOW,circuloSim,numVain);

        numFres = Integer.parseInt(message.get(ONE).toString());
        if(numFres != ZERO) pintaHelado(Color.parseColor("#F48FB1"),circuloSim,numFres);

        numChoc = Integer.parseInt(message.get(TWO).toString());
        if(numChoc != ZERO) pintaHelado(Color.parseColor("#A1887F"),circuloSim,numChoc);

        if(message.get(message.size()-ONE).equals(getResources().getStringArray(R.array.tipoHelado)[ZERO])){
            pintaCono(Color.parseColor("#A1887F"),cucuSim);
        }
        if(message.get(message.size()-ONE).equals(getResources().getStringArray(R.array.tipoHelado)[ONE])){
            pintaCono(Color.parseColor("#795548"),cucuSim);
        }
        if(message.get(message.size()-ONE).equals(getResources().getStringArray(R.array.tipoHelado)[TWO])){
            pintaCono(Color.parseColor("#78909C"),tarrinaSim);
        }


        u3e2phrbtVolver.setOnClickListener(view -> {
            clear();
            finish();
        });

    }
    private void pintaHelado(int colo, String sim,int num){
        String cadena = "";
        for(int i = 1; i <= num; i ++){
            cadena += sim;
            if(i % 3 == 0){
                cadena += "\n";
            }
        }
        SpannableString spand = new SpannableString(cadena + "\n");
        ForegroundColorSpan spandColor = new ForegroundColorSpan(colo);
        spand.setSpan(spandColor,this.ZERO,spand.length(),spand.SPAN_EXCLUSIVE_EXCLUSIVE);
        u3e2twrSalida1.append(spand);
    }

    private void pintaCono(int colo, String sim){
        SpannableString spand = new SpannableString( sim);
        ForegroundColorSpan spandColor= new ForegroundColorSpan(colo);
        AbsoluteSizeSpan spandSize = new AbsoluteSizeSpan(200,true);
        spand.setSpan(spandSize,this.ZERO,spand.length(),spand.SPAN_EXCLUSIVE_EXCLUSIVE);
        spand.setSpan(spandColor,this.ZERO,spand.length(),spand.SPAN_EXCLUSIVE_EXCLUSIVE);
        u3e2twrSalida1.append(spand);
    }
    private void clear(){
        u3e2twrSalida1.setText("");
    }
}