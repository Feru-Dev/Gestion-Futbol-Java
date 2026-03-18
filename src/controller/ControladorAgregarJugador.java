package controller;

import view.*;
import DAO.*;
import model.*;
import java.awt.event.*;

// Controlador de la ventana para agregar jugadores
public class ControladorAgregarJugador {

    private VentanaAgregarJugador vista;  // Vista de agregar jugador
    private JugadorDAO jugadorDAO;     // DAO para gestionar jugadores

    // Constructor: recibe la ventana y el DAO
    public ControladorAgregarJugador(VentanaAgregarJugador vista, JugadorDAO dao) {
        this.vista = vista;
        this.jugadorDAO = dao;

        // Acción del botón "Agregar"
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarJugador();
            }
        });

        // Acción del botón "Cerrar"
        this.vista.btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana
            }
        });
    }

    // Método para agregar un jugador usando el DAO
    private void agregarJugador() {
        try {
            String dni = vista.txtDNI.getText();
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            double salario = Double.parseDouble(vista.txtSalario.getText());
            int idEquipo = Integer.parseInt(vista.txtIdEquipo.getText());

            // Crear objeto Futbolista
            Jugador jugador = new Jugador(dni, nombre, apellido, salario, idEquipo);

            // Agregar jugador a la base de datos
            jugadorDAO.agregarJugador(jugador);

            // Mostrar feedback en JTextArea
            vista.txtFeedback.setText("Jugador agregado correctamente:\n" + jugador.toString());

            // Limpiar campos de entrada
            vista.txtDNI.setText("");
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtSalario.setText("");
            vista.txtIdEquipo.setText("");

        } catch(NumberFormatException ex) {
            vista.txtFeedback.setText("Error: Salario o ID de equipo deben ser números!");
        } catch(Exception ex) {
            vista.txtFeedback.setText("Error al agregar los datos: " + ex.getMessage());
        }
    }
}