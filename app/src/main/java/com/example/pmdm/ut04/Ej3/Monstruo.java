package com.example.pmdm.ut04.Ej3;

import java.io.Serializable;

public class Monstruo implements Serializable {
    private static final int ESPACIO_CUERVO = 2;
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
    public String toString() {return construirMonstruo();}

    private String construirMonstruo(){
        String monstruo = "";

        monstruo += completSpace(cuervo);

        monstruo += nombre +"\n";

        monstruo += completSpace(cuervo + ESPACIO_CUERVO);

        monstruo += "*\n";

        if(lefthand < cuervo) monstruo += completSpace(cuervo - lefthand);
        monstruo += pintaMiembro("/",lefthand);
        monstruo += "o";
        monstruo += pintaMiembro("\\",righthand);
        monstruo +="\n";

        if(leftfoot == 0){
            monstruo += completSpace(cuervo + ESPACIO_CUERVO + ESPACIO_CUERVO);
        }else if(leftfoot < cuervo){
            monstruo += completSpace(cuervo - leftfoot + ESPACIO_CUERVO);
        }
        monstruo += pintaMiembro("/",leftfoot);
        monstruo += pintaMiembro("\\",rightfoot);
        return monstruo;
    }

    private String pintaMiembro(String cadena, int num){
        String result = "";
        for(int i = 0; i <num; i ++){
            result += cadena;
        }
        return result;
    }
    private String completSpace(int num){
        String result = "";
        for(int i = 0; i < num; i++){
            result += " ";
        }
        return result;
    }
}
