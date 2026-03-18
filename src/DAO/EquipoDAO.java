package DAO;

import java.util.*;
import java.io.*;
import java.sql.*;
import model.*;

public class EquipoDAO {

	//================================
	//Ver todos los EQUIPOS
	//================================
	
	public ArrayList<Equipo> getListaEquipos(){
		
		//se crea la lista
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		//sentencia SQL
		String sql = "SELECT * FROM EQUIPOS";
		
		try(Connection con = DbConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql)){
			
			while(resultSet.next()) {
				//se crea un equipo
				Equipo e = new Equipo();
				
				e.setIdEquipo(resultSet.getInt("idEquipo"));
				e.setNombre(resultSet.getString("nombre"));
				e.setCiudad(resultSet.getString("ciudad"));
				
				listaEquipos.add(e);
			}
			
		}catch(SQLException e) {
			System.err.println("Error en Ver todos los Equipos DAO " + e.getMessage());
		}

		return listaEquipos;
	}
	
	//================================
	//AGREGAR EQUIPO
	//================================
	
	public void agregarEquipo(Equipo equipo) {
		
		//sentencia SQL
		String sql = "INSERT INTO EQUIPOS VALUES(?, ?, ?);";
		
		try(Connection con  = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, equipo.getIdEquipo());
			ps.setString(2, equipo.getNombre());
			ps.setString(3, equipo.getCiudad());
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.err.println("Error en agregar Equipo DAO" + e.getMessage());
		}
		
	}
}
