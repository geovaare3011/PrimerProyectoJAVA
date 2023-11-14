package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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

	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JButton btnVender;
	private JComboBox<String> cboModelo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtR;
	int modelo;



	//Crear la GUI
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
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(81, 33, 164, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		cboModelo = new JComboBox();
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalía"}));
		cboModelo.setBounds(81, 7, 164, 22);
		cboModelo.addItemListener(this);
		getContentPane().add(cboModelo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(81, 58, 164, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(335, 7, 89, 23);
		btnVender.addActionListener(this);
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



	//Direccionando los botones
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnVender)
			actionPerformedBtnVender(e);
		
		if(e.getSource()==btnCerrar)
			actionPerformedBtnCerrar(e);
		
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	//ItemListener 
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			
			//Entrada de datos
			
			modelo = cboModelo.getSelectedIndex();
			
			//Precios según el modelo
			switch (modelo) {
				
				case 0:
					txtPrecio.setText("92.56");
					break;
				
				case 1:
					txtPrecio.setText("42.77");
					break;
					
				case 2:
					txtPrecio.setText("52.45");
					break;
					
				case 3:
					txtPrecio.setText("55.89");
					break;
					
				default:
					txtPrecio.setText("45");
				
			}
		}
		
	}
	
	public void actionPerformedBtnVender(ActionEvent e) {
		
		//Declaración de variables
		DecimalFormat df = new DecimalFormat("#.00");
		double imCom,imDes,imPag;
		int cant,obsequio;
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
		
		if (modelo == 0) {
			modelo1 = "Cinza Plus";			 
			imCom = Tienda1.precio0 * cant;
		}
		
		else if (modelo == 1) {
			modelo1 = "Luxury";
			imCom = Tienda1.precio1 * cant;
		}
		
		else if (modelo == 2) {
			modelo1 = "Austria";
			imCom = Tienda1.precio2 * cant;
		}
		
		else if (modelo == 3) {
			modelo1 = "Yungay Mix";
			imCom = Tienda1.precio3 * cant;
		}
		
		else {
			modelo1 = "Thalía";
			imCom = Tienda1.precio4 * cant;
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
		
		txtR.setText("BOLETA DE VENTA");
		imprimir(" " + "\n");
		txtR.append("Modelo                  : " + modelo1 + "\n");
		txtR.append("Cantidad adquirida      : " + cant + "\n");
		txtR.append("Importe compra          : " + df.format(imCom) + "\n");
		txtR.append("Importe descuento       : " + df.format(imDes) + "\n");
		txtR.append("Importe pagar           : " + df.format(imPag) + "\n");
		txtR.append("Tipo de obsequio        : Lapicero" + "\n");
		txtR.append("Unidades obsequiadas    : " + obsequio);
		
	}
		// Imprime una cadena con un salto de línea al final
		void imprimir(String cad) {
			txtR.append(cad + "\n");
	}
	
}
