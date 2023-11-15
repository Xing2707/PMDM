package com.example.pmdm.ut03.Ej1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e1ResultadoCalculador extends AppCompatActivity {

    TextView u3e1twResultado;
    Button u3e1btVolver;
    private static  ArrayList<String> message = new ArrayList<>();

    private static String[] data = null;
    private static String operation = null;
    private static int num1 = 0,num2 = 0, total = 0,resto = 0;
    private static final int ZERO = 0, ONE = 1, TWO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e1_resultado_calculador);

        u3e1twResultado = findViewById(R.id.u3e1twResultado);
        u3e1btVolver = findViewById(R.id.u3e1btVolver);

        Bundle intent = getIntent().getExtras();

        if(intent == null){finish();}

        message = intent.getStringArrayList(u3e1Calculador.INTENTKEY);

        data = message.toArray(new String[message.size()]);

        num1 = Integer.parseInt(data[ZERO]);
        operation = data[ONE];
        num2 = Integer.parseInt(data[TWO]);

        if(num2 == ZERO){finish();}

        if(operation.equals(getResources().getString(R.string.OperadoMas).toString())){ total = num1 + num2;}
        if(operation.equals(getResources().getString(R.string.OperadoMenos).toString())){ total = num1 - num2;}
        if(operation.equals(getResources().getString(R.string.OperadoMultiplicar).toString())){ total = num1 * num2;}
        if(operation.equals(getResources().getString(R.string.OPeradoDividi).toString())){
            total = num1 / num2;
            if(num1 % num2 != 0){
                resto = num1 % num2;
            } else if (num1 % num2 == 0) {
                resto = 0;
            }
        }

        u3e1twResultado.setText(num1 + " " + operation + " " + num2 + " = " + total);
        u3e1twResultado.append((resto != 0)? "\n Resto: " + resto : "");
        u3e1btVolver.setOnClickListener(view -> {
            finish();
        });
    }
}