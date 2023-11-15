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

public class ModificarCerámico extends JFrame implements ActionListener, ItemListener {

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
	private JButton btnGuardar;
	private static DatosCeramico ceramicoActual;
	private static int modelo;
	
	
	
	//Crea la GUI
	public ModificarCerámico() {
		super("Interfaz de Ceramicos");		
		setTitle("Modificar Cerámico");
		setSize(564, 199);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		
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
		cboModelo.addActionListener(this);
		cboModelo.addItemListener(this);
		getContentPane().add(cboModelo);
		
		modelo = cboModelo.getSelectedIndex();
		switch (modelo) {
			case 0:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusDefault.txt");
				break;
			
			case 1:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryDefault.txt");
				break;
			
			case 2:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaDefault.txt");
				break;
			
			case 3:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixDefault.txt");
				break;
			
			default:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaDefault.txt");
		}
		
		
		txtPrecio = new JTextField(String.valueOf(ceramicoActual.getPrecio()));
		txtPrecio.setEditable(true);
		txtPrecio.setBounds(116, 33, 292, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField(String.valueOf(ceramicoActual.getAncho()));
		txtAncho.setEditable(true);
		txtAncho.setColumns(10);
		txtAncho.setBounds(116, 58, 292, 20);
		getContentPane().add(txtAncho);
		
		txtLargo = new JTextField(String.valueOf(ceramicoActual.getLargo()));
		txtLargo.setEditable(true);
		txtLargo.setColumns(10);
		txtLargo.setBounds(116, 83, 292, 20);
		getContentPane().add(txtLargo);
		
		txtEspesor = new JTextField(String.valueOf(ceramicoActual.getEspesor()));
		txtEspesor.setEditable(true);
		txtEspesor.setColumns(10);
		txtEspesor.setBounds(116, 108, 292, 20);
		getContentPane().add(txtEspesor);
		
		txtContenido = new JTextField(ceramicoActual.getContenido());
		txtContenido.setEditable(true);
		txtContenido.setColumns(10);
		txtContenido.setBounds(116, 133, 292, 20);
		getContentPane().add(txtContenido);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(449, 32, 89, 23);
		btnGuardar.addActionListener(this);
		getContentPane().add(btnGuardar);
	
	}
    
		//Direcciona el botón
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==btnCerrar) {
				actionPerformedBtnCerrar(e);
			}
			
			if (e.getSource()==btnGuardar) {
				actionPerformedBtnGuardar(e);
			}
			
			if(e.getSource()==cboModelo) {
				actualizarDatosCeramico();
			}
		}
		
		//ACción cuando se selecciona el tipo de ceramico
		public void itemStateChanged(ItemEvent e) {
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	        	Modelo2(); 
	        }
	    }
		
		public static void Modelo2() {
						
			modelo = cboModelo.getSelectedIndex();
		
			switch(modelo) {
			case 0:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusDefault.txt");
				break;
			
			case 1:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryDefault.txt");
				break;
			
			case 2:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaDefault.txt");
				break;
			
			case 3:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixDefault.txt");
				break;
			
			default:
				ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaDefault.txt");
		
			}
		}			
		

		//Acción del botón Cerrar
		public void actionPerformedBtnCerrar (ActionEvent e ) {
			dispose();
		}
		
		public void actionPerformedBtnGuardar(ActionEvent e) {
	
			modelo = cboModelo.getSelectedIndex();
			switch (modelo) {
				case 0:
					guardarDatosCeramicoCinzaPlus();
					break;
				
				case 1:
					guardarDatosCeramicoLuxury();
					break;
				
				case 2:
					guardarDatosCeramicoAustria();
					break;
				
				case 3:
					guardarDatosCeramicoYungayMix();
					break;
				
				default:
					guardarDatosCeramicoThalia();
			}
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
	        txtContenido.setText(ceramicoActual.getContenido());
	    }
		
		private void guardarDatosCeramicoCinzaPlus() {
	        // Guardar los datos ingresados por el usuario en el objeto ceramicoActual
	        ceramicoActual.setPrecio(Double.parseDouble(txtPrecio.getText()));
	        ceramicoActual.setAncho(Double.parseDouble(txtAncho.getText()));
	        ceramicoActual.setLargo(Double.parseDouble(txtLargo.getText()));
	        ceramicoActual.setEspesor(Double.parseDouble(txtEspesor.getText()));
	        ceramicoActual.setContenido(txtContenido.getText());

	        // Guardar los datos en un archivo
	        ceramicoActual.guardarEnArchivoCinzaPlus("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
			
			
		}
		
		private void guardarDatosCeramicoLuxury() {
	        // Guardar los datos ingresados por el usuario en el objeto ceramicoActual
	        ceramicoActual.setPrecio(Double.parseDouble(txtPrecio.getText()));
	        ceramicoActual.setAncho(Double.parseDouble(txtAncho.getText()));
	        ceramicoActual.setLargo(Double.parseDouble(txtLargo.getText()));
	        ceramicoActual.setEspesor(Double.parseDouble(txtEspesor.getText()));
	        ceramicoActual.setContenido(txtContenido.getText());

	        // Guardar los datos en un archivo
	        ceramicoActual.guardarEnArchivoLuxury("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
			
			
		}
		
		private void guardarDatosCeramicoAustria() {
	        // Guardar los datos ingresados por el usuario en el objeto ceramicoActual
	        ceramicoActual.setPrecio(Double.parseDouble(txtPrecio.getText()));
	        ceramicoActual.setAncho(Double.parseDouble(txtAncho.getText()));
	        ceramicoActual.setLargo(Double.parseDouble(txtLargo.getText()));
	        ceramicoActual.setEspesor(Double.parseDouble(txtEspesor.getText()));
	        ceramicoActual.setContenido(txtContenido.getText());

	        // Guardar los datos en un archivo
	        ceramicoActual.guardarEnArchivoAustria("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
			
			
		}
		
		private void guardarDatosCeramicoYungayMix() {
	        // Guardar los datos ingresados por el usuario en el objeto ceramicoActual
	        ceramicoActual.setPrecio(Double.parseDouble(txtPrecio.getText()));
	        ceramicoActual.setAncho(Double.parseDouble(txtAncho.getText()));
	        ceramicoActual.setLargo(Double.parseDouble(txtLargo.getText()));
	        ceramicoActual.setEspesor(Double.parseDouble(txtEspesor.getText()));
	        ceramicoActual.setContenido(txtContenido.getText());

	        // Guardar los datos en un archivo
	        ceramicoActual.guardarEnArchivoYungayMix("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
			
			
		}
		
		private void guardarDatosCeramicoThalia() {
	        // Guardar los datos ingresados por el usuario en el objeto ceramicoActual
	        ceramicoActual.setPrecio(Double.parseDouble(txtPrecio.getText()));
	        ceramicoActual.setAncho(Double.parseDouble(txtAncho.getText()));
	        ceramicoActual.setLargo(Double.parseDouble(txtLargo.getText()));
	        ceramicoActual.setEspesor(Double.parseDouble(txtEspesor.getText()));
	        ceramicoActual.setContenido(txtContenido.getText());

	        // Guardar los datos en un archivo
	        ceramicoActual.guardarEnArchivoThalia("C:\\Users\\User\\git\\PrimerProyectoJAVA\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
			
			
		}
	}
