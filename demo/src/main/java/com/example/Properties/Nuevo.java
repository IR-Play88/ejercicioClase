package com.example.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Nuevo {
    private static final String PRP_NOMBRE = "NOMBRE";
    private static final String PRP_DIRECCION = "DIRECCION";

    private static Properties leerConfiguracion() throws Exception{
        final String FICHERO = "configuracion.properties";
        Properties propiedades = new Properties();
        propiedades.load(new FileInputStream(new File(FICHERO)));

        return propiedades;

    }
    public static void main( String[] args ) throws Exception
    {
        
        Properties conf = leerConfiguracion();

        Restaurante res = new Restaurante(conf.getProperty(PRP_NOMBRE), conf.getProperty(PRP_DIRECCION));

        System.out.println(res);
        
    }
}
