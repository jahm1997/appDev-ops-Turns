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
    private Number telefono;
    private String correo;
    
    public Turno(String nombre, String apellido, String horaEntrada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.diaIngreso = diaIngreso;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public Number getTelefono() {
        return telefono;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getHoraEntrada() {
        return diaIngreso;
    }
}
