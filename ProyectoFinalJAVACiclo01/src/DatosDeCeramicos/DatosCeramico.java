package DatosDeCeramicos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DatosCeramico {
    private String tipo;
    private double precio;
    private double ancho;
    private double largo;
    private double espesor;
    private String cantidad;
    

    public static String ruta = "C:\\Users\\51921\\git\\JAVAProyecto\\ProyectoFinalJAVACiclo01\\";
    
    // Constructor que acepta todos los parámetros
    public DatosCeramico(String tipo, double precio, double ancho, double largo, double espesor, String cantidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.ancho = ancho;
        this.largo = largo;
        this.espesor = espesor;
        this.cantidad= cantidad;
    }

    //Métodos get
    public String getTipo() {
        return tipo;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public double getAncho() {
        return ancho;
    }
    
    public double getLargo() {
        return largo;
    }
    
    public double getEspesor() {
        return espesor;
    }
    
    public String getCantidad() {
        return cantidad;
    }
    
    //Métodos set
    public void setTipo(String nuevoTipo) {	
    	this.tipo = nuevoTipo;    	
    }
    
    public void setPrecio(Double nuevoPrecio) {	
    	this.precio = nuevoPrecio;    	
    }
    
    public void setAncho(Double nuevoAncho) {	
    	this.ancho = nuevoAncho;    	
    }
    
    public void setLargo(Double nuevoLargo) {	
    	this.largo = nuevoLargo;    	
    }
    
    public void setEspesor(Double nuevoEspesor) {	
    	this.espesor = nuevoEspesor;    	
    }
    
    public void setCantidad(String nuevoCantidad) {	
    	this.cantidad = nuevoCantidad;    	
    }
    
    // Método para guardar Cinza Plus
    public void guardarEnArchivoCinzaPlus(String CinzaPlus) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CinzaPlus))) {
            writer.println(tipo);
            writer.println(precio);
            writer.println(ancho);
            writer.println(largo);
            writer.println(espesor);
            writer.println(cantidad);
            System.out.println("Datos guardados en " + CinzaPlus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar CinzaPlus
   	public static DatosCeramico cargarDesdeArchivoCinzaPlus(String CinzaPlus) {
		try (Scanner scanner = new Scanner(new FileReader(CinzaPlus))) {
            String tipo = scanner.nextLine();
            double precio = Double.parseDouble(scanner.nextLine());
            double ancho = Double.parseDouble(scanner.nextLine());
            double largo = Double.parseDouble(scanner.nextLine());
            double espesor = Double.parseDouble(scanner.nextLine());
            String cantidad = scanner.nextLine();

            return new DatosCeramico(tipo, precio, ancho, largo, espesor, cantidad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}
   	
   	// Método para guardar Luxury
   	public void guardarEnArchivoLuxury(String Luxury) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Luxury))) {
            writer.println(tipo);
            writer.println(precio);
            writer.println(ancho);
            writer.println(largo);
            writer.println(espesor);
            writer.println(cantidad);
            System.out.println("Datos guardados en " + Luxury);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar Luxury
   	public static DatosCeramico cargarDesdeArchivoLuxury(String Luxury) {
		try (Scanner scanner = new Scanner(new FileReader(Luxury))) {
            String tipo = scanner.nextLine();
            double precio = Double.parseDouble(scanner.nextLine());
            double ancho = Double.parseDouble(scanner.nextLine());
            double largo = Double.parseDouble(scanner.nextLine());
            double espesor = Double.parseDouble(scanner.nextLine());
            String cantidad = scanner.nextLine();

            return new DatosCeramico(tipo, precio, ancho, largo, espesor, cantidad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}
   	
   	// Método para guardar Austria
   	public void guardarEnArchivoAustria(String Austria) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Austria))) {
            writer.println(tipo);
            writer.println(precio);
            writer.println(ancho);
            writer.println(largo);
            writer.println(espesor);
            writer.println(cantidad);
            System.out.println("Datos guardados en " + Austria);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar Austria
   	public static DatosCeramico cargarDesdeArchivoAustria(String Austria) {
		try (Scanner scanner = new Scanner(new FileReader(Austria))) {
            String tipo = scanner.nextLine();
            double precio = Double.parseDouble(scanner.nextLine());
            double ancho = Double.parseDouble(scanner.nextLine());
            double largo = Double.parseDouble(scanner.nextLine());
            double espesor = Double.parseDouble(scanner.nextLine());
            String cantidad = scanner.nextLine();

            return new DatosCeramico(tipo, precio, ancho, largo, espesor, cantidad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}
   	
   	// Método para guardar YungayMix
   	public void guardarEnArchivoYungayMix(String YungayMix) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(YungayMix))) {
            writer.println(tipo);
            writer.println(precio);
            writer.println(ancho);
            writer.println(largo);
            writer.println(espesor);
            writer.println(cantidad);
            System.out.println("Datos guardados en " + YungayMix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar YungayMix
   	public static DatosCeramico cargarDesdeArchivoYungayMix(String YungayMix) {
		try (Scanner scanner = new Scanner(new FileReader(YungayMix))) {
            String tipo = scanner.nextLine();
            double precio = Double.parseDouble(scanner.nextLine());
            double ancho = Double.parseDouble(scanner.nextLine());
            double largo = Double.parseDouble(scanner.nextLine());
            double espesor = Double.parseDouble(scanner.nextLine());
            String cantidad = scanner.nextLine();

            return new DatosCeramico(tipo, precio, ancho, largo, espesor, cantidad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}
   	
   	// Método para guardar Thalia
   	public void guardarEnArchivoThalia(String Thalía) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Thalía))) {
            writer.println(tipo);
            writer.println(precio);
            writer.println(ancho);
            writer.println(largo);
            writer.println(espesor);
            writer.println(cantidad);
            System.out.println("Datos guardados en " + Thalía);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar Thalia
   	public static DatosCeramico cargarDesdeArchivoThalia(String Thalía) {
		try (Scanner scanner = new Scanner(new FileReader(Thalía))) {
            String tipo = scanner.nextLine();
            double precio = Double.parseDouble(scanner.nextLine());
            double ancho = Double.parseDouble(scanner.nextLine());
            double largo = Double.parseDouble(scanner.nextLine());
            double espesor = Double.parseDouble(scanner.nextLine());
            String cantidad = scanner.nextLine();

            return new DatosCeramico(tipo, precio, ancho, largo, espesor, cantidad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}
}

