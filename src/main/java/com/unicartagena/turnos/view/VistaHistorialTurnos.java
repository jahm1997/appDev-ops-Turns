/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicartagena.turnos.view;

import com.unicartagena.turnos.model.ModeloTurnos;
import com.unicartagena.turnos.model.entity.Turno;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jahm1997
 */
public class VistaHistorialTurnos extends javax.swing.JFrame {

    private JTable tablaHistorial;
    private JScrollPane scrollPane;

    public VistaHistorialTurnos() {
        initComponents();
        configurarComponentes();
        cargarHistorialTurnos();

        // Agregar WindowListener para manejar el cierre
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new VistaFormularioTurnos().setVisible(true); // Abrir la vista del formulario
            }
        });
    }

    /**
     * Inicializa los componentes principales de la ventana.
     */
    private void initComponents() {
        setTitle("Historial de Turnos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(null);
    }

    /**
     * Configura los componentes de la ventana, como la tabla y el panel de
     * scroll.
     */
    private void configurarComponentes() {
        // Crear tabla
        tablaHistorial = new JTable();
        tablaHistorial.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"N° Turno", "Nombre", "Apellido", "Teléfono", "Correo", "Día de Ingreso", "Placa Vehículo", "Estado"}
        ));
        tablaHistorial.setAutoCreateRowSorter(true); // Habilitar ordenamiento

        // Configurar scroll pane
        scrollPane = new JScrollPane(tablaHistorial);
        scrollPane.setBounds(20, 20, 750, 300); // Tamaño y posición del scroll
        add(scrollPane); // Agregar el scroll pane a la ventana
    }

    /**
     * Carga el historial de turnos en la tabla desde el modelo.
     */
    private void cargarHistorialTurnos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaHistorial.getModel();
        modelo.setRowCount(0); // Limpiar tabla antes de cargar datos

        for (Turno turno : ModeloTurnos.obtenerTurnos()) {
            modelo.addRow(new Object[]{
                turno.getNumeroTurno(),
                turno.getNombre(),
                turno.getApellido(),
                turno.getTelefono(),
                turno.getCorreo(),
                turno.getDiaIngreso(),
                turno.getPlacaVehiculo(),
                turno.getEstado()
            });
        }
    }

    /**
     * Método principal para probar la ventana.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new VistaHistorialTurnos().setVisible(true));
    }
}
