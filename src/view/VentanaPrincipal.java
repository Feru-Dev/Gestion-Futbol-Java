package view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    // Botones principales
    public JButton btnVerJugadores = new JButton("1 - Ver Jugadores");
    public JButton btnAgregarJugador = new JButton("2 - Agregar Jugador");
    public JButton btnBuscarJugador = new JButton("3 - Buscar Jugador por DNI");
    public JButton btnModificarJugador = new JButton("4 - Modificar Jugador por DNI");
    public JButton btnVerEquipos = new JButton("5 - Ver Equipos");
    public JButton btnAgregarEquipo = new JButton("6 - Agregar Equipos");
    public JButton btnBuscarEquipo = new JButton("7 - Buscar Equipo por ID");
    public JButton btnModificarEquipo = new JButton("8 - Modificar Equipo por ID");
    public JButton btnSalir = new JButton("9 - Salir");

    // JTable para mostrar los jugadores
    public JTable tabla = new JTable();

    public VentanaPrincipal() {
        setTitle("Gestión de Fútbol - MVC");
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Layout principal BorderLayout
        setLayout(new BorderLayout(10, 10));

        // Panel de botones (GridLayout: 9 filas, 1 columna)
        JPanel panelBotones = new JPanel(new GridLayout(9, 1, 10, 10));

        // Array de botones
        JButton[] botones = {
            btnVerJugadores,
            btnAgregarJugador,
            btnBuscarJugador,
            btnModificarJugador,
            btnVerEquipos,
            btnAgregarEquipo,
            btnBuscarEquipo,
            btnModificarEquipo,
            btnSalir
        };

        // Color y tamaño uniforme de botones
        Dimension tamañoBoton = new Dimension(150, 30);
        Color[] colores = {
            new Color(135, 206, 250), // azul claro
            new Color(255, 182, 193), // rosa claro
            new Color(144, 238, 144), // verde claro
            new Color(135, 206, 250), // azul claro
            new Color(255, 182, 193), // rosa claro
            new Color(144, 238, 144), // verde claro
            new Color(135, 206, 250), // azul claro
            new Color(255, 182, 193), // rosa claro
            new Color(255, 255, 102)  // amarillo claro
        };

        // Añadir botones al panel
        for (int i = 0; i < botones.length; i++) {
            JButton b = botones[i];
            b.setPreferredSize(tamañoBoton);
            b.setBackground(colores[i]);
            b.setOpaque(true);
            b.setBorderPainted(true);
            b.setFont(new Font("Arial", Font.PLAIN, 12));
            panelBotones.add(b);
        }

        // Centrar panel de botones
        JPanel panelBotonesCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonesCentro.add(panelBotones);

        // JTable en scroll
        tabla.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tabla);

        // Añadir paneles a la ventana
        add(panelBotonesCentro, BorderLayout.WEST); // botones a la izquierda
        add(scroll, BorderLayout.CENTER);            // tabla en el centro

        setVisible(true);
    }
}
