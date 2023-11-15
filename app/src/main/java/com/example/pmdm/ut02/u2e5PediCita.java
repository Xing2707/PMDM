package com.example.pmdm.ut02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm.R;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.HijrahDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u2e5PediCita extends AppCompatActivity {

    TextView u2e5twPerfilSalida;
    EditText u2e5etEntradaDNI,u2e5etEntradaDate,u2e3e5etEntradaTime;
    Button u2e5btPediCita;
    private final Calendar calendar = Calendar.getInstance();
    View.OnClickListener manejador;
    boolean dateValid = true,timeValid = true;
    private final  int UNO = 1, NUEVE = 9, CINCO = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2e5_pedi_cita);

        u2e5twPerfilSalida = findViewById(R.id.u2e5twPerfilSalida);
        u2e5etEntradaDNI = findViewById(R.id.u2e5etEntradaDNI);
        u2e5etEntradaDate = findViewById(R.id.u2e5etEntradaDate);
        u2e3e5etEntradaTime = findViewById(R.id.u2e5etEntradaTime);
        u2e5btPediCita = findViewById(R.id.u2e5btPediCita);

        manejador = (View v) ->{
            if(v.getId() == R.id.u2e5etEntradaDate){
                int anio = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH) + UNO;
                int dia =  calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(u2e5PediCita.this, (View ,year,month,day)->{
                    String dateSelect = day + "-" + month +"-"+ year;
                    String dateInvalid = "Fecha Invalido!";
                    Calendar calendaNow = Calendar.getInstance();
                    int anioNow = calendaNow.get(Calendar.YEAR);
                    int mesNow = calendaNow.get(Calendar.MONTH) + UNO;
                    int diaNow = calendaNow.get(Calendar.DAY_OF_MONTH);

                    if(year > anioNow ){
                        dateValid = true;
                        printET(u2e5etEntradaDate,dateSelect,dateValid);
                    }else if(year == anioNow && month > mesNow){
                        dateValid = true;
                        printET(u2e5etEntradaDate,dateSelect,dateValid);
                    }else if(year == anioNow && month == mesNow && day >= diaNow){
                        dateValid = true;
                        printET(u2e5etEntradaDate,dateSelect,dateValid);
                    }else{
                        dateValid = false;
                        printET(u2e5etEntradaDate,dateInvalid,dateValid);
                    }
                },anio,mes,dia);
                dateDialog.show();

            } else if (v.getId() == R.id.u2e5etEntradaTime) {
                int hora = calendar.get(Calendar.HOUR_OF_DAY);
                int minuto = calendar.get(Calendar.MINUTE);
                TimePickerDialog timeDialog = new TimePickerDialog(u2e5PediCita.this, (View, hour, minute) -> {
                    String timeSlect = String.format("%02d : %02d", hour, minute);
                    String timeInvalid = "Horas Invalido!";
                    if (hour > NUEVE) {
                        timeValid = true;
                        printET(u2e3e5etEntradaTime, timeSlect, timeValid);
                    } else if (hour == NUEVE && minute >= CINCO) {
                        timeValid = true;
                        printET(u2e3e5etEntradaTime, timeSlect, timeValid);
                    } else {
                        timeValid = false;
                        printET(u2e3e5etEntradaTime, timeInvalid, timeValid);
                    }
                }, hora, minuto, true);
                timeDialog.show();
            } else if (v.getId() == R.id.u2e5btPediCita){
                if(DNiValid(u2e5etEntradaDNI.getText().toString())){
                    u2e5etEntradaDNI.setBackgroundColor(Color.WHITE);
                    u2e5etEntradaDNI.setTextColor(Color.BLACK);
                }else{
                    u2e5etEntradaDNI.setText(null);
                    u2e5etEntradaDNI.setHint("DNI Invalido!");
                    u2e5etEntradaDNI.setBackgroundColor(Color.RED);
                    u2e5etEntradaDNI.setTextColor(Color.WHITE);
                }
                if(u2e5etEntradaDate.getText().toString().isEmpty()){
                    u2e5etEntradaDate.setText("Fecha Invalido!");
                    u2e5etEntradaDate.setTextColor(Color.WHITE);
                    u2e5etEntradaDate.setBackgroundColor(Color.RED);
                }
                if(u2e3e5etEntradaTime.getText().toString().isEmpty()){
                    u2e3e5etEntradaTime.setText("Fecha Invalido!");
                    u2e3e5etEntradaTime.setTextColor(Color.WHITE);
                    u2e3e5etEntradaTime.setBackgroundColor(Color.RED);
                }
                if(dateValid && timeValid && DNiValid(u2e5etEntradaDNI.getText().toString())){
                    u2e5etEntradaDNI.setText(null);
                    u2e5etEntradaDate.setText(null);
                    u2e3e5etEntradaTime.setText(null);
                    Intent citaCorrecto = new Intent(u2e5PediCita.this,u2e5PediCitaCitaCorrecto.class);
                    startActivity(citaCorrecto);
                }
            }
        };
        u2e5etEntradaDate.setOnClickListener(manejador);
        u2e3e5etEntradaTime.setOnClickListener(manejador);
        u2e5btPediCita.setOnClickListener(manejador);
    }

    private void printET(EditText e, String text, boolean valido){
        if(valido){
            e.setText(text);
            e.setBackgroundColor(Color.WHITE);
        }else{
            e.setText(text);
            e.setTextColor(Color.WHITE);
            e.setBackgroundColor(Color.RED);
        }
    }

    private boolean DNiValid(String dni){
        final Pattern REGEX = Pattern.compile("[0-9]{8}[A-Z]");
        final String CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        final String[] INVALID = new String[] { "00000000T", "00000001R", "99999999R" };
            return Arrays.binarySearch(INVALID, dni) < 0
                    && REGEX.matcher(dni).matches()
                    && dni.charAt(8) == CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23);
    }
}