package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;

public class AcercaDeLaTienda extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JButton btnCerrar;
	private JLabel lblTitulo;
	private JLabel lblAutores;
	private JLabel lblRenan;
	private JLabel lblGeovani;
	private JLabel lblAlexandra;
	private JLabel lblAbigail;
	private JSeparator separator;

	
	//Crea la GUI
	public AcercaDeLaTienda() {
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
	
	//Iniciar Componentes
	public void iniciarComponentes() {
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(140, 245, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		lblTitulo = new JLabel("Tienda 1.0");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(130, 11, 110, 31);
		getContentPane().add(lblTitulo);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(151, 78, 89, 14);
		getContentPane().add(lblAutores);
		
		lblRenan = new JLabel("Renán Osorio (...)");
		lblRenan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRenan.setBounds(130, 122, 151, 14);
		getContentPane().add(lblRenan);
		
		lblGeovani = new JLabel("Giovanni Guevara (...)");
		lblGeovani.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGeovani.setBounds(130, 172, 141, 14);
		getContentPane().add(lblGeovani);
		
		lblAlexandra = new JLabel("Ruvi Alexandra Rivera (...)");
		lblAlexandra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlexandra.setBounds(130, 147, 110, 14);
		getContentPane().add(lblAlexandra);
		
		lblAbigail = new JLabel("Ruth Abigail Martinez (...)");
		lblAbigail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbigail.setBounds(130, 197, 134, 14);
		getContentPane().add(lblAbigail);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 53, 364, 14);
		getContentPane().add(separator);
	
	}
	
		//Direccionando el botón
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()== btnCerrar) {
				actionPerformedBtnCerrar(e);
				
			}					
		}
		
		//Acción del botón Cerrar
		public void actionPerformedBtnCerrar(ActionEvent e) {
			
			dispose();				
		}
}
