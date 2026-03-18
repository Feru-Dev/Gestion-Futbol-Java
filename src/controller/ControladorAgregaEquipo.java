package controller;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

import model.*;
import DAO.*;
import view.*;


public class ControladorAgregaEquipo implements ActionListener {
	
	//Dao para gestionar los equipos
	private EquipoDAO equipoDAO;  
	//vista de la ventana que se va a controlar
	private VentanaAgregarEquipo vista;
	
	// Constructor: recibe la ventana y el DAO
	public ControladorAgregaEquipo(VentanaAgregarEquipo vista) {
		this.equipoDAO = new EquipoDAO();
		this.vista = vista;
		
		// Acción del botón "Agregar"
		this.vista.btnAgregar.addActionListener(this);
		
		// Acción del botón "Cerrar"
		this.vista.btnCerrar.addActionListener(this);
	}

	//ACCIONES DE LOS BOTONES
	@Override
	public void actionPerformed(ActionEvent e) {

		//boton AGREGAR
		if(e.getSource() == vista.btnAgregar) {
			
			//se recoge lo que escribe el usuario en los recuadros de la ventana
			int IdEquipo = Integer.parseInt(vista.txtEquipoId.getText());
			String nombre = vista.txtNombre.getText();
			String ciudad = vista.txtCiudad.getText();
			
			//se crea un equipo con los datos
			Equipo equipo = new Equipo(IdEquipo, nombre, ciudad);
			
			//se manda el equipo creado al dao para que lo inserte en la BBDD
			equipoDAO.agregarEquipo(equipo);
			
		}
		
		//boton CERRAR
		if(e.getSource() == vista.btnCerrar) {
			//cierra la ventana y libera recursos
			vista.dispose();
		}
		
	}
	
	


}
