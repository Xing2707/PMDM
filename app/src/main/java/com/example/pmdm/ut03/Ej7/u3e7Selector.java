package com.example.pmdm.ut03.Ej7;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3e7Selector extends AppCompatActivity {
    ImageButton u3e7btselectplayer1,u3e7btselectplayer2, u3e7btSelectpokemon1, u3e7btSelectpokemon2;
    Button u3e7btLimpiar;

    View.OnClickListener manejadorPersonaje,manejadorPokemon;
    private static final int ZERO = 0;
    public static  final String INTENTPSELECT ="SJHFSHFHFRBYBFRB", INTENTPLAYERID ="SFHUHDFHEFHEYFH";
    public static  final String INTENTPKID ="SJHFSHFHFRBYBFRB";
    private static Intent intent;
    private static int resources = 0, id = 0, select = 0;
    private static ActivityResultLauncher launcherPer,launcherPok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e7_selector);

        EnumPlayer player = null;

        u3e7btselectplayer1 = findViewById(R.id.u3e7btselectplayer1);
        u3e7btselectplayer2 = findViewById(R.id.u3e7btselectplayer2);
        u3e7btSelectpokemon1 = findViewById(R.id.u3e7btSelectpokemon1);
        u3e7btSelectpokemon2 = findViewById(R.id.u3e7btSelectpokemon2);
        u3e7btLimpiar = findViewById(R.id.u3e7btLimpiar);

        manejadorPersonaje = view -> {
            intent = new Intent(u3e7Selector.this,u3e7Personaje.class);
            if(view.getId() == R.id.u3e7btselectplayer1){
                if(u3e7btselectplayer2.getTag() == null) u3e7btselectplayer2.setTag(player.anonimo.getReference());
                resources =(int) u3e7btselectplayer2.getTag();
                putPlayer(u3e7btselectplayer1.getId(),player.anonimo.getReference(),resources,launcherPer,intent);

            }else if(view.getId() == R.id.u3e7btselectplayer2) {
                if(u3e7btselectplayer1.getTag() == null) u3e7btselectplayer1.setTag(player.anonimo.getReference());
                resources = (int) u3e7btselectplayer1.getTag();
                putPlayer(u3e7btselectplayer2.getId(),player.anonimo.getReference(),resources,launcherPer,intent);
            }
        };

        manejadorPokemon = view -> {
            intent = new Intent(u3e7Selector.this,u3e7Pokemon.class);
            if(view.getId() == R.id.u3e7btSelectpokemon1){
                intent.putExtra(INTENTPKID,u3e7btSelectpokemon1.getId());
                launcherPok.launch(intent);
            } else if (view.getId() == R.id.u3e7btSelectpokemon2) {
                intent.putExtra(INTENTPKID,u3e7btSelectpokemon2.getId());
                launcherPok.launch(intent);
            }
        };

        u3e7btselectplayer1.setOnClickListener(manejadorPersonaje);
        u3e7btselectplayer2.setOnClickListener(manejadorPersonaje);
        u3e7btSelectpokemon1.setOnClickListener(manejadorPokemon);
        u3e7btSelectpokemon2.setOnClickListener(manejadorPokemon);

        launcherPer = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
            intent = result.getData();
            if(result.getResultCode() == Activity.RESULT_OK){
                id = intent.getIntExtra(u3e7Personaje.INTENTPLAYERID,ZERO);
                select = intent.getIntExtra(u3e7Personaje.INTENTPLAYERSELECT,ZERO);
                if(id == u3e7btselectplayer1.getId()){
                    u3e7btselectplayer1.setImageResource(select);
                    u3e7btselectplayer1.setTag(select);
                }else if(id == u3e7btselectplayer2.getId()) {
                    u3e7btselectplayer2.setImageResource(select);
                    u3e7btselectplayer1.setTag(select);
                }
            } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                Adialog("Worning","El usuario se ha cancelado el operacion.");
            }
        });

        launcherPok = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
        intent = result.getData();
        if(result.getResultCode() == Activity.RESULT_OK){
            id = intent.getIntExtra(u3e7Pokemon.INTENTPOKEMONID,ZERO);
            select = intent.getIntExtra(u3e7Pokemon.INTENTPOKEMONSELECT,ZERO);

            if(id == u3e7btSelectpokemon1.getId()){
                u3e7btSelectpokemon1.setImageResource(select);
            }else if(id == u3e7btSelectpokemon2.getId()){
                u3e7btSelectpokemon2.setImageResource(select);
            }

        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
            Adialog("Worning","El usuario se ha cancelado el operacion.");
        }
    });

    }
    private void putPlayer(int id,int reference, int resources, ActivityResultLauncher launcher,Intent intent){
        if(resources == reference){
            intent.putExtra(INTENTPLAYERID,id);
            launcher.launch(intent);
        }else{
            intent.putExtra(INTENTPLAYERID,id);
            intent.putExtra(INTENTPSELECT,resources);
            launcher.launch(intent);
        }
    }
    private void Adialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(u3e7Selector.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}