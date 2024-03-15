package com.example.Ejercicio1;

import java.io.FileInputStream;
import java.util.StringTokenizer;

public class Ejercicio1 {
    public static void main(String[] args) {
        
    }
    public static String leer() throws Exception {


        final String FICHERO = "numeros.txt";

        String data = null;

        try (FileInputStream fis = new FileInputStream(FICHERO)) {
            data = new String(fis.readAllBytes());

        } catch (Exception e) {
            throw e;
        }

        return data;
    }

    public static int[] obtener(String cadena) {
        StringTokenizer st = new StringTokenizer(cadena, "\n");

        int[] numeros = new int[st.countTokens()];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(st.nextToken());
        }

        return numeros;
    }

    public static void calcularMayorMenor(int[] numeros){

        int mayor = -1;
        int menor = 99;

        for (int i : numeros) {
            if (i > mayor) {
                mayor = i;
            }else{
                menor = i;
            }
        }

    }
    


}
