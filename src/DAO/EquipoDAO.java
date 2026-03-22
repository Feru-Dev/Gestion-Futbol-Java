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
	
	//================================
	//BUSCAR EQUIPO POR ID
	//================================
    public Equipo getEquipoPorId(int id) {
    	Equipo equipo = null;
        String consulta = "SELECT * FROM equipos WHERE idEquipo='" + id + "';";

        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(consulta)) {

            if(rs.next()) {
            	
            	equipo = new Equipo();
            	
            	equipo.setIdEquipo(rs.getInt("idEquipo"));
            	equipo.setNombre(rs.getString("nombre"));
            	equipo.setCiudad(rs.getString("ciudad"));
            }

        } catch (SQLException e) {
            System.err.println("Error en getJugadorPorDNI: " + e.getMessage());
        }

        return equipo; // Devuelve el equipo o null si no existe
    }
   
    //================================
  	//Modificar Jugador por DNI
  	//================================
    public void ModificarEquipoPorId(Equipo equipo) {
    	
    	//sentencia SQL
    	String sql = "UPDATE EQUIPOS SET NOMBRE=?, CIUDAD=? WHERE IDEQUIPO=?;";
    	
    	try(Connection con = DbConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(sql)){
    		
    		ps.setString(1, equipo.getNombre());
    		ps.setString(2, equipo.getCiudad());
    		ps.setInt(3, equipo.getIdEquipo());
    		
    		ps.executeUpdate();
    		
    		System.out.println("Equipo Modificado Correctamente");
    		
    	} catch (SQLException e) {
            System.err.println("Error en ModificarEquipoPorId: " + e.getMessage());
        }
    	
    	
    }
}
