package com.example.pmdm.ut03.Ej9;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.example.pmdm.R;

public class u3e9IntentImplicito extends AppCompatActivity {

    Button u3e9btSorpresa;
    private static int num;
    private Uri webpage;
    private Intent intent;
    private static int ONE = 1, FOUR = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e9_intent_implicito);
        u3e9btSorpresa = findViewById(R.id.u3e9btSorpresa);

        u3e9btSorpresa.setOnClickListener(view ->{
            num =(int) (Math.random() * FOUR + ONE);
            switch (num){
                case 1 :
                    webpage = Uri.parse("https://www.youtube.com/watch?v=-wTLvPuFK7I");
                    intent = new Intent(Intent.ACTION_VIEW,webpage);
                    break;
               case 2:
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + "666"));
                    break;
                case 3:
                    intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:637647632"));
                    intent.putExtra("sms_body", "Amigo Pago:\nTe veo hoy a las 6pm");
                    break;
                case 4:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:47.6,-122.3?z=11"));
                    break;
            }
            try {
                startActivity(intent);
            }catch (Exception e){
                erroDialog(e.getMessage());
            }
        });
    }

    private void erroDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(u3e9IntentImplicito.this);
        builder.setTitle("Error!");
        builder.setMessage(message);
        builder.setCancelable(true);
        AlertDialog erro = builder.create();
        erro.show();
    }
}