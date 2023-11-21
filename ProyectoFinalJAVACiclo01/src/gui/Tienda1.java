package gui;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import DatosDeCeramicos.DatosCeramico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Tienda1 extends JFrame  implements ActionListener, ItemListener { 
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
	private static DatosCeramico ceramicoActual;
	private static JTextField txtPrecio;
	private static JTextField txtCantidad;
	private static JTextField txtAncho;
	private static JTextField txtLargo;
	private static JTextField txtEspesor;
	private static JComboBox<String> cboModelo;
	
	
	private static DatosCeramico ceramico0 = DatosCeramico.cargarDesdeArchivoCinzaPlus("Modelos\\CinzaPlusEdit.txt");
	private static DatosCeramico ceramico1 = DatosCeramico.cargarDesdeArchivoLuxury("Modelos\\LuxuryEdit.txt");
	private static DatosCeramico ceramico2 = DatosCeramico.cargarDesdeArchivoAustria("Modelos\\AustriaEdit.txt");
	private static DatosCeramico ceramico3 = DatosCeramico.cargarDesdeArchivoYungayMix("Modelos\\YungayMixEdit.txt");
	private static DatosCeramico ceramico4 = DatosCeramico.cargarDesdeArchivoThalia("Modelos\\ThalíaEdit.txt");

	
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
	
	// Porcentajes de descuento
	public static double porcentaje1 = 0.075;
	public static double porcentaje2 = 0.010;
	public static double porcentaje3 = 0.125;
	public static double porcentaje4 = 0.15;
	
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
		setSize(480, 297);
		setLocationRelativeTo(null);//Para que quede en el medio
		setResizable(false);
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
		getContentPane().setLayout(null);
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
        txtCantidad.setText(ceramicoActual.getCantidad());
    }
		
		//Direcciona los botones del menu	
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==cboModelo) {
				actualizarDatosCeramico();
			}
			
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
			
			if (mntmVender==e.getSource()) {
				actionPerfomedMntmVender(e);
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
			
		}
		
		public void actionPerfomedMntmLceramico(ActionEvent e) {
			ListarCeramico ventana3 = new ListarCeramico ();
			ventana3.setVisible(true);
			
		}
		
		public void actionPerfomedMntmGreportes(ActionEvent e) {
			GenerarReportes ventana5 = new GenerarReportes();
			ventana5.setVisible(true);
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
			AcercaDeLaTienda ventana10 = new AcercaDeLaTienda();
			ventana10.setVisible(true);  
		}
		
		public void actionPerfomedMntmVender(ActionEvent e) {
			Vender ventana4 = new Vender();
			ventana4.setVisible(true);
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
} 

	
	
	



