package com.unicartagena.turnos.model.entity;

public class Turno {

    private Integer numeroTurno;
    private String nombre;
    private String apellido;
    private String diaIngreso;
    private String telefono;
    private String correo;
    private String placaVehiculo;
    private String estado;
    private String fechaCierre;

    public Turno(int numeroTurno, String nombre, String apellido, String telefono, String correo, String diaIngreso, String placaVehiculo) {
        this.numeroTurno = numeroTurno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.diaIngreso = diaIngreso;
        this.placaVehiculo = placaVehiculo;
        this.estado = "En espera";
    }

    // Getters y Setters
    public int getNumeroTurno() {
        return numeroTurno;
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

    public String getDiaIngreso() {
        return diaIngreso;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
