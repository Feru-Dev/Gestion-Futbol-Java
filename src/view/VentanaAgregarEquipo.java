package view;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarEquipo extends JFrame {

    // Etiquetas
    public JLabel lblEquipoId = new JLabel("Id Equipo:");
    public JLabel lblNombre = new JLabel("Nombre:");
    public JLabel lblCiudad = new JLabel("Ciudad:");

    // Campos de entrada
    public JTextField txtEquipoId = new JTextField(15);
    public JTextField txtNombre = new JTextField(15);
    public JTextField txtCiudad = new JTextField(15);

    // Botones
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnCerrar = new JButton("Cerrar");

    // TextArea para feedback
    public JTextArea txtFeedback = new JTextArea(10, 30);

    //Constructor de la ventana
    public VentanaAgregarEquipo() {
        setTitle("Agregar Equipo");
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
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblEquipoId, gbc);
        gbc.gridx = 1; panel.add(txtEquipoId, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblNombre, gbc);
        gbc.gridx = 1; panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblCiudad, gbc);
        gbc.gridx = 1; panel.add(txtCiudad, gbc);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension tamañoBoton = new Dimension(120, 25);
        btnAgregar.setPreferredSize(tamañoBoton);
        btnCerrar.setPreferredSize(tamañoBoton);
        panelBotones.add(btnAgregar);
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
