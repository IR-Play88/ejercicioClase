package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static String[] obtener(String comando) {
        StringTokenizer st = new StringTokenizer(comando, " ");

        String[] listaCadena = new String[st.countTokens()];

        for(int i = 0; i<listaCadena.length; i++) {
            listaCadena[i] = st.nextToken();
        }

        return listaCadena;
    }

    public static void pintar(String salida) {
        System.out.println(salida);
    }

    public static String ejecutar(String comando) {
        try {
            Process process = Runtime.getRuntime().exec(comando);
            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            // Dejamos el programa bloqueado hasta que termine el otro.
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
            } else {
                System.out.println("Ha habido un error");
                System.out.printf("El proceso de obtener un directorio termino %d", exitVal);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(34);
        }
        return comando;
    }

    public static String leer(String opcion) {
        Scanner sc = new Scanner(System.in);

        final String OPCION = "Escriba un comando: ";
        System.out.print(OPCION);
        opcion = sc.nextLine();
        return opcion;
    }

    public static void main(String[] args) {

        final String OPC_SALIR = "Salir";

        String comando = null;

        do {
            comando = leer(comando);

            ejecutar(comando);

            pintar(comando);

        } while (!(comando.equals(OPC_SALIR)));
    }

}
