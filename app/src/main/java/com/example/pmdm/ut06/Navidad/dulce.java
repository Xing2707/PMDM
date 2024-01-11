package com.example.pmdm.ut06.Navidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class dulce {
    private String Nombre;
    private String FrutoSeco;
    private String Caloria;
    private static ArrayList<String> dulceList = new ArrayList<String>(Arrays.asList(new String[]{"Turrón de Jijona;No;560", "Marquesas;No;180", "Aguardentaos;No;100", "Glorias de yema;No;200", "Turrón de chocolate crujiente;Almendra;250", "Almendras garrapiñadas;Almendras;200", "Panettone;Nuez;150"}));

    public static dulce generateDulce(int i){
        dulce d = new dulce();
        String[] dulceArray = dulceList.get(i).split(";");
        String nombre = dulceArray[0];
        String fruto = dulceArray[1];
        String caloria = dulceArray[dulceArray.length -1];
        d.setNombre(nombre);
        d.setFrutoSeco(fruto);
        d.setCaloria(caloria);
        return d;
    }

    public static dulce[] generateDulces(){
        dulce[] dulces = new dulce[dulceList.size()];
        for(int i = 0; i < dulces.length; i++){
            dulces[i] = dulce.generateDulce(i);
        }
        return dulces;
    }
    public String getNombre() {
        return Nombre;
    }

    public String getFrutoSeco() {
        return FrutoSeco;
    }

    public String getCaloria() {
        return Caloria;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setFrutoSeco(String frutoSeco) {
        FrutoSeco = frutoSeco;
    }

    public void setCaloria(String caloria) {
        Caloria = caloria;
    }
}
