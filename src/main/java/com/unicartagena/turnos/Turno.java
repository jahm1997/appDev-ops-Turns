/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicartagena.turnos;

/**
 *
 * @author jahm1
 */
public class Turno {
    private String nombre;
    private String apellido;
    private String diaIngreso;
    private String telefono;
    private String correo;
    private String placaVehiculo; 
    
    public Turno(String nombre, String apellido,String telefono, String correo, String diaIngreso, String placaVehiculo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.diaIngreso = diaIngreso;
        this.placaVehiculo = placaVehiculo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getHoraEntrada() {
        return diaIngreso;
    }
    

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

}
