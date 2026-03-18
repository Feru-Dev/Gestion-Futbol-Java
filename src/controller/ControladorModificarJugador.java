package controller;

import view.*;
import DAO.*;
import model.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class ControladorModificarJugador implements ActionListener{

	private VentanaModificarJugador vista; //vista de MODIFICAR JUGADOR
	private JugadorDAO jugadorDAO; //DAO del jugador
	private String dni; // <--- 1. Necesitas esta variable global para que actionPerformed la vea
	
	// Constructor: recibe la ventana y el DAO
	public ControladorModificarJugador(VentanaModificarJugador vista, String dni) {
		
		this.vista = vista;
		this.dni = dni; // <--- 2. Guardamos el DNI recibido
		this.jugadorDAO = new JugadorDAO();
		
		this.vista.btnActualizar.addActionListener(this);
		this.vista.btnCerrar.addActionListener(this);
		
		// Los datos se cargan al abrir la ventana, no al pulsar actualizar.
		iniciarVistaEdicion();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btnActualizar) {
			
			//se realiza el metodo para actualizar
			actualizarJugador();

		}
		
		if(e.getSource() == vista.btnCerrar) {
			// Libera los recursos y cierra esta ventana específica
        	vista.dispose(); 
		}
		
	}
	
	// Llama a esto nada más abrir la ventana de edición
	public void iniciarVistaEdicion() {
	    Jugador old = jugadorDAO.getJugadorPorDNI(dni);
	  
	        vista.txtNombre.setText(old.getNombre());
	        vista.txtApellido.setText(old.getApellido());
	        vista.txtSalario.setText(String.valueOf(old.getSalario())); //esto lo parsea a string
	        vista.txtIdEquipo.setText(old.getIdEquipo() + ""); //esto tamb lo parsea a string
	    
	}
	
	//metodo para Actualizar el jugador
	private void actualizarJugador() {
		try {
			
			//se recogen los datos de la ventana 
			//El DNI no se recoge porque ya lo ha introducido antes y se recoge arriba
			String nombre = vista.txtNombre.getText();
			String apellido = vista.txtApellido.getText();
			double salario = Double.parseDouble(vista.txtSalario.getText());
			int equipo = Integer.parseInt(vista.txtIdEquipo.getText());
			
			//se crea el objeto futbolista
			Jugador jugador = new Jugador(dni, nombre, apellido, salario, equipo);
			
			//se envia el jugador al DAO para modificar la BBDD
			jugadorDAO.ModificarJugadorPorDNI(jugador);
			
			// Mostrar feedback en JTextArea
			vista.txtFeedback.setText("Jugador agregado correctamente:\n" + jugador.toString());
			
			 // Limpiar campos de entrada
            vista.txtNombre.setText("");
            vista.txtApellido.setText("");
            vista.txtSalario.setText("");
            vista.txtIdEquipo.setText("");
            
		}catch(NumberFormatException ex) {
			vista.txtFeedback.setText("Error: Salario o ID de equipo deben ser números!");
		}catch(Exception ex) {
			vista.txtFeedback.setText("Error al modificar los datos del Jugador" + ex.getMessage());
		}
	}
	
	
	
	
	
	
	
}
