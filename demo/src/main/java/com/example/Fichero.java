package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fichero {
    public static File crear(String carpeta) throws Exception {
        File directorio = new File(carpeta);
        directorio.mkdir();
        return directorio;

    }

    public static File crear(File carpeta, String nombreFichero, byte[] datos) throws Exception {

        final String MSG_ERROR = "ERROR - No se puede escribir el fichero";

        String path = carpeta.getAbsolutePath() + File.separator + nombreFichero;
        File fichero = new File(path);

        try (
                FileOutputStream fos = new FileOutputStream(fichero);) {
            fos.write(datos);

        } catch (IOException e) {
            throw new Exception(MSG_ERROR);
        }

        return fichero;
    }

    public static File copiar(File directorio, File fichero, String nombreNuevo) throws Exception {

        byte[] datos = null;

        try (FileInputStream fis = new FileInputStream(fichero)) {
            datos = fis.readAllBytes();

        } catch (Exception e) {
            throw e;
        }
        return crear(directorio, nombreNuevo, datos);

    }

    public static void borrar(File fichero) {
        fichero.delete();
    }

    public static void renombrar(File fichero, String nombreNuevo) {

        File ficheroRenombrado = new File(fichero.getParentFile().getPath()+File.separator+nombreNuevo);
        fichero.renameTo(ficheroRenombrado);
    }

    public static void listar(File carpeta) {
        String[] listaArchivos = carpeta.list();
        for (int i = 0; i < listaArchivos.length; i++) {
            System.out.println(listaArchivos[i]);
        }

    }

    public static void main(String[] args) throws Exception {

        final String CARPETA = "pruebas";

        File carpeta = crear(CARPETA);
        File fichero = crear(null, null, null);
        File ficheroCopiado = copiar(carpeta, fichero, null);
        borrar(null);
        renombrar(null);
        listar(null);
    }

}
