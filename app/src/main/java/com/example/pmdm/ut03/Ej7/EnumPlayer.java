package com.example.pmdm.ut03.Ej7;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public enum EnumPlayer{
    anonimo(R.mipmap.anonimo),
    person1(R.mipmap.personaje1),
    person2(R.mipmap.personaje2),
    person3(R.mipmap.personaje3),
    person4(R.mipmap.personaje4);
    private final int reference;
    EnumPlayer(int reference){
        this.reference = reference;
    }
    public int getReference(){
        return reference;
    }
}
