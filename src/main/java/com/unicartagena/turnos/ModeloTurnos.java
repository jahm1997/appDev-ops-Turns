/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicartagena.turnos;

/**
 *
 * @author jahm1
 */

import java.util.ArrayList;

public class ModeloTurnos {
    private static ArrayList<Turno> listaTurnos = new ArrayList<>();
    private static ArrayList<VistaListaTurnos> observadores = new ArrayList<>();
    
    public static void agregarTurno(Turno turno) {
        listaTurnos.add(turno);
        notificarObservadores();
    }
    
    public static ArrayList<Turno> obtenerTurnos() {
        return listaTurnos;
    }
    
    public static void agregarObservador(VistaListaTurnos vista) {
        observadores.add(vista);
    }
    
    private static void notificarObservadores() {
        for (VistaListaTurnos vista : observadores) {
            vista.actualizarTabla();
        }
    }
}