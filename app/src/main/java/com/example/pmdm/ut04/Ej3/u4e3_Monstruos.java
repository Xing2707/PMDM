package com.example.pmdm.ut04.Ej3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmdm.R;

public class u4e3_Monstruos extends AppCompatActivity {
    TextView u4e3tvNombre,u4e3tvColor;
    EditText u4e3etMiembro;
    SeekBar u4e3SeekBarR,u4e3SeekBarG,u4e3SeekBarB;
    Button u4e3btEnviar;
    u4e3_Monstruo_Fragme1 fragme1,fragme2;
    SeekBar.OnSeekBarChangeListener manejadorSeekBar;
    private int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u4e3_monstruos);
        u4e3tvNombre = findViewById(R.id.u4e3tvNombre);
        u4e3tvColor = findViewById(R.id.u4e3tvColor);
        u4e3etMiembro = findViewById(R.id.u4e3etMiembro);
        u4e3SeekBarR = findViewById(R.id.u4e3SeekBarR);
        u4e3SeekBarG = findViewById(R.id.u4e3SeekBarG);
        u4e3SeekBarB = findViewById(R.id.u4e3SeekBarB);
        u4e3btEnviar = findViewById(R.id.u4e3btEnviar);
        fragme1 = (u4e3_Monstruo_Fragme1) getSupportFragmentManager().findFragmentById(R.id.u4e3FragmeV1);
        fragme2 = (u4e3_Monstruo_Fragme1) getSupportFragmentManager().findFragmentById(R.id.u4e3FragmeV2);

        u4e3btEnviar.setOnClickListener(view ->{
            if(u4e3tvNombre.getText().toString().isEmpty() && u4e3etMiembro.getText().toString().isEmpty()){
                pintaErrorDialog("Dato Incompleto","Error! Falta datos a rellenar!");
            }else{
                String nombre = u4e3tvNombre.getText().toString();
                int miembro = Integer.parseInt(u4e3etMiembro.getText().toString());
                int color = Color.rgb(u4e3SeekBarR.getProgress(),u4e3SeekBarG.getProgress(),u4e3SeekBarB.getProgress());
                if(cont == 0){
                    if(fragme1 != null) {
                        fragme1.pintaMonstuo(new Monstruo(nombre,miembro,color));
                    }else{
                        pintaErrorDialog("error","Coneccion con fragme ha sido flacasado");
                    }
                    cont ++;
                }else{
                    if(fragme2 != null){
                        fragme2.pintaMonstuo(new Monstruo(nombre,miembro,color));
                    }else{
                        pintaErrorDialog("error","Coneccion con fragme ha sido flacasado");
                    }
                    cont --;
                }

            }
        });

        manejadorSeekBar = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                u4e3tvColor.setBackgroundColor(
                        Color.rgb(u4e3SeekBarR.getProgress(), u4e3SeekBarG.getProgress(),u4e3SeekBarB.getProgress())
                );
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        u4e3SeekBarR.setOnSeekBarChangeListener(manejadorSeekBar);
        u4e3SeekBarG.setOnSeekBarChangeListener(manejadorSeekBar);
        u4e3SeekBarB.setOnSeekBarChangeListener(manejadorSeekBar);
    }
    public void pintaErrorDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(u4e3_Monstruos.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}