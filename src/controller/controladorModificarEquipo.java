package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.EquipoDAO;
import model.Equipo;
import view.*;

public class controladorModificarEquipo implements ActionListener {

	private VentanaModificarEquipo vista; //vista de MODIFICAR JUGADOR
	private EquipoDAO equipoDAO; //DAO del equipo
	private int id; // <--- 1. Necesitas esta variable global para que actionPerformed la vea
	
	// Constructor: recibe la ventana y el DAO
	public controladorModificarEquipo(VentanaModificarEquipo vista, int id) {
		
		this.vista = vista;
		this.id = id; // <--- 2. Guardamos el ID recibido
		this.equipoDAO = new EquipoDAO();
		
		this.vista.btnActualizar.addActionListener(this);
		this.vista.btnCerrar.addActionListener(this);
		
		// Los datos se cargan al abrir la ventana, no al pulsar actualizar.
		iniciarVistaEdicion();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vista.btnActualizar) {
			
			//se realiza el metodo para actualizar
			actualizarEquipo();

		}
		
		if(e.getSource() == vista.btnCerrar) {
			// Libera los recursos y cierra esta ventana específica
        	vista.dispose(); 
		}
		
	}
	
	// Llama a esto nada más abrir la ventana de edición
	public void iniciarVistaEdicion() {
		
	    Equipo old = equipoDAO.getEquipoPorId(id);
	  
	        vista.txtNombre.setText(old.getNombre());
	        vista.txtCiudad.setText(old.getCiudad());
	    
	}
	
	//metodo para Actualizar el jugador
	private void actualizarEquipo() {
		try {
			
			//se recogen los datos de la ventana 
			//El DNI no se recoge porque ya lo ha introducido antes y se recoge arriba
			String nombre = vista.txtNombre.getText();
			String ciudad = vista.txtCiudad.getText();
			
			//se crea el objeto equipo
			Equipo equipo = new Equipo(id, nombre, ciudad);
			
			//se envia el Equipo al DAO para modificar la BBDD
			equipoDAO.ModificarEquipoPorId(equipo);
			
			// Mostrar feedback en JTextArea
			vista.txtFeedback.setText("Equipo Modificado Correctamente:\n" + equipo.toString());
			
			 // Limpiar campos de entrada
            vista.txtNombre.setText("");
            vista.txtCiudad.setText("");
            
		}catch(NumberFormatException ex) {
			vista.txtFeedback.setText("Error: Salario o ID de equipo deben ser números!");
		}catch(Exception ex) {
			vista.txtFeedback.setText("Error al modificar los datos del Jugador" + ex.getMessage());
		}
	}
}
