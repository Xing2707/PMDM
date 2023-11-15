package com.example.pmdm.ut03.Ej7;

import com.example.pmdm.R;

public enum EnumPokemon {

    ball(R.mipmap.ball),
    bulbasaur (R.mipmap.bulbasaur),
    squirtle(R.mipmap.squirtle),
    charmander(R.mipmap.charmander),
    pikachu(R.mipmap.pikachu);
    private final int reference;
    EnumPokemon(int reference){
        this.reference = reference;
    }
    public int getReference(){
        return reference;
    }
}
