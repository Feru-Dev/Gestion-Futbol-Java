package model;

public class Jugador {
    // Atributos (coinciden con los campos de la base de datos)
    private String dni;
    private String nombre;
    private String apellido;
    private double salario;
    private int idEquipo;

    // Constructores
    public Jugador() {}

    public Jugador(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Jugador(String dni, String nombre, String apellido, double salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public Jugador(String dni, String nombre, String apellido, double salario, int idEquipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.idEquipo = idEquipo;
    }

    // Getters y setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    // Representación en texto
    @Override
    public String toString() {
        return "Jugador:\n" +
               "  DNI: " + dni + "\n" +
               "  Nombre: " + nombre + "\n" +
               "  Apellido: " + apellido + "\n" +
               "  Salario: " + salario + "€\n" +
               "  ID Equipo: " + idEquipo + "\n";
    }
}