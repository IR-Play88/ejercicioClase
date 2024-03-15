package com.example.Properties;

public class Restaurante {
    
    private String nombre;
    private String direccion;

    
    public Restaurante(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("El restaurante %s se encuentra en %s", nombre, direccion);
        }
    }

    

