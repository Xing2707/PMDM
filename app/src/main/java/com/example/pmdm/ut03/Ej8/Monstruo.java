package com.example.pmdm.ut03.Ej8;

import java.io.Serializable;

public class Monstruo implements Serializable {
    private final int TWO = 2;
    private String nombre;
    private int num_miembros;
    private int color;
    private int lefthand;
    private int righthand;
    private int leftfoot;
    private int rightfoot;
    private int cuervo;
    private int resto;


    public Monstruo(String nombre, int num_miembros, int color) {
        this.nombre = nombre;
        this.num_miembros = num_miembros;
        this.color = color;

        resto = num_miembros;
        lefthand = (int) (Math.random() * resto);
        resto -= lefthand;
        righthand = (int) (Math.random() * resto);
        resto -= righthand;
        leftfoot = (int) (Math.random() * resto);
        resto -= leftfoot;
        rightfoot = resto;
        cuervo = (lefthand > leftfoot)? lefthand : leftfoot;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String monstruo = "";

        monstruo += completSpace(cuervo - TWO);

        monstruo += nombre +"\n";

        monstruo += completSpace(cuervo);

        monstruo += "*\n";

        if(lefthand < cuervo) monstruo += completSpace(cuervo - leftfoot);
        monstruo += pintaMiembro("/",lefthand);
        monstruo += "o";
        monstruo += pintaMiembro("\\",righthand);
        monstruo +="\n";
        if(leftfoot < cuervo) monstruo += completSpace(cuervo - leftfoot - TWO);
        monstruo += pintaMiembro("/",leftfoot);
        monstruo += pintaMiembro("\\",rightfoot);
        return monstruo;
    }

    private String pintaMiembro(String cadena, int num){
        String result = " ";
        for(int i = 0; i <num; i ++){
            result += cadena;
        }
        result +=" ";
        return result;
    }
    private String completSpace(int num){
        String result = " ";
        for(int i = 0; i < num; i++){
            result += " ";
        }
        result += " ";
        return result;
    }
}
