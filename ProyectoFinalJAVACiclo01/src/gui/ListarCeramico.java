package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListarCeramico extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	//CRea la GUI
	public ListarCeramico() {
		setTitle("Listar cerámico");
		setSize(564, 199);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Esbozo de método generado automáticamente
		
	}

}
