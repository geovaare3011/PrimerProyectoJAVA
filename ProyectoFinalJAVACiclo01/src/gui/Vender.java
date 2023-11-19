package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DatosDeCeramicos.DatosCeramico;
import Experimentos.VentanaClics;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class Vender extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;

	public static JTextField txtPrecio;
	public static JTextField txtCantidad;
	public static JTextField txtAncho;
	public static JTextField txtLargo;
	public static JTextField txtEspesor;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JButton btnVender;
	public static JComboBox<String> cboModelo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtR;
    private int contadorClics = 0;
	public double imCom, imDes, imPag, Imp = 0;
	public int cant, obsequio;

	private static DatosCeramico ceramicoActual;
	private static int modelo;
	public static int modelo01;
	private static DatosCeramico ceramico0 = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
	private static DatosCeramico ceramico1 = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
	private static DatosCeramico ceramico2 = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
	private static DatosCeramico ceramico3 = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
	private static DatosCeramico ceramico4 = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");


	
	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = ceramico0.getPrecio();
	public static double ancho0 = ceramico0.getAncho();
	public static double largo0 = ceramico0.getLargo();
	public static double espesor0 = ceramico0.getEspesor();
	public static int cantidad0 = Integer.parseInt(ceramico0.getCantidad());
	
	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = ceramico1.getPrecio();
	public static double ancho1 = ceramico1.getAncho();
	public static double largo1 = ceramico1.getLargo();
	public static double espesor1 = ceramico1.getEspesor();
	public static int cantidad1 = Integer.parseInt(ceramico1.getCantidad());
	
	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = ceramico2.getPrecio();
	public static double ancho2 = ceramico2.getAncho();
	public static double largo2 = ceramico2.getLargo();
	public static double espesor2 = ceramico2.getEspesor();
	public static int cantidad2 = Integer.parseInt(ceramico2.getCantidad());
	
	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = ceramico3.getPrecio();
	public static double ancho3 = ceramico3.getAncho();
	public static double largo3 = ceramico3.getLargo();
	public static double espesor3 = ceramico3.getEspesor();
	public static int cantidad3 = Integer.parseInt(ceramico3.getCantidad());
	
	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = ceramico4.getPrecio();
	public static double ancho4 = ceramico4.getAncho();
	public static double largo4 = ceramico4.getLargo();
	public static double espesor4 = ceramico4.getEspesor();
	public static int cantidad4 = Integer.parseInt(ceramico4.getCantidad());
	


	//Crear la GUI
	public void actualizarDatosCeramico() {
        // Actualizar ceramicoActual con los datos del tipo de cerámico seleccionado
        String tipoSeleccionado = (String) cboModelo.getSelectedItem();
        ceramicoActual.setTipo(tipoSeleccionado);

        // Actualizar los JTextFields con los nuevos datos
        txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
        txtAncho.setText(String.valueOf(ceramicoActual.getAncho()));
        txtLargo.setText(String.valueOf(ceramicoActual.getLargo()));
        txtEspesor.setText(String.valueOf(ceramicoActual.getEspesor()));
        txtCantidad.setText(ceramicoActual.getCantidad());
    }
	
	//Direccionando los botones
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cboModelo) {
			actualizarDatosCeramico();
		}
		if(e.getSource()==btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		
		if(e.getSource()==btnVender){
			actionPerformedBtnVender(e);
		}
	
	}
	
	
	//ItemListener 
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			
			//Entrada de datos
			
			modelo = cboModelo.getSelectedIndex();
			
			
			
			//Precios según el modelo
			switch (modelo) {
				
				case 0:
					
					ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
					// Suponiendo que el método cargarDesdeArchivoCinzaPlus es público y estático
					txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
					
					break;
				
				case 1:
					ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
					//
					txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
					break;
					
				case 2:
					ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
					//
					txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
					break;
					
				case 3:
					ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
					//
					txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
					break;
					
				default:
					ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
					//
					txtPrecio.setText(String.valueOf(ceramicoActual.getPrecio()));
			}
		}
		
	}

