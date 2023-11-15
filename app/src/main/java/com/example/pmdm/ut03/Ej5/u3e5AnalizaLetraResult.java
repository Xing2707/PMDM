package com.example.pmdm.ut03.Ej5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class u3e5AnalizaLetraResult extends AppCompatActivity {

    TextView u3e5twlgjrhr;
    Button u3e5btFinaliza;
    public static final int FINALIZAR = 1,ONE = 1,FOUR = 4;
    public static final String INTENTKEY = "fkjdhfrhygrgrhgyh";
    private static Intent intent = new Intent();
    private static Bundle bundle;
    private static LinkedHashMap<Character,Integer> hashMap = null;
    private static List<Map.Entry<Character, Integer> > list;
    private static String mensaje = null,resultado = null;
    private static int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e5_analiza_letra_result);

        u3e5twlgjrhr = findViewById(R.id.u3e5twlgjrhr);
        u3e5btFinaliza = findViewById(R.id.u3e5btFinaliza);

        bundle = getIntent().getExtras();
        mensaje = bundle.getString(u3e5AnalizaLetra.INTENTKEY);

        for(int i = 0; i < mensaje.length(); i++){
            if(hashMap == null) {
                hashMap = new LinkedHashMap<>();
                hashMap.put(mensaje.charAt(i),ONE);
            }else{
                if(hashMap.containsKey(mensaje.charAt(i))){
                    num = hashMap.get(mensaje.charAt(i));
                    hashMap.put(mensaje.charAt(i), num +=ONE);
                }else{
                    hashMap.put(mensaje.charAt(i),ONE);
                }
            }
        }

        list = new ArrayList<Map.Entry<Character, Integer> >(hashMap.entrySet());
        list.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));
        for(int i = list.size() - ONE; i > list.size() - FOUR; i--){
            Map.Entry<Character,Integer> entry = list.get(i);
            if(resultado == null){
                resultado = "Las letras mas usada es: \n";
                resultado += entry.getKey() + " : " + entry.getValue() + "\n";
            }else{
                resultado += entry.getKey() + " : " + entry.getValue() + "\n";
            }
        }

        u3e5btFinaliza.setOnClickListener(view -> {
            intent.putExtra(INTENTKEY,resultado);
            setResult(FINALIZAR,intent);
            finish();
            clear();
        });
    }
    private void clear(){
        resultado = null;
    }
}