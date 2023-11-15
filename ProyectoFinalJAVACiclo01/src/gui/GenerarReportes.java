package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;

public class GenerarReportes extends JFrame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JLabel lblTipoDeReporte;
	private JComboBox<String> cboTipo;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtR;

	
	//Crea la GUI
	public GenerarReportes() {
		
		setSize(658, 409);
		getContentPane().setLayout(null);
		iniciarComponentes();
		
	}
	
	public void iniciarComponentes() {		
		
		lblTipoDeReporte = new JLabel("Tipo de Reporte");
		lblTipoDeReporte.setBounds(10, 29, 94, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Comparación de precios con el precio promedio", "Comparación de las cajas vendidas con la cantidad óptima", "Estadística sobre el precio"}));
		cboTipo.setBounds(114, 25, 327, 22);
		getContentPane().add(cboTipo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(543, 25, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 622, 292);
		getContentPane().add(scrollPane);
		
		txtR = new JTextArea();
		scrollPane.setViewportView(txtR);
		
	}

	//Direccionando los botones
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	//Direccionando la elección
	public void itemStateChanged(ItemEvent e) {
		
		//Declaración de variable
		int tipo;
		
		//Entrada de selección
		tipo = cboTipo.getSelectedIndex();
		
		//Proceso
		switch(tipo) {
		
		case 0:
		
		}
		
	}
	
	
}
