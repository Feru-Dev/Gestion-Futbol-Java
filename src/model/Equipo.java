package model;

public class Equipo {

	//parametros
	private int idEquipo;
	private String nombre;
	private String ciudad;
	
	//constructores
	public Equipo() {
		
	}
	
	public Equipo(int idEquipo, String nombre, String ciudad) {
		super();
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	//getters y setters

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	//metodo To String
	@Override
	public String toString() {
		return "Equipo: \n"
				+ "idEquipo=" + idEquipo 
				+ ", nombre=" + nombre 
				+ ", ciudad=" + ciudad + "]";
	}
	
	
	
	
}
