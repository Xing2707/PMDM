package com.example.pmdm.ut03.Ej8;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmdm.R;

public class u3e8ObjetoSerializable extends AppCompatActivity {
    EditText u3e8oset1,u3e8oset2;
    TextView u3e8ostvColor;
    SeekBar u3e8ossb1,u3e8ossb2,u3e8ossb3;
    SeekBar.OnSeekBarChangeListener sbmanejador;
    Button u3e8osbtEnviar;
    Intent intent;
    ActivityResultLauncher <Intent> launcher;
    public static final String INTENT_KEY = "GHJDHGURHGRY";
    private static final int ZERO = 0;
    private static String nombre;
    private static int miembro,color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e8_objeto_serializable);
        u3e8oset1 = findViewById(R.id.u3e8oset1);
        u3e8oset2 = findViewById(R.id.u3e8oset2);
        u3e8ostvColor = findViewById(R.id.u3e8ostvColor);
        u3e8ossb1 = findViewById(R.id.u3e8ossb1);
        u3e8ossb2 = findViewById(R.id.u3e8ossb2);
        u3e8ossb3 = findViewById(R.id.u3e8ossb3);
        u3e8osbtEnviar = findViewById(R.id.u3e8osbtEnviar);

        sbmanejador = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                u3e8ostvColor.setBackgroundColor(Color.rgb(u3e8ossb1.getProgress(),u3e8ossb2.getProgress(),u3e8ossb3.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        u3e8ossb1.setOnSeekBarChangeListener(sbmanejador);
        u3e8ossb2.setOnSeekBarChangeListener(sbmanejador);
        u3e8ossb3.setOnSeekBarChangeListener(sbmanejador);

        u3e8osbtEnviar.setOnClickListener(view -> {
            if(u3e8oset1.getText().toString().isEmpty() && u3e8oset2.getText().toString().isEmpty()){
                errorDialog("Debes llenar los datos!!!");
            }else{
                nombre = u3e8oset1.getText().toString();
                miembro = Integer.parseInt(u3e8oset2.getText().toString());
                color = Color.rgb(u3e8ossb1.getProgress(),u3e8ossb2.getProgress(),u3e8ossb3.getProgress());
                Monstruo monstruo = new Monstruo(nombre,miembro,color);
                intent = new Intent(u3e8ObjetoSerializable.this, u3e8ObjetoSerializableR.class);
                intent.putExtra(INTENT_KEY,monstruo);
                launcher.launch(intent);
            }
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            if(result.getResultCode() == Activity.RESULT_OK){
                clear();
            }else if(result.getResultCode() == Activity.RESULT_CANCELED){
                clear();
            }
        });
    }
    private void clear(){
        u3e8oset1.setText("");
        u3e8oset2.setText("");
        u3e8ossb1.setProgress(ZERO);
        u3e8ossb2.setProgress(ZERO);
        u3e8ossb3.setProgress(ZERO);
    }
    private void errorDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(u3e8ObjetoSerializable.this);
        Spannable spannatext = new SpannableString(message);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        spannatext.setSpan(colorSpan,0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setTitle("Error!!!");
        builder.setMessage(spannatext);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}