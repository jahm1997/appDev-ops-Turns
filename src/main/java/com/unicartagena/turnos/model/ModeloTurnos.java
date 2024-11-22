package com.unicartagena.turnos.model;

import com.unicartagena.turnos.view.VistaListaTurnos;
import com.unicartagena.turnos.model.entity.Turno;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModeloTurnos {

    private static ArrayList<Turno> listaTurnos = new ArrayList<>();
    private static ArrayList<VistaListaTurnos> observadores = new ArrayList<>();
    private static Integer contadorTurnos = 1; // Contador para el número secuencial de turnos

    public static void agregarTurno(int numeroTurno, String nombre, String apellido, String telefono, String correo, String fechaHoraIngreso, String placaVehiculo) {
        Turno turno = new Turno(numeroTurno, nombre, apellido, telefono, correo, fechaHoraIngreso, placaVehiculo);
        listaTurnos.add(turno);
        notificarObservadores();
    }

    // Obtener lista de turnos
    public static ArrayList<Turno> obtenerTurnos() {
        return listaTurnos;
    }

    // Cambiar estado de un turno
    /**
     *
     * @param numeroTurno
     * @param nuevoEstado
     */
    public static void cambiarEstadoTurno(int numeroTurno, String nuevoEstado) {
        for (Turno turno : listaTurnos) {
            if (turno.getNumeroTurno() == numeroTurno) {
                turno.setEstado(nuevoEstado);
                notificarObservadores();
                break;
            }
        }
    }

    // Llamar al siguiente turno (marcar el primero en espera como "en atención")
    public static void llamarSiguienteTurno() {
        for (Turno turno : listaTurnos) {
            if ("En espera".equals(turno.getEstado())) {
                turno.setEstado("En atención");
                notificarObservadores();
                break;
            }
        }
    }

    // Cancelar un turno
    public static void cancelarTurno(int numeroTurno) {
        listaTurnos.removeIf(turno -> turno.getNumeroTurno() == numeroTurno);
        notificarObservadores();
    }

    public static int obtenerUltimoTurno() {
        if (listaTurnos.isEmpty()) {
            return 0; // Si no hay turnos, el primer número será 1
        }

        // Convertir lista a array
        Turno[] turnosArray = listaTurnos.toArray(new Turno[0]);

        // Ordenamiento básico (burbuja)
        for (int i = 0; i < turnosArray.length - 1; i++) {
            for (int j = 0; j < turnosArray.length - i - 1; j++) {
                if (turnosArray[j].getNumeroTurno() > turnosArray[j + 1].getNumeroTurno()) {
                    Turno temp = turnosArray[j];
                    turnosArray[j] = turnosArray[j + 1];
                    turnosArray[j + 1] = temp;
                }
            }
        }

        // El último elemento del array ahora tiene el mayor número de turno
        return turnosArray[turnosArray.length - 1].getNumeroTurno();
    }

// En ModeloTurnos
    public static void cambiarEstadoTurno(Integer numeroTurno, String nuevoEstado) {
        for (Turno turno : listaTurnos) {
            if (turno.getNumeroTurno() == numeroTurno) {
                turno.setEstado(nuevoEstado);
                if ("Atendido".equals(nuevoEstado)) {
                    String fechaCierre = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    turno.setFechaCierre(fechaCierre);
                }
                notificarObservadores(); // Actualiza todas las vistas observadoras
                break;
            }
        }
    }

    // Métodos de observadores
    public static void agregarObservador(VistaListaTurnos vista) {
        observadores.add(vista);
    }

    private static void notificarObservadores() {
        for (VistaListaTurnos vista : observadores) {
            vista.actualizarTabla();
        }
    }

}
