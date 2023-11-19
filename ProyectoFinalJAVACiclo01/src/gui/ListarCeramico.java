package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;


import DatosDeCeramicos.DatosCeramico;



public class ListarCeramico extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JButton btnCerrar;
	private JButton btnListar;
	private  JTextArea txtR;
	private JScrollPane scrollPane;

	private static DatosCeramico ceramicoActual0;

	private static DatosCeramico ceramicoActual1;

	private static DatosCeramico ceramicoActual2;

	private static DatosCeramico ceramicoActual3;

	private static DatosCeramico ceramicoActual4;
	public static JTextField txtPrecio0;
	public static JTextField txtCantidad0;
	public static JTextField txtAncho0;
	public static JTextField txtLargo0;
	public static JTextField txtEspesor0;
	public static JTextField txtPrecio1;
	public static JTextField txtCantidad1;
	public static JTextField txtAncho1;
	public static JTextField txtLargo1;
	public static JTextField txtEspesor1;
	public static JTextField txtPrecio2;
	public static JTextField txtCantidad2;
	public static JTextField txtAncho2;
	public static JTextField txtLargo2;
	public static JTextField txtEspesor2;
	public static JTextField txtPrecio3;
	public static JTextField txtCantidad3;
	public static JTextField txtAncho3;
	public static JTextField txtLargo3;
	public static JTextField txtEspesor3;
	public static JTextField txtPrecio4;
	public static JTextField txtCantidad4;
	public static JTextField txtAncho4;
	public static JTextField txtLargo4;
	public static JTextField txtEspesor4;


	public void actualizarDatosCeramico() {
		
        // Actualizar ceramicoActual con los datos del tipo de cerámico seleccionado
        // Actualizar los JTextFields con los nuevos datos
        txtPrecio0.setText(String.valueOf(ceramicoActual0.getPrecio()));
        txtAncho0.setText(String.valueOf(ceramicoActual0.getAncho()));
        txtLargo0.setText(String.valueOf(ceramicoActual0.getLargo()));
        txtEspesor0.setText(String.valueOf(ceramicoActual0.getEspesor()));
        txtCantidad0.setText(ceramicoActual0.getCantidad());

        txtPrecio1.setText(String.valueOf(ceramicoActual1.getPrecio()));
        txtAncho1.setText(String.valueOf(ceramicoActual1.getAncho()));
        txtLargo1.setText(String.valueOf(ceramicoActual1.getLargo()));
        txtEspesor1.setText(String.valueOf(ceramicoActual1.getEspesor()));
        txtCantidad1.setText(ceramicoActual1.getCantidad());
        
        txtPrecio2.setText(String.valueOf(ceramicoActual2.getPrecio()));
        txtAncho2.setText(String.valueOf(ceramicoActual2.getAncho()));
        txtLargo2.setText(String.valueOf(ceramicoActual2.getLargo()));
        txtEspesor2.setText(String.valueOf(ceramicoActual2.getEspesor()));
        txtCantidad2.setText(ceramicoActual2.getCantidad());
        
        txtPrecio3.setText(String.valueOf(ceramicoActual3.getPrecio()));
        txtAncho3.setText(String.valueOf(ceramicoActual3.getAncho()));
        txtLargo3.setText(String.valueOf(ceramicoActual3.getLargo()));
        txtEspesor3.setText(String.valueOf(ceramicoActual3.getEspesor()));
        txtCantidad3.setText(ceramicoActual3.getCantidad());
        
        txtPrecio4.setText(String.valueOf(ceramicoActual4.getPrecio()));
        txtAncho4.setText(String.valueOf(ceramicoActual4.getAncho()));
        txtLargo4.setText(String.valueOf(ceramicoActual4.getLargo()));
        txtEspesor4.setText(String.valueOf(ceramicoActual4.getEspesor()));
        txtCantidad4.setText(ceramicoActual4.getCantidad());
        
        
    }
	
	//CRea la GUI
	public ListarCeramico() {
		
		setTitle("Listar cerámico");
		setSize(564, 366);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
		
	public void iniciarComponentes() {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 528, 271);
		getContentPane().add(scrollPane);
		
		txtR = new JTextArea();
		txtR.setEditable(false);
		txtR.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtR);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(274, 293, 89, 23);
		btnListar.addActionListener(this);
		getContentPane().add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(175, 293, 89, 23);
		getContentPane().add(btnCerrar);
	}

	//Direccionando los botones
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource()==btnListar) {
			actionPerformedActualizar(e);
		}
		if(e.getSource()==btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	
	public void actionPerformedActualizar(ActionEvent e) {
		
		ceramicoActual0 = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");

		ceramicoActual1 = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");

		ceramicoActual2 = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");

		ceramicoActual3 = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");

		ceramicoActual4 = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
	
		
		txtPrecio0 = new JTextField(String.valueOf(ceramicoActual0.getPrecio()));
		txtAncho0 = new JTextField(String.valueOf(ceramicoActual0.getAncho()));
		txtLargo0 = new JTextField(String.valueOf(ceramicoActual0.getLargo()));
		txtEspesor0 = new JTextField(String.valueOf(ceramicoActual0.getEspesor()));
		txtCantidad0 = new JTextField(String.valueOf(ceramicoActual0.getCantidad()));
		
		txtPrecio1 = new JTextField(String.valueOf(ceramicoActual1.getPrecio()));
		txtAncho1 = new JTextField(String.valueOf(ceramicoActual1.getAncho()));
		txtLargo1 = new JTextField(String.valueOf(ceramicoActual1.getLargo()));
		txtEspesor1 = new JTextField(String.valueOf(ceramicoActual1.getEspesor()));
		txtCantidad1 = new JTextField(String.valueOf(ceramicoActual1.getCantidad()));
		
		txtPrecio2 = new JTextField(String.valueOf(ceramicoActual2.getPrecio()));
		txtAncho2 = new JTextField(String.valueOf(ceramicoActual2.getAncho()));
		txtLargo2 = new JTextField(String.valueOf(ceramicoActual2.getLargo()));
		txtEspesor2 = new JTextField(String.valueOf(ceramicoActual2.getEspesor()));
		txtCantidad2 = new JTextField(String.valueOf(ceramicoActual2.getCantidad()));
		
		txtPrecio3 = new JTextField(String.valueOf(ceramicoActual3.getPrecio()));
		txtAncho3 = new JTextField(String.valueOf(ceramicoActual3.getAncho()));
		txtLargo3 = new JTextField(String.valueOf(ceramicoActual3.getLargo()));
		txtEspesor3 = new JTextField(String.valueOf(ceramicoActual3.getEspesor()));
		txtCantidad3 = new JTextField(String.valueOf(ceramicoActual3.getCantidad()));
		
		txtPrecio4 = new JTextField(String.valueOf(ceramicoActual4.getPrecio()));
		txtAncho4 = new JTextField(String.valueOf(ceramicoActual4.getAncho()));
		txtLargo4 = new JTextField(String.valueOf(ceramicoActual4.getLargo()));
		txtEspesor4 = new JTextField(String.valueOf(ceramicoActual4.getEspesor()));
		txtCantidad4 = new JTextField(String.valueOf(ceramicoActual4.getCantidad()));
	}
	
	
	//Acción que hará el botón Cerrar
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	//Acción que hará el botón Listar
	public void actionPerformedBtnListar(ActionEvent e) {
		txtR.setText("LISTADO DE CERÁMICOS" + "\n");
		txtR.append("" + "\n");
	   if (txtPrecio0.getText().isEmpty()) {
		txtR.append("Contenido de txtPrecio: [" + txtPrecio0.getText() + "]" + "\n");
	    txtR.append("El campo de precio está vacío");
		
	    } else {
	    	
	    	double precio0 = Double.parseDouble(txtPrecio0.getText());
		    double ancho0 = Double.parseDouble(txtAncho0.getText());
		    double largo0 = Double.parseDouble(txtLargo0.getText());
		    double espesor0 = Double.parseDouble(txtEspesor0.getText());
			
			double precio1 = Double.parseDouble(txtPrecio1.getText());
		    double ancho1 = Double.parseDouble(txtAncho1.getText());
		    double largo1 = Double.parseDouble(txtLargo1.getText());
		    double espesor1 = Double.parseDouble(txtEspesor1.getText());	
			
			double precio2 = Double.parseDouble(txtPrecio2.getText());
		    double ancho2 = Double.parseDouble(txtAncho2.getText());
		    double largo2 = Double.parseDouble(txtLargo2.getText());
		    double espesor2 = Double.parseDouble(txtEspesor2.getText());
			
			double precio3 = Double.parseDouble(txtPrecio3.getText());
		    double ancho3 = Double.parseDouble(txtAncho3.getText());
		    double largo3 = Double.parseDouble(txtLargo3.getText());
		    double espesor3 = Double.parseDouble(txtEspesor3.getText());
			
			double precio4 = Double.parseDouble(txtPrecio4.getText());
		    double ancho4 = Double.parseDouble(txtAncho4.getText());
		    double largo4 = Double.parseDouble(txtLargo4.getText());
		    double espesor4 = Double.parseDouble(txtEspesor4.getText());

			//Cinza Plus
			txtR.append("Modelo       : Cinza Plus" + "\n");
			txtR.append("Precio       : S/ " + precio0 + "\n");
			txtR.append("Ancho (cm)   : " + ancho0 + " cm" + "\n");
			txtR.append("Largo (cm)   : " + largo0 + " cm" + "\n");
			txtR.append("Espesor (mm) : " + espesor0 + " mm" + "\n");
			txtR.append("Contenido    : 6 unidades" + "\n");
			
			//Luxury
			txtR.append("" + "\n");
			txtR.append("Modelo       : Luxury" + "\n");
			txtR.append("Precio       : S/ " + precio1 + "\n");
			txtR.append("Ancho (cm)   : " + ancho1 + " cm" + "\n");
			txtR.append("Largo (cm)   : " + largo1 + " cm" + "\n");
			txtR.append("Espesor (mm) : " + espesor1 + " mm" + "\n");
			txtR.append("Contenido    : 4 unidades" + "\n");
			
			//Austria
			txtR.append("" + "\n");
			txtR.append("Modelo       : Austria" + "\n");
			txtR.append("Precio       : S/ " + precio2 + "\n");
			txtR.append("Ancho (cm)   : " + ancho2 + " cm" + "\n");
			txtR.append("Largo (cm)   : " + largo2 + " cm" + "\n");
			txtR.append("Espesor (mm) : " + espesor2 + " mm" + "\n");
			txtR.append("Contenido    : 12 unidades" + "\n");
			
			//Yungay Mix
			txtR.append("" + "\n");
			txtR.append("Modelo       : Yungay Mix" + "\n");
			txtR.append("Precio       : S/ " + precio3 + "\n");
			txtR.append("Ancho (cm)   : " + ancho3 + " cm" + "\n");
			txtR.append("Largo (cm)   : " + largo3 + " cm" + "\n");
			txtR.append("Espesor (mm) : " + espesor3 + " mm" + "\n");
			txtR.append("Contenido    : 9 unidades" + "\n");
			
			//Thalía
			txtR.append("" + "\n");
			txtR.append("Modelo       : Thalía" + "\n");
			txtR.append("Precio       : S/ " + precio4 + "\n");
			txtR.append("Ancho (cm)   : " + ancho4 + " cm" + "\n");
			txtR.append("Largo (cm)   : " + largo4 + " cm" + "\n");
			txtR.append("Espesor (mm) : " + espesor4 + " mm" + "\n");
			txtR.append("Contenido    : 10 unidades" + "\n");
	        // Manejar el caso cuando el campo está vacío, por ejemplo, mostrar un mensaje al usuario.

	    }
	}
	
}
