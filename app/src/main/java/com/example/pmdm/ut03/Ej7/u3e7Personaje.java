package com.example.pmdm.ut03.Ej7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3e7Personaje extends AppCompatActivity {

    ImageButton u3e7imgbtPers1,u3e7imgbtPers2,u3e7imgbtPers3,u3e7imgbtPers4;
    View.OnClickListener manejador;
    Bundle bundle;
    Intent intent;
    private static int resource,playeid;
    private static final int ZERO = 0;
    public static final String INTENTPLAYERID = "SJHFUHFHFYE";
    public static final String INTENTPLAYERSELECT = "FHSUFHYFHEHF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e7_personaje);
        EnumPlayer player = null;

        u3e7imgbtPers1 = findViewById(R.id.u3e7imgbtPers1);
        u3e7imgbtPers2 = findViewById(R.id.u3e7imgbtPers2);
        u3e7imgbtPers3 = findViewById(R.id.u3e7imgbtPers3);
        u3e7imgbtPers4 = findViewById(R.id.u3e7imgbtPers4);

        bundle = getIntent().getExtras();
        intent = new Intent(u3e7Personaje.this,u3e7Selector.class);
        playeid = bundle.getInt(u3e7Selector.INTENTPLAYERID,ZERO);

        if((resource = bundle.getInt(u3e7Selector.INTENTPSELECT,ZERO)) != ZERO){
            if(resource == player.person1.getReference()) u3e7imgbtPers1.setEnabled(false);
            if(resource == player.person2.getReference()) u3e7imgbtPers2.setEnabled(false);
            if(resource == player.person3.getReference()) u3e7imgbtPers3.setEnabled(false);
            if(resource == player.person4.getReference()) u3e7imgbtPers4.setEnabled(false);
        }
        manejador = view -> {

            if(view.getId() == R.id.u3e7imgbtPers1){
                intent.putExtra(INTENTPLAYERID,playeid);
                intent.putExtra(INTENTPLAYERSELECT,player.person1.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
                clear();
            }else if (view.getId() == R.id.u3e7imgbtPers2){
                intent.putExtra(INTENTPLAYERID,playeid);
                intent.putExtra(INTENTPLAYERSELECT,player.person2.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
                clear();
            }else if (view.getId() == R.id.u3e7imgbtPers3){
                intent.putExtra(INTENTPLAYERID,playeid);
                intent.putExtra(INTENTPLAYERSELECT,player.person3.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
                clear();
            }else if (view.getId() == R.id.u3e7imgbtPers4){
                intent.putExtra(INTENTPLAYERID,playeid);
                intent.putExtra(INTENTPLAYERSELECT,player.person4.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
                clear();
            }
        };
        u3e7imgbtPers1.setOnClickListener(manejador);
        u3e7imgbtPers2.setOnClickListener(manejador);
        u3e7imgbtPers3.setOnClickListener(manejador);
        u3e7imgbtPers4.setOnClickListener(manejador);
    }
    private void clear(){
        u3e7imgbtPers1.setEnabled(true);
        u3e7imgbtPers2.setEnabled(true);
        u3e7imgbtPers3.setEnabled(true);
        u3e7imgbtPers4.setEnabled(true);
    }
}