package com.example.pmdm.ut03.Ej5;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class u3e5AnalizaLetra extends AppCompatActivity {
    TextView u3e5twMensaje;
    EditText u3e5etTextLargo;
    Button u3e5btAnalizar;
    public static final String INTENTKEY = "fgegekgirbguyreg";
    private static ActivityResultLauncher launcher;
    private static Intent intent;
    private static String mensaje = null,resultado = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e5_analiza_letra);
        u3e5twMensaje = findViewById(R.id.u3e5twMensaje);
        u3e5etTextLargo = findViewById(R.id.u3e5etTextLargo);
        u3e5btAnalizar = findViewById(R.id.u3e5btAnalizar);

        u3e5btAnalizar.setOnClickListener(view ->{
            mensaje = u3e5etTextLargo.getText().toString().replace(" ","");
            intent = new Intent(u3e5AnalizaLetra.this, u3e5AnalizaLetraResult.class);
            intent.putExtra(INTENTKEY,mensaje);
            launcher.launch(intent);
            clear();
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
           if(result.getResultCode() == u3e5AnalizaLetraResult.FINALIZAR){
               intent = result.getData();
               resultado = intent.getStringExtra(u3e5AnalizaLetraResult.INTENTKEY);
               u3e5twMensaje.setText(resultado);
           }
        });
    }

    private void clear(){
        u3e5etTextLargo.setText("");
        u3e5etTextLargo.setHint(getResources().getString(R.string.IntAlgo));
        u3e5twMensaje.setText("");

    }
}