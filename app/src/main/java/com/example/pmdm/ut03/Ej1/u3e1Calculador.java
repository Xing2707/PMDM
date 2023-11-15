package com.example.pmdm.ut03.Ej1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e1Calculador extends AppCompatActivity {
    TextView u3e1twErrorSalida1,u3e1twErrorSalida2,u3e1twErrorSalida3;
    EditText u3e1etNumSalida1,u3e1etNumSalida2;
    Button u3e1btCalcular;
    RadioButton buttonSelect;
    RadioGroup operaciones;
    private static final int ONE = 1, ZERO = 0;
    private static ArrayList<String> message = new ArrayList<>();
    private static String errorMessage = null;
    public static final String INTENTKEY = "sdhgfyfyehyfhyehfiehf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e1_calculador);

        u3e1etNumSalida1 = findViewById(R.id.u3e1etNumSalida1);
        u3e1etNumSalida2 = findViewById(R.id.u3e1etNumSalida2);
        operaciones = findViewById(R.id.u3e3rgOperaciones);
        u3e1twErrorSalida1 = findViewById(R.id.u3e1twErrorSalida1);
        u3e1twErrorSalida2 = findViewById(R.id.u3e1twErrorSalida2);
        u3e1twErrorSalida3 = findViewById(R.id.u3e1twErrorSalida3);
        u3e1btCalcular = findViewById(R.id.u3e1btCalcular);

        u3e1btCalcular.setOnClickListener(view -> {
            if(
                    !u3e1etNumSalida1.getText().toString().isEmpty() &&
                    !u3e1etNumSalida2.getText().toString().isEmpty() &&
                    operaciones.getCheckedRadioButtonId() != -ONE
            ){
                Intent intent = new Intent(u3e1Calculador.this,u3e1ResultadoCalculador.class);
                int idSelect = operaciones.getCheckedRadioButtonId();
                  buttonSelect = (RadioButton) findViewById(idSelect);
                  String radioText = buttonSelect.getText().toString();
                  if(radioText.equals(getResources().getString(R.string.OPeradoDividi))){
                      if(
                              Integer.parseInt(u3e1etNumSalida2.getText().toString()) == ZERO
                      ){
                          u3e1twErrorSalida3.setText(getResources().getString(R.string.DivorceCantBeZero).toString());

                      }else{
                          u3e1twErrorSalida2.setText(null);
                          message.clear();
                          message.add(u3e1etNumSalida1.getText().toString());
                          message.add(radioText);
                          message.add(u3e1etNumSalida2.getText().toString());

                          intent.putExtra(INTENTKEY,message);

                          clear();
                          startActivity(intent);
                      }
                  }else{
                      message.clear();
                      message.add(u3e1etNumSalida1.getText().toString());
                      message.add(radioText);
                      message.add(u3e1etNumSalida2.getText().toString());

                      intent.putExtra(INTENTKEY,message);

                      clear();
                      startActivity(intent);
                  }
            }else {
                errorMessage = getResources().getString(R.string.EntherSometing).toString();
                u3e1twErrorSalida1.setText(u3e1etNumSalida1.getText().toString().isEmpty()? errorMessage : null);
                u3e1twErrorSalida3.setText(u3e1etNumSalida2.getText().toString().isEmpty()? errorMessage : null);
                errorMessage = getResources().getString(R.string.ChosserSometing).toString();
                u3e1twErrorSalida2.setText((operaciones.getCheckedRadioButtonId() == -ONE)? errorMessage : null);

            }
        });
    }
    private void clear(){
        u3e1twErrorSalida1.setText(null);
        u3e1twErrorSalida2.setText(null);
        u3e1twErrorSalida3.setText(null);

        u3e1etNumSalida1.setText(null);
        u3e1etNumSalida2.setText(null);

        buttonSelect.setChecked(false);
    }

}