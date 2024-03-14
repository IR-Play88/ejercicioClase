package com.example;

import java.io.File;

public class Prueba {
    public static void main(String[] args) {
        File fichero=new File(".");
        String[] listaArchivos=fichero.list();
        for(int i=0; i<listaArchivos.length; i++){
            System.out.println(listaArchivos[i]);
        }
    }
}
