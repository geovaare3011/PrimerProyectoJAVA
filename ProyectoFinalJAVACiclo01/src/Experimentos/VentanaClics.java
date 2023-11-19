package Experimentos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaClics extends JFrame {

    private int contadorClics = 0;

    public VentanaClics() {
        // Configuración de la ventana
        setTitle("Contador de Clics");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Botón en el medio de la ventana
        JButton boton = new JButton("Clic aquí");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Incrementa el contador de clics
                contadorClics++;

                // Muestra un JOptionPane cada 5 clics
                if (contadorClics % 5 == 0) {
                    JOptionPane.showMessageDialog(VentanaClics.this, "Has realizado " + contadorClics + " clics", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }

                // Actualiza el título de la ventana con la suma de los clics
                setTitle("Contador de Clics - Total: " + contadorClics);
            }
        });

        // Añade el botón al centro de la ventana
        getContentPane().add(boton);
    }

    public static void main(String[] args) {
        // Configura la apariencia de la interfaz de usuario con el estilo de Windows
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Crea una instancia de la ventana
        VentanaClics ventana = new VentanaClics();

        // Hace visible la ventana
        ventana.setVisible(true);
    }
}
