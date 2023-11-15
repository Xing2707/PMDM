package com.example.pmdm.ut03.Ej2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pmdm.R;
import com.example.pmdm.ut02.ut2e5PiedraPapeTigera;

import java.util.ArrayList;
import java.util.Arrays;

public class u3e2PedirHelado extends AppCompatActivity {
    Spinner u3e2Spinner;
    EditText u3e2phetVainilla,u3e2phetFresa,u3e2phetChocolate;
    Button u3e2phbtGenera;
    ArrayAdapter<String>  adapter;
    ArrayList <String> helados = new ArrayList<>();
    private static final String ZERO = "0";
    public static  final String INTENTKEY = "fhrhurygrugrufyrgygrygvr";
    private static final int INTZERO = 0;
    private static String[] item;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e2_pedir_helado);

       u3e2Spinner = (Spinner) findViewById(R.id.u3e2phspTipo);
       u3e2phetVainilla = findViewById(R.id.u3e2phetEntrada1);
       u3e2phetFresa = findViewById(R.id.u3e2phetEntrada2);
       u3e2phetChocolate = findViewById(R.id.u3e2phetEntrada3);
       u3e2phbtGenera = findViewById(R.id.u3e2phbtGenera);

       clear();

       item = getResources().getStringArray(R.array.tipoHelado);

       adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       u3e2Spinner.setAdapter(adapter);
       u3e2Spinner.setSelection(INTZERO,false);

       u3e2phbtGenera.setOnClickListener((view) ->{
           if(view.getId() == R.id.u3e2phbtGenera){
               if (Integer.parseInt(u3e2phetVainilla.getText().toString()) == INTZERO &&
                       Integer.parseInt(u3e2phetFresa.getText().toString()) == INTZERO &&
                       Integer.parseInt(u3e2phetChocolate.getText().toString()) == INTZERO
               ){
                   Errordialog();
               }else{
                   helados.add(u3e2phetVainilla.getText().toString());
                   helados.add(u3e2phetFresa.getText().toString());
                   helados.add(u3e2phetChocolate.getText().toString());
                   helados.add(u3e2Spinner.getSelectedItem().toString());
                   Intent intent = new Intent(u3e2PedirHelado.this,u3e2PedirHeladoResult.class);
                   intent.putExtra(INTENTKEY,helados);
                   startActivity(intent);
                   clear();
               }
           }
       });
    }
    private void Errordialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(u3e2PedirHelado.this);
        builder.setTitle("Error!");
        builder.setMessage("Debes rellenar los datos!");
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void clear(){
        u3e2phetVainilla.setText(ZERO);
        u3e2phetFresa.setText(ZERO);
        u3e2phetChocolate.setText(ZERO);
        u3e2Spinner.setSelection(0);
        helados.clear();
    }
}