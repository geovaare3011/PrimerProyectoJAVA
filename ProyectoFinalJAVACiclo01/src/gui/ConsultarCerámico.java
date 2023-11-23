package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DatosDeCeramicos.DatosCeramico;

public class ConsultarCerámico extends JFrame implements ActionListener, ItemListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblModelo;
	private JLabel lblPrecios;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblEspesor;
	private JLabel lblContenido;
	private JButton btnCerrar;
	private static JComboBox<String> cboModelo;
	private static JTextField txtPrecio;
	private static JTextField txtAncho;
	private static JTextField txtLargo;
	private static JTextField txtEspesor;
	private static JTextField txtContenido;
	private static DatosCeramico ceramicoActual;
	private static int modelo;
	
	

	//Crea la GUI
	public ConsultarCerámico() {
		
		setTitle("Consultar cerámico");
		setSize(564, 199);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
	
	private void actualizarDatosCeramico() {
        // Actualizar ceramicoActual con los datos del tipo de cerámico seleccionado
        String tipoSeleccionado = (String) cboModelo.getSelectedItem();
        ceramicoActual.setTipo(tipoSeleccionado);

        // Actualizar los JTextFields con los nuevos datos
        txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
        txtAncho.setText(String.valueOf(ceramicoActual.getAncho()));
        txtLargo.setText(String.valueOf(ceramicoActual.getLargo()));
        txtEspesor.setText(String.valueOf(ceramicoActual.getEspesor()));
        txtContenido.setText(ceramicoActual.getCantidad());
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
		
		modelo = cboModelo.getSelectedIndex();
		
		switch(modelo) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus(DatosCeramico.ruta + "Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury(DatosCeramico.ruta + "Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria(DatosCeramico.ruta + "Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix(DatosCeramico.ruta + "Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia(DatosCeramico.ruta + "Modelos\\ThaliaEdit.txt");
		}
		
		txtPrecio = new JTextField(String.valueOf(ceramicoActual.getPrecio()));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(116, 33, 292, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField(String.valueOf(ceramicoActual.getAncho()));
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(116, 58, 292, 20);
		getContentPane().add(txtAncho);
		
		txtLargo = new JTextField(String.valueOf(ceramicoActual.getLargo()));
		txtLargo.setEditable(false);
		txtLargo.setColumns(10);
		txtLargo.setBounds(116, 83, 292, 20);
		getContentPane().add(txtLargo);
		
		txtEspesor = new JTextField(String.valueOf(ceramicoActual.getEspesor()));
		txtEspesor.setEditable(false);
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(116, 108, 292, 20);
		getContentPane().add(txtEspesor);
		
		txtContenido = new JTextField(ceramicoActual.getCantidad());
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
			if(e.getSource()==cboModelo) {
				actualizarDatosCeramico();
			
		}
	}

	//Acción del botón Cerrar
	public void actionPerformedBtnCerrar (ActionEvent e ) {
		dispose();
	}
	
	//Cambio de datos según la selección del cliente
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
	        Modelo2();
	        actualizarDatosCeramico();  // Agrega esta línea
	    }
	}

	
	public static void Modelo2() {
		
		modelo = cboModelo.getSelectedIndex();
	
		switch(modelo) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus(DatosCeramico.ruta + "Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury(DatosCeramico.ruta + "Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria(DatosCeramico.ruta + "Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix(DatosCeramico.ruta + "Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia(DatosCeramico.ruta + "Modelos\\ThaliaEdit.txt");
	
		}
	}	
	
	
	public static void Modelo() {
		
		int modelo;		
		
		modelo = cboModelo.getSelectedIndex(); 
		
		switch(modelo) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus(DatosCeramico.ruta + "Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury(DatosCeramico.ruta + "Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria(DatosCeramico.ruta + "Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix(DatosCeramico.ruta + "Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia(DatosCeramico.ruta + "Modelos\\ThaliaEdit.txt");
	
		}
		
	}
		
}
	
	
		 
