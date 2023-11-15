package com.example.pmdm.ut03.Ej3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm.R;
import com.example.pmdm.ut03.Ej2.u3e2PedirHelado;

public class u3e3NombreUsuarioResultado extends AppCompatActivity {

    public static final int RESULT_LIMP = -2;
    EditText u3e3nuretNombre;
    Button u3e3nurbtAceptar,u3e3nurbtCancelar,u3e3nurbtLimpiar;
    View.OnClickListener manejador;
    private static Intent intent = new Intent();
    private static final String CLEAR_TXT = "Limpiar";
    public static final String ACEPT_KEY = "SGHFHYDFGUYRGFUGRUGURGUGHRYGUYW";
    public static final String CLEAR_KEY = "DHFGHYGHUYRHUGRHUGHURHGHRUHGURHG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e3_nombre_usuario_resultado);

        u3e3nuretNombre = findViewById(R.id.u3e3nuretNombre);
        u3e3nurbtAceptar = findViewById(R.id.u3e3nurbtAceptar);
        u3e3nurbtCancelar = findViewById(R.id.u3e3nurbtCancelar);
        u3e3nurbtLimpiar = findViewById(R.id.u3e3nurbtLimpiar);

        manejador = view ->{
          if(view.getId() == R.id.u3e3nurbtAceptar) {
              if (!u3e3nuretNombre.getText().toString().isEmpty()) {
                  intent.putExtra(ACEPT_KEY, u3e3nuretNombre.getText().toString());
                  setResult(Activity.RESULT_OK, intent);
                  finish();
              } else {
                  erroDialog();
              }
          }
          if (view.getId() == R.id.u3e3nurbtCancelar){
              setResult(Activity.RESULT_CANCELED);
              finish();
          }
          if (view.getId() == R.id.u3e3nurbtLimpiar) {
                setResult(RESULT_LIMP);
                finish();
          }
        };

        u3e3nurbtAceptar.setOnClickListener(manejador);
        u3e3nurbtCancelar.setOnClickListener(manejador);
        u3e3nurbtLimpiar.setOnClickListener(manejador);

    }
    private void erroDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(u3e3NombreUsuarioResultado.this);
        builder.setTitle("Error!");
        builder.setMessage("Debes rellenar los datos!");
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}