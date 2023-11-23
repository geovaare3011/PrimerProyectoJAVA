package Experimentos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuardadosP2 extends JFrame {

    private JPanel contentPane;
    private JTextField txtVariable1;
    private JTextField txtVariable2;
    private JTextField txtVariable3;
    private JTextField txtVariable4;

    private Preferences preferences;
    private JButton btnPredeterminados;
	private JButton btnGuardar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuardadosP2 frame = new GuardadosP2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GuardadosP2() {
        setTitle("Guardado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 558, 379);
        contentPane = new JPanel();
        setResizable(false);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        preferences = Preferences.userRoot().node(this.getClass().getName());

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(429, 25, 89, 23);
        contentPane.add(btnGuardar);

        txtVariable1 = createDecimalField();
        txtVariable1.setBounds(118, 82, 247, 20);
        contentPane.add(txtVariable1);

        txtVariable2 = createDecimalField();
        txtVariable2.setBounds(118, 117, 247, 20);
        contentPane.add(txtVariable2);

        txtVariable3 = createDecimalField();
        txtVariable3.setBounds(118, 148, 247, 20);
        contentPane.add(txtVariable3);

        txtVariable4 = createIntegerField();
        txtVariable4.setBounds(118, 185, 247, 20);
        contentPane.add(txtVariable4);

        btnPredeterminados = new JButton("Predeterminados");
        btnPredeterminados.setBounds(375, 64, 143, 23);
        contentPane.add(btnPredeterminados);

        cargarValoresGuardados();

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guardarValores()) {
                    JOptionPane.showMessageDialog(contentPane, "Valores guardados correctamente");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Por favor, ingrese valores válidos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnPredeterminados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(contentPane,
                        "¿Desea restablecer los valores predeterminados?", "Restablecer predeterminados",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    restablecerPredeterminados();
                }
            }
        });
    }

    private JTextField createDecimalField() {
        JTextField textField = new JTextField();
        return textField;
    }

    private JTextField createIntegerField() {
        JTextField textField = new JTextField();
        return textField;
    }

    private void cargarValoresGuardados() {
        txtVariable1.setText(preferences.get("variable1", ""));
        txtVariable2.setText(preferences.get("variable2", ""));
        txtVariable3.setText(preferences.get("variable3", ""));
        txtVariable4.setText(preferences.get("variable4", ""));
    }

    private boolean guardarValores() {
        String var1 = txtVariable1.getText();
        String var2 = txtVariable2.getText();
        String var3 = txtVariable3.getText();
        String var4 = txtVariable4.getText();

        if (isValidDouble(var1) && isValidDouble(var2) && isValidDouble(var3) && isValidInteger(var4)) {
            preferences.put("variable1", var1);
            preferences.put("variable2", var2);
            preferences.put("variable3", var3);
            preferences.put("variable4", var4);
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void restablecerPredeterminados() {
        double a = 1.2;
        double b = 2.7;
        double c = 1.5;
        int d = 72;

        txtVariable1.setText(Double.toString(a));
        txtVariable2.setText(Double.toString(b));
        txtVariable3.setText(Double.toString(c));
        txtVariable4.setText(Integer.toString(d));
    }
}
