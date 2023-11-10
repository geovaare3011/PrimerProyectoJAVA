package gui;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tienda1 extends JFrame  implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//Declaración de variables
	private JMenuItem mntmCceramico;
	private JMenuItem mntmSalir;
	private JMenuBar menuBar;
	private JMenu mnArchivos;
	private JMenu mnMantenimiento;
	private JMenuItem mntmMceramico;
	private JMenuItem mntmLceramico;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGreportes;
	private JMenu mnConfiguración;
	private JMenuItem mntmCdescuentos;
	private JMenuItem mntmCobsequios;
	private JMenuItem mntmCcoptimo;
	private JMenuItem mntmCcdiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAdlTienda;
	
	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	
	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	
	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;
	
	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	
	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	
	
	// Inicia la GUI
	public Tienda1() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(822, 554);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);//para que no se pueda agrandar
		getContentPane().setLayout(null);
		iniciarComponentes();
	}
	
	//Crea lo componentes
	private void iniciarComponentes() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivos = new JMenu("Archivos ");
		menuBar.add(mnArchivos);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivos.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmCceramico = new JMenuItem("Consultar cerámico");
		mntmCceramico.addActionListener(this);
		mnMantenimiento.add(mntmCceramico);
		
		mntmMceramico = new JMenuItem("Modificar cerámico");
		mntmMceramico.addActionListener(this);
		mnMantenimiento.add(mntmMceramico);
		
		mntmLceramico = new JMenuItem("Listar cerámico");
		mntmLceramico.addActionListener(this);
		mnMantenimiento.add(mntmLceramico);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGreportes = new JMenuItem("Generar reportes");
		mntmGreportes.addActionListener(this);
		mnVentas.add(mntmGreportes);
		
		mnConfiguración = new JMenu("Configuración");
		menuBar.add(mnConfiguración);
		
		mntmCdescuentos = new JMenuItem("Configurar descuentos");
		mntmCdescuentos.addActionListener(this);
		mnConfiguración.add(mntmCdescuentos);
		
		mntmCobsequios = new JMenuItem("Configurar obsequiios");
		mntmCobsequios.addActionListener(this);
		mnConfiguración.add(mntmCobsequios);
		
		mntmCcoptimo = new JMenuItem("Configurar cantidad óptimo");
		mntmCcoptimo.addActionListener(this);
		mnConfiguración.add(mntmCcoptimo);
		
		mntmCcdiaria = new JMenuItem("Configurar cuota diaria");
		mntmCcdiaria.addActionListener(this);
		mnConfiguración.add(mntmCcdiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAdlTienda = new JMenuItem("Acerca de la Tienda");
		mntmAdlTienda.addActionListener(this);
		mnAyuda.add(mntmAdlTienda);
	}
		
		
		//Direcciona los botones del menu	
		public void actionPerformed(ActionEvent e) {
			
			if  (mntmSalir==e.getSource()){
				actionPerfomedMntmSalir(e);
			}
			
			if (mntmCceramico==e.getSource()) {
				actionPerfomedMntmCceramico(e);
			}
			
			if (mntmLceramico==e.getSource()) {
				actionPerfomedMntmLceramico(e);
			}
			
			if (mntmMceramico==e.getSource()) {
				actionPerfomedMntmMceramico(e);
			}
			
			if (mntmVender==e.getSource()) {
				actionPerfomedMntmVender(e);
			}
			
			if (mntmGreportes==e.getSource()) {
				actionPerfomedMntmGreportes(e);
			}
			
			if (mntmCdescuentos==e.getSource()) {
				actionPerfomedMntmCdescuentos(e);
			}
			
			if (mntmCobsequios==e.getSource()) {
				actionPerfomedMntmCobsequio(e);
			}
			
			if(mntmCcoptimo==e.getSource()) {
				actionPerfomedMntmCcoptimo(e);
			}
			
			if(mntmCcdiaria==e.getSource()) {
				actionPerfomedMntmCcdiaria(e);
			}
			
			if(mntmAdlTienda==e.getSource()) {
				actionPerfomedMntmAdlTienda(e);
			}
		}	
		
		//Direcciona las acciones de los botones
		
		public void actionPerfomedMntmCceramico(ActionEvent e) {
			ConsultarCerámico ventana = new ConsultarCerámico ();
			ventana.setVisible(true);
			ConsultarCerámico.Modelo();
		}
		
		
		
		public void actionPerfomedMntmSalir(ActionEvent e) {
			System.exit(0);
		}
		
		
		public void actionPerfomedMntmMceramico(ActionEvent e) {
			ModificarCerámico ventana2 = new ModificarCerámico ();
			ventana2.setVisible(true);
			ModificarCerámico.Modelo2();
		}
		
		public void actionPerfomedMntmLceramico(ActionEvent e) {
			ListarCeramico ventana3 = new ListarCeramico ();
			ventana3.setVisible(true);
			
		}
		
		
		public void actionPerfomedMntmVender(ActionEvent e) {
			
		}
		
		
		public void actionPerfomedMntmGreportes(ActionEvent e) {
			
		}
		
		
		public void actionPerfomedMntmCdescuentos(ActionEvent e) {
			
		}

		
		public void actionPerfomedMntmCobsequio(ActionEvent e) {
			
		}

		
		public void actionPerfomedMntmCcoptimo(ActionEvent e) {
			
		}
		
		
		public void actionPerfomedMntmCcdiaria(ActionEvent e) {
			
		}
		
		
		public void actionPerfomedMntmAdlTienda(ActionEvent e) {
			
		}
		
		
} 

	
	
	



