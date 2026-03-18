package view;

import javax.swing.*;
import java.awt.*;

public class VentanaModificarJugador extends JFrame {

    // Etiquetas
   // public JLabel lblDNI = new JLabel("DNI:");
    public JLabel lblNombre = new JLabel("Nombre:");
    public JLabel lblApellido = new JLabel("Apellido:");
    public JLabel lblSalario = new JLabel("Salario:");
    public JLabel lblIdEquipo = new JLabel("ID Equipo:");

    // Campos de entrada
   // public JTextField txtDNI = new JTextField(15);
    public JTextField txtNombre = new JTextField(15);
    public JTextField txtApellido = new JTextField(15);
    public JTextField txtSalario = new JTextField(15);
    public JTextField txtIdEquipo = new JTextField(15);

    // Botones
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnCerrar = new JButton("Cerrar");

    // TextArea para feedback
    public JTextArea txtFeedback = new JTextArea(10, 30);

    public VentanaModificarJugador() {
        setTitle("Modificar Jugador");
        setSize(400, 450);
        setLocationRelativeTo(null); // Centrar en pantalla
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Solo cerrar esta ventana

        // Layout principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiquetas y campos
//        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblDNI, gbc);
//        gbc.gridx = 1; panel.add(txtDNI, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblNombre, gbc);
        gbc.gridx = 1; panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblApellido, gbc);
        gbc.gridx = 1; panel.add(txtApellido, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblSalario, gbc);
        gbc.gridx = 1; panel.add(txtSalario, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblIdEquipo, gbc);
        gbc.gridx = 1; panel.add(txtIdEquipo, gbc);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension tamañoBoton = new Dimension(120, 25);
        btnActualizar.setPreferredSize(tamañoBoton);
        btnCerrar.setPreferredSize(tamañoBoton);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnCerrar);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(panelBotones, gbc);

        // Feedback JTextArea con scroll
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        JScrollPane scroll = new JScrollPane(txtFeedback);
        panel.add(scroll, gbc);

        add(panel);
        setVisible(true);
    }
}
