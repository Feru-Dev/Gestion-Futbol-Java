package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class VentanaModificarEquipo extends JFrame {

    // Etiquetas
   // public JLabel lblDNI = new JLabel("DNI:");
    public JLabel lblNombre = new JLabel("Nombre:");
    public JLabel lblCiudad = new JLabel("Ciudad:");


    // Campos de entrada
   // public JTextField txtDNI = new JTextField(15);
    public JTextField txtNombre = new JTextField(15);
    public JTextField txtCiudad = new JTextField(15);
    

    // Botones
    public JButton btnActualizar = new JButton("Actualizar");
    public JButton btnCerrar = new JButton("Cerrar");

    // TextArea para feedback
    public JTextArea txtFeedback = new JTextArea(10, 30);

    public VentanaModificarEquipo() {
        setTitle("Modificar Equipo");
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

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblNombre, gbc);
        gbc.gridx = 1; panel.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblCiudad, gbc);
        gbc.gridx = 1; panel.add(txtCiudad, gbc);

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