public void actionPerformedBtnVender(ActionEvent e) {
	
	try {
	
	//Declaración de variables
	
	DecimalFormat df = new DecimalFormat("#.00");
	String modelo1;
	
	//Entrada de Datos
	
	cant = Integer.parseInt(txtCantidad.getText());
	
	//Obsequios
	
	if (cant <= 5)
		obsequio = cant * Tienda1.obsequioCantidad1;
	
	else if (cant <= 10)
		obsequio = cant * Tienda1.obsequioCantidad2;
	
	else
		obsequio = cant * Tienda1.obsequioCantidad3;
	
	//Modelo

	double precio0 = Double.parseDouble(txtPrecio.getText());
	double precio1 = Double.parseDouble(txtPrecio.getText());
	double precio2 = Double.parseDouble(txtPrecio.getText());
	double precio3 = Double.parseDouble(txtPrecio.getText());
	double precio4 = Double.parseDouble(txtPrecio.getText());
	
	
	if (modelo == 0) {
		modelo1 = "Cinza Plus";			 
		imCom = precio0 * cant;
	}
	
	else if (modelo == 1) {
		modelo1 = "Luxury";
		imCom = precio1 * cant;
	}
	
	else if (modelo == 2) {
		modelo1 = "Austria";
		imCom = precio2 * cant;
	}
	
	else if (modelo == 3) {
		modelo1 = "Yungay Mix";
		imCom = precio3 * cant;
	}
	
	else {
		modelo1 = "Thalía";
		imCom = precio4 * cant;
	}
	
	//Importe de descuento
	
	
	if (cant >= 1)
		imDes = imCom * Tienda1.porcentaje1;
			
	else if (cant >= 6)
		imDes = imCom * Tienda1.porcentaje2;
			
	else if (cant >= 11)
		imDes = imCom * Tienda1.porcentaje3;
			
	else 
		imDes = imCom * Tienda1.porcentaje4;
			
	
	//Importe a pagar
	
	imPag = imCom - imDes;
	
	//Salida de datos
	
	txtR.setText("BOLETA DE VENTA Nro. " + contadorClics);
	imprimir(" " + "\n");
	txtR.append("Modelo                  : " + modelo1 + "\n");
	txtR.append("Cantidad adquirida      : " + cant + "\n");
	txtR.append("Importe compra          : S/. " + df.format(imCom) + "\n");
	txtR.append("Importe descuento       : S/. " + df.format(imDes) + "\n");
	txtR.append("Importe pagar           : S/. " + df.format(imPag) + "\n");
	txtR.append("Tipo de obsequio        : Lapicero" + "\n");
	txtR.append("Unidades obsequiadas    : " + obsequio);
		
    } catch (Exception c) {
        // Este bloque se ejecutará para cualquier otra excepción no capturada
        mostrarError("Error de sintaxis, puede de que hayas " + "\n"
        			+"escrito letras o caracteres no adecuados " + "\n"
        			+"o incluso no hayas escrito nada, el limite " + "\n"
        			+"de cantidades es de un valor de 10 digitos maximo");
    }
}
		

public static void Modelo2() {
		
		modelo = cboModelo.getSelectedIndex();
	
		switch(modelo) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
	
		}
	}	
	
public static void Modelo() {
		
		int modelo;		
		
		modelo = cboModelo.getSelectedIndex(); 
		
		switch(modelo) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
	
		}
		
	}

	public Vender() {
		setTitle("Vender");
		setSize(450, 300);
		setResizable(false);
		setLocationRelativeTo(null);		
		getContentPane().setLayout(null);
		iniciarComponentes();
		
	}
	
	public void iniciarComponentes() {
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 36, 61, 14);
		getContentPane().add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 61, 61, 14);
		getContentPane().add(lblCantidad);
		
		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía"}));
		cboModelo.setBounds(81, 7, 164, 22);
		cboModelo.addItemListener(this);
		getContentPane().add(cboModelo);
		
		
		modelo01 = cboModelo.getSelectedIndex();
		
		switch(modelo01) {
		case 0:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoCinzaPlus("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\CinzaPlusEdit.txt");
			break;
		
		case 1:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoLuxury("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\LuxuryEdit.txt");
			break;
		
		case 2:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoAustria("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\AustriaEdit.txt");
			break;
		
		case 3:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoYungayMix("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\YungayMixEdit.txt");
			break;
		
		default:
			ceramicoActual = DatosCeramico.cargarDesdeArchivoThalia("C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\Modelos\\ThalíaEdit.txt");
	
		}
		
		txtPrecio = new JTextField(String.valueOf(ceramicoActual.getPrecio()));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(81, 33, 164, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(81, 58, 164, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(335, 7, 89, 23);
		btnVender.addActionListener(this);
		getContentPane().add(btnVender);
		
     

        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent G) {
                // Incrementa el contador de clics
                contadorClics++;
            	Imp = Imp + imPag;
            	imPag = Imp;
            		
                // Muestra un JOptionPane cada 5 clics
                if(contadorClics % 5 == 1){
            	DecimalFormat df = new DecimalFormat("#.00");
            	JOptionPane.showMessageDialog(Vender.this, "Venta Nro. " + (contadorClics-1) + "\n" + 
            			"Importe total general acumulado: S/. " + df.format(Imp),
            	 "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        });

        // Añade el botón al centro de la ventana
        getContentPane().add(btnVender);
		
		
        
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 36, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 414, 164);
		getContentPane().add(scrollPane);
		
		txtR = new JTextArea();
		txtR.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtR);
		
	}

	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}


public static void mostrarError(String mensaje) {
JOptionPane.showOptionDialog(null, mensaje, "ERROR DE SINTAXIS", JOptionPane.DEFAULT_OPTION,
    JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);
}

//Imprime una cadena con un salto de línea al final
void imprimir(String cad) {
	txtR.append(cad + "\n");
}

	
}
