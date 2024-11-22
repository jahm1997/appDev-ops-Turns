/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.unicartagena.turnos;

import com.unicartagena.turnos.view.VistaInicio;

/**
 *
 * @author jahm1
 */
public class Turnos {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaInicio().setVisible(true);
            }
        });
    }
}
