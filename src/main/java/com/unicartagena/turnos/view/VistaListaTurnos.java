/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.unicartagena.turnos.view;

import com.unicartagena.turnos.model.ModeloTurnos;
import com.unicartagena.turnos.model.entity.Turno;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jahm1
 */
public final class VistaListaTurnos extends javax.swing.JFrame {

    /**
     * Creates new form VistaListaTurnos
     */
    public VistaListaTurnos() {
        initComponents();
        ModeloTurnos.agregarObservador(this);
        configurarEstadoColumna();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTurnos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaTurnos.setAutoCreateRowSorter(true);
        tablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Teléfono", "Correo", "Día de Ingreso", "Placa de Vehículo", "Tiempo Transcurrido", "Cambiar Estado", "Turno", "Fecha Cierre"
            }
        ));
        tablaTurnos.setPreferredSize(new java.awt.Dimension(600, 90));
        jScrollPane1.setViewportView(tablaTurnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   public void actualizarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tablaTurnos.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de actualizar

    for (Turno turno : ModeloTurnos.obtenerTurnos()) {
        modelo.addRow(new Object[] {
            turno.getNombre(),
            turno.getApellido(),
            turno.getTelefono(),
            turno.getCorreo(),
            turno.getDiaIngreso(),
            turno.getPlacaVehiculo(),
            calcularTiempoTranscurrido(turno.getDiaIngreso()),
            turno.getEstado(),
            turno.getNumeroTurno(),
            turno.getFechaCierre() != null ? turno.getFechaCierre() : "Sin Cerrar"
        });
    }
}


    private String calcularTiempoTranscurrido(String diaIngreso) {
        try {
            LocalDateTime ingreso = LocalDateTime.parse(diaIngreso, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            Duration duracion = Duration.between(ingreso, LocalDateTime.now());
            long horas = duracion.toHours();
            long minutos = duracion.toMinutes() % 60;
            return horas + "h " + minutos + "m";
        } catch (Exception e) {
            return "Formato inválido";
        }
    }

    private void configurarEstadoColumna() {
        tablaTurnos.getColumnModel().getColumn(7).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            String estado = (String) value;
            if ("En espera".equals(estado)) {
                return new JButton(estado); // Renderiza un botón
            } else {
                return new JLabel(estado); // Renderiza un JLabel
            }
        });

        tablaTurnos.getColumnModel().getColumn(7).setCellEditor(new EstadoCellEditor());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaListaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaListaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaListaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaListaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaListaTurnos().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTurnos;
    // End of variables declaration//GEN-END:variables

   private class EstadoCellEditor extends javax.swing.AbstractCellEditor implements javax.swing.table.TableCellEditor {

    private JButton button;

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }

    @Override
    public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
        String estado = (String) value;
        if ("En espera".equals(estado)) {
            button = new JButton(estado);
            button.addActionListener(e -> {
                int numeroTurno = (int) table.getValueAt(row, 8); // Obtener el número de turno desde la columna
                ModeloTurnos.cambiarEstadoTurno(numeroTurno, "Atendido");
                fireEditingStopped(); // Detener la edición después del cambio
            });
            return button;
        } else {
            return new JLabel(estado);
        }
    }
}


}