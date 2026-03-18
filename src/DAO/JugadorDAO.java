package DAO;

import java.sql.*;
import java.util.ArrayList;

import model.Jugador;

// DAO para gestionar jugadores en la base de datos
public class JugadorDAO {

    // 1. Obtener todos los jugadores
    // Recupera todos los registros de la tabla "futbolistas"
    public ArrayList<Jugador> getJugadores() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        // Try-with-resources para cerrar automáticamente la conexión, el statement y el resultset
        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM futbolistas;")) {

            // Mientras haya registros, se crean objetos Futbolista y se agregan a la lista
            while (rs.next()) {
            	Jugador jugador = new Jugador();
                jugador.setDni(rs.getString("dni"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setApellido(rs.getString("apellido"));
                jugador.setSalario(rs.getInt("salario"));
                jugador.setIdEquipo(rs.getInt("idEquipo"));
                listaJugadores.add(jugador);
            }

        } catch (SQLException e) {
            System.err.println("Error en getJugadores: " + e.getMessage());
        }

        return listaJugadores; // Devuelve la lista de jugadores
    }

    // 2. Agregar un jugador
    public void agregarJugador(Jugador jugador) {
        String consulta = "INSERT INTO futbolistas (dni,nombre,apellido,salario,idEquipo) VALUES ('"
                + jugador.getDni() + "','" 
                + jugador.getNombre() + "','" 
                + jugador.getApellido() + "'," 
                + jugador.getSalario() + "," 
                + jugador.getIdEquipo() + ");";

        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate(consulta);

        } catch (SQLException e) {
            System.err.println("Error en agregarJugador: " + e.getMessage());
        }
    }

    // 3. Obtener jugador por DNI
    public Jugador getJugadorPorDNI(String dni) {
    	Jugador jugador = null;
        String consulta = "SELECT * FROM futbolistas WHERE dni='" + dni + "';";

        try (Connection con = DbConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(consulta)) {

            if(rs.next()) {
                jugador = new Jugador(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("salario"),
                        rs.getInt("idEquipo")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error en getJugadorPorDNI: " + e.getMessage());
        }

        return jugador; // Devuelve el jugador o null si no existe
    }
    
    // 4. Modificar Jugador por DNI
    public void ModificarJugadorPorDNI(Jugador jugador) {
    	
    	//sentencia SQL
    	String sql = "UPDATE FUTBOLISTAS SET NOMBRE=?, APELLIDO=?, SALARIO=?, IDEQUIPO=? WHERE DNI=?;";
    	
    	try(Connection con = DbConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(sql)){
    		
    		ps.setString(1, jugador.getNombre());
    		ps.setString(2, jugador.getApellido());
    		ps.setDouble(3, jugador.getSalario());
    		ps.setInt(4, jugador.getIdEquipo());
    		ps.setString(5, jugador.getDni());
    		
    		ps.executeUpdate();
    		
    		System.out.println("Jugador Modificado Correctamente");
    		
    	} catch (SQLException e) {
            System.err.println("Error en ModificarJugadorPorDNI: " + e.getMessage());
        }
    	
    	
    }
    
    
    
    
    
    
    
}