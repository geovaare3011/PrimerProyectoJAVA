package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ListarCeramico extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JButton btnCerrar;
	private JButton btnListar;
	private  JTextArea txtR;
	private JScrollPane scrollPane;


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
			actionPerformedBtnListar(e);
		}
	}
	
	//Acción que hará el botón Cerrar
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	//Acción que hará el botón Listar
	public void actionPerformedBtnListar(ActionEvent e) {
		txtR.setText("LISTADO DE CERÁMICOS" + "\n");
		txtR.append("" + "\n");
		
		//Cinza Plus
		txtR.append("Modelo       : Cinza Plus" + "\n");
		txtR.append("Precio       : S/ 92.56" + "\n");
		txtR.append("Ancho (cm)   : 62.0 cm" + "\n");
		txtR.append("Largo (cm)   : 62.0 cm" + "\n");
		txtR.append("Espesor (mm) : 8.0 cm" + "\n");
		txtR.append("Contenido    : 6 unidades" + "\n");
		
		//Luxury
		txtR.append("" + "\n");
		txtR.append("Modelo       : Luxury" + "\n");
		txtR.append("Precio       : S/ 42.77" + "\n");
		txtR.append("Ancho (cm)   : 60 cm" + "\n");
		txtR.append("Largo (cm)   : 60 cm" + "\n");
		txtR.append("Espesor (mm) : 8.5 cm" + "\n");
		txtR.append("Contenido    : 4 unidades" + "\n");
		
		//Austria
		txtR.append("" + "\n");
		txtR.append("Modelo       : Austria" + "\n");
		txtR.append("Precio       : S/ 52.45" + "\n");
		txtR.append("Ancho (cm)   : 45 cm" + "\n");
		txtR.append("Largo (cm)   : 45 cm" + "\n");
		txtR.append("Espesor (mm) : 6.5 cm" + "\n");
		txtR.append("Contenido    : 12 unidades" + "\n");
		
		//Yungay Mix
		txtR.append("" + "\n");
		txtR.append("Modelo       : Yungay Mix" + "\n");
		txtR.append("Precio       : S/ 55.89" + "\n");
		txtR.append("Ancho (cm)   : 80 cm" + "\n");
		txtR.append("Largo (cm)   : 120 cm" + "\n");
		txtR.append("Espesor (mm) : 6.8 cm" + "\n");
		txtR.append("Contenido    : 9 unidades" + "\n");
		
		//Thalía
		txtR.append("" + "\n");
		txtR.append("Modelo       : Thalía" + "\n");
		txtR.append("Precio       : S/ 45" + "\n");
		txtR.append("Ancho (cm)   : 45 cm" + "\n");
		txtR.append("Largo (cm)   : 11.8 cm" + "\n");
		txtR.append("Espesor (mm) : 7.2 cm" + "\n");
		txtR.append("Contenido    : 10 unidades" + "\n");
	}
	
}
