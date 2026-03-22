package controller;

import view.*;
import DAO.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class Controlador implements ActionListener {

    private VentanaPrincipal vista;        // Ventana PRINCIPAL
    private VentanaModificarJugador vistaModificar; //ventana MODIFICAR Jugador
    private JugadorDAO jugadorDAO;      // DAO para gestionar jugadores
    private EquipoDAO equipoDAO;

    // Constructor del controlador
    public Controlador(VentanaPrincipal vista) {
        this.vista = vista;

        // Inicializar el DAO
        this.jugadorDAO = new JugadorDAO();
        this.equipoDAO = new EquipoDAO();

        // Asociar botones al ActionListener
        this.vista.btnVerJugadores.addActionListener(this);
        this.vista.btnAgregarJugador.addActionListener(this);
        this.vista.btnBuscarJugador.addActionListener(this);
        this.vista.btnModificarJugador.addActionListener(this);
        this.vista.btnVerEquipos.addActionListener(this);
        this.vista.btnAgregarEquipo.addActionListener(this);
        this.vista.btnBuscarEquipo.addActionListener(this);
        this.vista.btnModificarEquipo.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	//==============================
        // 1 - Ver todos los jugadores
    	//==============================
        if(e.getSource() == vista.btnVerJugadores) {
            ArrayList<Jugador> lista = jugadorDAO.getJugadores();
            actualizarTabla(lista);
        }

      //==============================
        // 2 - Agregar un nuevo jugador
      //==============================
        if(e.getSource() == vista.btnAgregarJugador) {
            VentanaAgregarJugador ventanaAgregar = new VentanaAgregarJugador();
            new ControladorAgregarJugador(ventanaAgregar, jugadorDAO);
        }

      //==============================
        // 3 - Buscar jugador por DNI
      //==============================
        if(e.getSource() == vista.btnBuscarJugador) {
            String dni = JOptionPane.showInputDialog("Introduce el DNI del jugador:");
            Jugador j = jugadorDAO.getJugadorPorDNI(dni);
            ArrayList<Jugador> lista = new ArrayList<>();
            if(j != null) lista.add(j);
            actualizarTabla(lista);
        }
        //================================
        // 4 - Modificar Jugador por DNI
        //================================
        if(e.getSource() == vista.btnModificarJugador) {
        	
        	//se pide el dni del jugador
			String dni = JOptionPane.showInputDialog(null,"Introduce el DNI del Jugador que quieres modificar");
			
			//si se da a CANCELAR o a la "X" para cerrar la ventana, salta esta advertencia
			if (dni == null) {
				JOptionPane.showMessageDialog(null, "Info: Has cancelado la modificacion", "Info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			// ESTA ES LA CLAVE: Solo si el usuario NO dio a cancelar ni dejó vacío
			if( !dni.isEmpty() && dni != null ) {
				//se busca al jugador por id
				Jugador jugador = jugadorDAO.getJugadorPorDNI(dni);
				
				//
				if(jugador != null) {
					//se printea el jugador recuperado por el dni introducido
					actualizarTabla1(jugador); 
					
					//ventana de modificar jugador
	            	VentanaModificarJugador ventanaModificar = new VentanaModificarJugador();
	            	
	                // Solo creamos el controlador si tenemos un DNI válido
	            	new ControladorModificarJugador(ventanaModificar, dni);
	                
	                ventanaModificar.setVisible(true);
	                
					return;
				}
				//si se introduce un DNI que no coincide salta el WArning
				JOptionPane.showMessageDialog(null, "Advertencia: El DNI introducido no existe", "Warning", JOptionPane.WARNING_MESSAGE);
				
			}
			
			//si el campo se deja vacio
			if (dni.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Advertencia: Has dejado el campo vacio", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	
        }
        
      //==============================
      // 5 - Ver Equipos
      //==============================
        
        if(e.getSource() == vista.btnVerEquipos) {
        	
        	//lista de equipos
        	ArrayList<Equipo> listaEquipos = equipoDAO.getListaEquipos();
        	
        	actualizarTablaEquipo(listaEquipos);
        	
        }
        
      //================================
      // 6 - Agregar Equipo
      //================================
        
        if(e.getSource() == vista.btnAgregarEquipo) {
        	
        	//se crea la instancia de la ventana
        	VentanaAgregarEquipo ventanaAgregarEquipo = new VentanaAgregarEquipo();
        	
        	//se pasa la ventana al controlador
        	new ControladorAgregaEquipo(ventanaAgregarEquipo);
        }
        
        //==============================
        // 7 - Buscar jugador por DNI
       //==============================
        
        if(e.getSource() == vista.btnBuscarEquipo) {
        	String input = JOptionPane.showInputDialog("Introdue el ID del equipo");
        	int id = Integer.parseInt(input);
        	Equipo equipo = equipoDAO.getEquipoPorId(id);
        	ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        	if(equipo != null) {
        		listaEquipos.add(equipo);
        	}
        	actualizarTablaEquipo(listaEquipos);
        	
        }
        
      //================================
        // 8 - Modificar Equipo por ID
        //================================
        if(e.getSource() == vista.btnModificarEquipo) {
        	//se pide el id con un JOptionPane
        	String input = JOptionPane.showInputDialog(null, "Introduce el ID del equipo que quieres modificar");
        	
        	//si se da a CANCELAR o a la "X" para cerrar la ventana, salta esta advertencia
			if (input == null) {
				JOptionPane.showMessageDialog(null, "Info: Has cancelado la modificacion", "Info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			// ESTA ES LA CLAVE: Solo si el usuario NO dio a cancelar ni dejó vacío
			if( !input.isEmpty() && input != null ) {
				
				//se busca al equipo por id
				Equipo equipo = equipoDAO.getEquipoPorId(Integer.parseInt(input));
				
				//
				if(equipo != null) {
					
					//se printea el equipo recuperado por el ID introducido
					ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		        	if(equipo != null) {
		        		listaEquipos.add(equipo);
		        	}
		        	//se usa el metodo para imprimirlo en la tabla
		        	actualizarTablaEquipo(listaEquipos);
					
		        	//se parsea a int el input de antes
					int id = Integer.parseInt(input);
					
					//ventana de modificar jugador
	            	VentanaModificarEquipo ventanaModificar = new VentanaModificarEquipo();
	            	
	                // Solo creamos el controlador si tenemos un DNI válido
	            	new controladorModificarEquipo(ventanaModificar, id);
	                
	                ventanaModificar.setVisible(true);
	                
					return;
				}
				//si se introduce un ID que no coincide salta el WArning
				JOptionPane.showMessageDialog(null, "Advertencia: El ID introducido no existe", "Warning", JOptionPane.WARNING_MESSAGE);
				
			}
			
			//si el campo se deja vacio
			if (input.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Advertencia: Has dejado el campo vacio", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	
        	
        }

        // 9 - Salir
        if(e.getSource() == vista.btnSalir) {
        	
        	//ventana pop-up que pregunta si deseas salir o no
        	int verif = JOptionPane.showConfirmDialog(
        		    null, 
        		    "¿Estás seguro de que quieres cerrar la aplicación?", 
        		    "Salir", 
        		    JOptionPane.YES_NO_OPTION, 
        		    JOptionPane.QUESTION_MESSAGE // Esto añade el icono de pregunta
        		);
        	
        	if (verif == JOptionPane.YES_OPTION) System.exit(0);
        }

    }
 //==================================================================
//  verif es un 'int' por esto: 
//	1. El concepto de "Constantes"
//	En la clase JOptionPane, existen unos números fijos (constantes) que ya están definidos. Cuando tú comparas verif == JOptionPane.YES_OPTION, en realidad estás comparando números detrás de escena.
//
//			Si miras el código fuente de Java, verías algo como esto:
//
//			YES_OPTION vale 0
//
//			NO_OPTION vale 1
//
//			CANCEL_OPTION vale 2
//
//			CLOSED_OPTION vale -1 (si el usuario cierra la ventana con la "X")
  //=============================================================================  
    
    //=========================
    //METODOS AUXILIARES
    //=========================

    // Método para actualizar la JTable con una lista de jugadores
    private void actualizarTabla(ArrayList<Jugador> lista) {
        String[] columnas = {"DNI", "Nombre", "Apellido", "Salario (€)", "ID Equipo"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for(Jugador j : lista) {
            Object[] fila = {
                    j.getDni(),
                    j.getNombre(),
                    j.getApellido(),
                    j.getSalario(),
                    j.getIdEquipo()
            };
            model.addRow(fila);
        }

        vista.tabla.setModel(model);
    }
    
 // Método para actualizar la JTable con un JUGADOR
    private void actualizarTabla1(Jugador j) {
        String[] columnas = {"DNI", "Nombre", "Apellido", "Salario (€)", "ID Equipo"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        
            Object[] fila = {
                    j.getDni(),
                    j.getNombre(),
                    j.getApellido(),
                    j.getSalario(),
                    j.getIdEquipo()
            };
            model.addRow(fila);
    
        vista.tabla.setModel(model);
    }
    
    // Método para actualizar la JTable con una lista de EQUIPOS
    private void actualizarTablaEquipo(ArrayList<Equipo> lista) {
        String[] columnas = {"ID Equipo", "Nombre", "Ciudad"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for(Equipo e : lista) {
            Object[] fila = {
                    e.getIdEquipo(),
                    e.getNombre(),
                    e.getCiudad()
            };
            model.addRow(fila);
        }

        vista.tabla.setModel(model);
    }
}