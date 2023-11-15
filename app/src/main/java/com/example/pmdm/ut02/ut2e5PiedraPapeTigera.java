package com.example.pmdm.ut02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.Random;

public class ut2e5PiedraPapeTigera extends AppCompatActivity {

    private enum juego {
        piedra(1,R.string.u2e5juegobtPiedra),
        papel(2, R.string.u2e5juegobtPapel),
        tijera(3, R.string.u2e5juegobtTijera);
        private final int number;
        private final int reference;
        juego(int number, int reference) {
            this.number = number;
            this.reference = reference;
        }
        private int getReference(){return reference;}
        private int getNumber(){return number;}
        private static juego referencetoByNumber(int number){
            for (juego num : values()) {
                if (num.number == number) {
                    return num;
                }
            }
            return  null;
        }
    }
    ImageButton u2e5juegobtPiedra,u2em5juegobtPapel,u2e5juegobtTijera;
    Button u2e5juegobtReset;
    TextView u2e5juegotwSalida1,u2e5juegotwSalida2,u2e5juegotwRespuesta;
    View.OnClickListener manejador;

    private  final  int ENDPOIND = 3, ZERO = 0, ONE = 1,TWO = 2, THREE = 3;
    private int puntoJugador = 0,puntoMaquina = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e5_piedra_pape_tigera);
        u2e5juegobtPiedra = findViewById(R.id.u2e5juegobtPiedra);
        u2em5juegobtPapel = findViewById(R.id.u2e5juegobtPapel);
        u2e5juegobtTijera = findViewById(R.id.u2e5juegobtTigera);
        u2e5juegobtReset = findViewById(R.id.u2e5juegobtReset);
        u2e5juegotwSalida1 = findViewById(R.id.u2e5juegotwSalida1);
        u2e5juegotwSalida2 = findViewById(R.id.u2e5juegotwSalida2);
        u2e5juegotwRespuesta = findViewById(R.id.u2e5juegotwRespuesta);

        u2e5juegotwSalida1.append("0");
        u2e5juegotwSalida2.append("0");

        manejador = (View v) -> {
            if (v.getId() == R.id.u2e5juegobtReset) {
                if (puntoMaquina == ENDPOIND || puntoJugador == ENDPOIND) {
                    resetGame();
                } else {
                    onBackPressed();
                }
            }else{
                jugar(v);
            }
        };
            u2e5juegobtReset.setOnClickListener(manejador);
            u2e5juegobtPiedra.setOnClickListener(manejador);
            u2em5juegobtPapel.setOnClickListener(manejador);
            u2e5juegobtTijera.setOnClickListener(manejador);
    }
    private void jugar(View v){
        String useChoise = "",bootChoise = "",text = "";
        juego userSelectR = null, bootSelectR = null;
        Random random = new Random();
        int ramnum = random.nextInt(THREE) + ONE;

        if(v.getId() == R.id.u2e5juegobtPiedra){
            userSelectR = juego.referencetoByNumber(ONE);
        } else if (v.getId() == R.id.u2e5juegobtPapel) {
            userSelectR = juego.referencetoByNumber(TWO);
        } else if (v.getId() == R.id.u2e5juegobtTigera) {
            userSelectR = juego.referencetoByNumber(THREE);
        }
        bootSelectR = juego.referencetoByNumber(ramnum);
        u2e5juegotwRespuesta.setText(bootSelectR.getReference());
        useChoise = getResources().getString(userSelectR.getReference());
        bootChoise = getResources().getString(bootSelectR.getReference());
        u2e5juegotwRespuesta.setText("Has sacado "+ useChoise + "\n maquina ha sacado " + bootChoise);
        if(userSelectR.getNumber() == bootSelectR.getNumber()){
            u2e5juegotwRespuesta.append("\n Empate!");
        }else if(
                (userSelectR.getNumber() == ONE && bootSelectR.getNumber() == THREE) ||
                (userSelectR.getNumber() == TWO && bootSelectR.getNumber() == ONE) ||
                (userSelectR.getNumber() == THREE && bootSelectR.getNumber() == TWO)
        ){
            puntoJugador += ONE;
            text = u2e5juegotwSalida1.getText().toString();
            text = text.substring(ZERO,text.indexOf(":") + ONE);
            u2e5juegotwSalida1.setText( text + puntoJugador);
            u2e5juegotwRespuesta.append("\n Has Ganado 1 punto para ti");
        }else {
            puntoMaquina += ONE;
            text = u2e5juegotwSalida2.getText().toString();
            text = text.substring(ZERO,text.indexOf(":") + ONE);
            u2e5juegotwSalida2.setText( text + puntoMaquina);
            u2e5juegotwRespuesta.append("\n Has Perdido 1 punto para maquina");
        }
        if(puntoJugador == ENDPOIND || puntoMaquina == ENDPOIND) {
            u2e5juegobtPiedra.setEnabled(false);
            u2em5juegobtPapel.setEnabled(false);
            u2e5juegobtTijera.setEnabled(false);

            final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            final VibrationEffect vibrationEffect;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                vibrationEffect = VibrationEffect.createOneShot(3000, VibrationEffect.DEFAULT_AMPLITUDE);
                vibrator.cancel();
                vibrator.vibrate(vibrationEffect);
            }
            if (puntoJugador == ENDPOIND) {
                u2e5juegotwRespuesta.setText("Enhorabuena has ganado con 3 puntos!");
            } else {
                u2e5juegotwRespuesta.setText("Que triste te ha ganado el maquina con 3 puntos!");
            }
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ut2e5PiedraPapeTigera.this);

        builder.setMessage("Esta seguro que Quieres resetear el juego?");

        builder.setTitle("Alerta!");

        builder.setCancelable(false);

        builder.setPositiveButton("Si", (DialogInterface.OnClickListener) (dialog, which) -> {
            resetGame();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void resetGame(){
        String text;
        puntoJugador = 0;
        puntoMaquina = 0;
        u2e5juegobtPiedra.setEnabled(true);
        u2em5juegobtPapel.setEnabled(true);
        u2e5juegobtTijera.setEnabled(true);
        u2e5juegotwRespuesta.setText("");

        text = u2e5juegotwSalida1.getText().toString();
        text = text.substring(ZERO,text.indexOf(":") + ONE);
        u2e5juegotwSalida1.setText(text + puntoJugador);
        text = u2e5juegotwSalida2.getText().toString();
        text = text.substring(ZERO,text.indexOf(":") + ONE);
        u2e5juegotwSalida2.setText(text + puntoMaquina);
    }
}