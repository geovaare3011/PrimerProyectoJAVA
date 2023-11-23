package Experimentos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransVarial extends JFrame {

    private int a = 2;  // Tu variable

    private JTextField textField;

    public TransVarial() {
        // Configurar la interfaz gráfica
        JPanel panel = new JPanel();
        textField = new JTextField(5);
        JButton button = new JButton("Modificar Variable");

        panel.add(textField);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor del JTextField y convertirlo a entero
                String input = textField.getText();
                try {
                    int nuevoValor = Integer.parseInt(input);
                    // Modificar la variable 'a' con el nuevo valor
                    a = nuevoValor;
                    System.out.println("La variable a ha sido modificada a: " + a);
                } catch (NumberFormatException ex) {
                    System.out.println("Ingrese un número válido.");
                }
            }
        });

        // Configurar la ventana
        this.setTitle("Modificación de Variable");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TransVarial();
    }
}
