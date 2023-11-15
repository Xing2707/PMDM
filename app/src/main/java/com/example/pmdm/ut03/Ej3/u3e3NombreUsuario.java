package com.example.pmdm.ut03.Ej3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e3NombreUsuario extends AppCompatActivity {

    TextView u3e3nutvNombre,u3e3nutvMensaje;
    Button u3e3nubtPedir;
    ActivityResultLauncher<Intent> launcher;
    private static final int ONE = 1, ZERO = 0;
    private static int listaNbLenght = 0;
    private static ArrayList <String> listaNombre= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e3_nombre_usuario);

        u3e3nutvNombre = findViewById(R.id.u3e3nutvNombre);
        u3e3nutvMensaje = findViewById(R.id.u3e3nutvMensaje);
        u3e3nubtPedir = findViewById(R.id.u3e3nubtPedir);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),(result)->{
            if(result.getResultCode() == RESULT_OK){
               Intent data = result.getData();
               setCorrectMesagge("El usuario ha cambiado su nombre");
               listaNombre.add(data.getStringExtra(u3e3NombreUsuarioResultado.ACEPT_KEY));
               listaNbLenght = listaNombre.size() - ONE;
               u3e3nutvNombre.setText(listaNombre.get(listaNbLenght));
            } else if (result.getResultCode() == RESULT_CANCELED) {
                setErrorMesagge("El usuario ha cancelado el operacion");
            } else if(result.getResultCode() == u3e3NombreUsuarioResultado.RESULT_LIMP){
                setCorrectMesagge("El usuario ha limpiado su nombre");
                if(!listaNombre.isEmpty()){
                    listaNbLenght = listaNombre.size() -ONE;
                    if(listaNbLenght <= ZERO){
                        listaNombre.remove(listaNbLenght);
                        u3e3nutvNombre.setText(getResources().getString(R.string.anonimo));
                    }else {
                        listaNombre.remove(listaNbLenght);
                        listaNbLenght = listaNombre.size() -ONE;
                        u3e3nutvNombre.setText(listaNombre.get(listaNbLenght));
                    }
                }else{
                    u3e3nutvNombre.setText(getResources().getString(R.string.anonimo));
                }
            }else{
                setErrorMesagge("Operacion no completo");
                u3e3nutvNombre.setText(getResources().getString(R.string.anonimo));
            }
        });

        u3e3nubtPedir.setOnClickListener(view -> {
            Intent intent = new Intent(u3e3NombreUsuario.this,u3e3NombreUsuarioResultado.class);
            launcher.launch(intent);
        });
    }

    private void  setErrorMesagge(String message){
        u3e3nutvMensaje.setText(message);
        u3e3nutvMensaje.setTextColor(Color.RED);
    }

    private void setCorrectMesagge(String message){
        u3e3nutvMensaje.setText(message);
        u3e3nutvMensaje.setTextColor(Color.GREEN);
    }
}