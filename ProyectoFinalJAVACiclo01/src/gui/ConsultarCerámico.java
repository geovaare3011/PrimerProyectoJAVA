package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;



public class ConsultarCerámico extends JFrame implements ActionListener , ItemListener{
	private static final long serialVersionUID = 1L;
	private JButton btnCerrar;
	private JLabel lblContenido;
	private JLabel lblEspesor;
	private JLabel lblLargo;
	private JLabel lblAncho;
	private JLabel lblPrecios;
	private JLabel lblModelo;
	private static JComboBox<String> cboModelo;
	private static JTextField txtPrecio;
	private static JTextField txtAncho;
	private static JTextField txtLargo;
	private static JTextField txtEspesor;
	private static JTextField txtContenido;
	
	

	//Crea la GUI
	public ConsultarCerámico() {
		
		setTitle("Consultar cerámico");
		setSize(564, 199);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
				
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 83, 14);
		getContentPane().add(lblModelo);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(10, 36, 83, 14);
		getContentPane().add(lblPrecios);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 61, 83, 14);
		getContentPane().add(lblAncho);
		
		lblLargo = new JLabel("Largo (cm)");
		lblLargo.setBounds(10, 86, 83, 14);
		getContentPane().add(lblLargo);
		
		lblEspesor = new JLabel("Espesor (mm)");
		lblEspesor.setBounds(10, 111, 83, 14);
		getContentPane().add(lblEspesor);
		
		lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(10, 136, 83, 14);
		getContentPane().add(lblContenido);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(449, 7, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía"}));
		cboModelo.setBounds(116, 7, 292, 22);
		cboModelo.addItemListener(this);		
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(116, 33, 292, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(116, 58, 292, 20);
		getContentPane().add(txtAncho);
		
		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setColumns(10);
		txtLargo.setBounds(116, 83, 292, 20);
		getContentPane().add(txtLargo);
		
		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(116, 108, 292, 20);
		getContentPane().add(txtEspesor);
		
		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setColumns(10);
		txtContenido.setBounds(116, 133, 292, 20);
		getContentPane().add(txtContenido);
	}

	
	//Direcciona el botón
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	//Acción del botón Cerrar
	public void actionPerformedBtnCerrar (ActionEvent e ) {
		dispose();
	}
	
	//Cambio de datos según la selección del cliente
	public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Modelo(); 
        }
    }
	
	
	public static void Modelo() {
		
		int modelo;		
		
		modelo = cboModelo.getSelectedIndex(); 
		
		switch(modelo) {
		
			case 0:
				txtPrecio.setText("92.56");
				txtAncho.setText("62.0");
				txtLargo.setText("62.0");
				txtEspesor.setText("8");
				txtContenido.setText("6");
				break;
			
			case 1:
				txtPrecio.setText("42.77");
				txtAncho.setText("60");
				txtLargo.setText("60");
				txtEspesor.setText("8.5");
				txtContenido.setText("4");
				break;
			
			case 2:
				txtPrecio.setText("52.45");
				txtAncho.setText("45");
				txtLargo.setText("45");
				txtEspesor.setText("6.5");
				txtContenido.setText("12");
				break;
				
			case 3:
				txtPrecio.setText("55.89");
				txtAncho.setText("80");
				txtLargo.setText("120");
				txtEspesor.setText("6.8");
				txtContenido.setText("9");
				break;
				
			default:
				txtPrecio.setText("45");
				txtAncho.setText("45");
				txtLargo.setText("11.8");
				txtEspesor.setText("7.2");
				txtContenido.setText("10");				
				
		}
		
	}
		
}
	
	
		 
