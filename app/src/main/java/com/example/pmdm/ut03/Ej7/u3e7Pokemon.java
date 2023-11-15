package com.example.pmdm.ut03.Ej7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3e7Pokemon extends AppCompatActivity {

    ImageButton u3e7imgbtBulbasaur,u3e7imgbtCharmander,u3e7imgbtSquirtle,u3e7imgbtPikachu;

    View.OnClickListener manejador;
    Bundle bundle;
    Intent intent;
    private static final int ZERO = 0;
    public static final String INTENTPOKEMONSELECT = "JKSJFIUFEHFU";
    public static final String INTENTPOKEMONID = "SHFUHYFEHF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e7_pokemon);

        EnumPokemon pokemon = null;

        u3e7imgbtBulbasaur = findViewById(R.id.u3e7imgbtBulbasaur);
        u3e7imgbtCharmander = findViewById(R.id.u3e7imgbtCharmander);
        u3e7imgbtSquirtle = findViewById(R.id.u3e7imgbtSquirtle);
        u3e7imgbtPikachu = findViewById(R.id.u3e7imgbtPikachu);

        bundle = getIntent().getExtras();
        intent = new Intent(u3e7Pokemon.this,u3e7Selector.class);

        manejador = view -> {

            if(view.getId() == R.id.u3e7imgbtBulbasaur){
                intent.putExtra(INTENTPOKEMONID,bundle.getInt(u3e7Selector.INTENTPKID,ZERO));
                intent.putExtra(INTENTPOKEMONSELECT,pokemon.bulbasaur.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
            } else if (view.getId() == R.id.u3e7imgbtCharmander) {
                intent.putExtra(INTENTPOKEMONID,bundle.getInt(u3e7Selector.INTENTPKID,ZERO));
                intent.putExtra(INTENTPOKEMONSELECT,pokemon.charmander.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
            } else if (view.getId() == R.id.u3e7imgbtSquirtle) {
                intent.putExtra(INTENTPOKEMONID,bundle.getInt(u3e7Selector.INTENTPKID,ZERO));
                intent.putExtra(INTENTPOKEMONSELECT,pokemon.squirtle.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
            } else if (view.getId() == R.id.u3e7imgbtPikachu) {
                intent.putExtra(INTENTPOKEMONID,bundle.getInt(u3e7Selector.INTENTPKID,ZERO));
                intent.putExtra(INTENTPOKEMONSELECT,pokemon.pikachu.getReference());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }

        };
        u3e7imgbtBulbasaur.setOnClickListener(manejador);
        u3e7imgbtCharmander.setOnClickListener(manejador);
        u3e7imgbtSquirtle.setOnClickListener(manejador);
        u3e7imgbtPikachu.setOnClickListener(manejador);



    }


}