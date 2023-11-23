package Experimentos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.prefs.Preferences;

public class Guardados extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtVariable1;
    private JTextField txtVariable2;
    private JTextField txtVariable3;
    private JTextField txtVariable4;

    private Preferences preferences;
    private JButton btnPredeterminados;

    // Valores predeterminados
    private double a = 1.2;
    private double b = 2.7;
    private double c = 1.5;
    private int d = 72;
	private JButton btnGuardar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Guardados frame = new Guardados();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Guardados() {
        setTitle("Guardado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 558, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        preferences = Preferences.userRoot().node(this.getClass().getName());

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(429, 25, 89, 23);
        contentPane.add(btnGuardar);

        txtVariable1 = new JTextField();
        txtVariable1.setBounds(118, 82, 247, 20);
        contentPane.add(txtVariable1);
        txtVariable1.setColumns(10);

        txtVariable2 = new JTextField();
        txtVariable2.setBounds(118, 117, 247, 20);
        contentPane.add(txtVariable2);
        txtVariable2.setColumns(10);

        txtVariable3 = new JTextField();
        txtVariable3.setColumns(10);
        txtVariable3.setBounds(118, 148, 247, 20);
        contentPane.add(txtVariable3);

        txtVariable4 = new JTextField();
        txtVariable4.setColumns(10);
        txtVariable4.setBounds(118, 185, 247, 20);
        contentPane.add(txtVariable4);
        txtVariable4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Elimina el carácter si no es un dígito
                    JOptionPane.showMessageDialog(null, "Solo se permiten números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        btnPredeterminados = new JButton("Predeterminados");
        btnPredeterminados.setBounds(375, 64, 143, 23);
        contentPane.add(btnPredeterminados);

        // Cargar valores al iniciar
        cargarValoresGuardados();

        // Configurar acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarValores();
            }
        });

        // Configurar acción del botón Predeterminados
        btnPredeterminados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Quieres restaurar los valores predeterminados?",
                        "Restaurar Predeterminados", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    cargarValoresPredeterminados();
                }
            }
        });
    }

    private void cargarValoresGuardados() {
        txtVariable1.setText(preferences.get("variable1", String.valueOf(a)));
        txtVariable2.setText(preferences.get("variable2", String.valueOf(b)));
        txtVariable3.setText(preferences.get("variable3", String.valueOf(c)));
        txtVariable4.setText(preferences.get("variable4", String.valueOf(d)));
    }

    private void cargarValoresPredeterminados() {
        txtVariable1.setText(String.valueOf(a));
        txtVariable2.setText(String.valueOf(b));
        txtVariable3.setText(String.valueOf(c));
        txtVariable4.setText(String.valueOf(d));
    }

    private void guardarValores() {
        preferences.put("variable1", txtVariable1.getText());
        preferences.put("variable2", txtVariable2.getText());
        preferences.put("variable3", txtVariable3.getText());
        preferences.put("variable4", txtVariable4.getText());
    }
}
