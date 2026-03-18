package view;

import controller.Controlador;

public class Main {

    public static void main(String[] args) {

        // Crear la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal();

        // Inicializar el controlador (MVC)
        new Controlador(ventana);
    }
}
