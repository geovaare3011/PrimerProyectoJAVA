package Experimentos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ProgramaPortable {

    public static void main(String[] args) {
        // Obtener la ubicación del directorio en el que se está ejecutando el programa
        String directorioActual = obtenerDirectorioActual();

        // Nombre del archivo que estás buscando
        String nombreArchivo = "archivo.txt";

        // Construir la ruta completa al archivo
        String rutaCompleta = directorioActual + File.separator + nombreArchivo;

        // Ahora puedes usar la rutaCompleta para realizar operaciones en el archivo
        System.out.println("La ruta completa al archivo es: " + rutaCompleta);

        // Ejemplo: Copiar el archivo a otro lugar
        copiarArchivo(directorioActual, nombreArchivo, "destino");
    }

    private static String obtenerDirectorioActual() {
        ClassLoader classLoader = ProgramaPortable.class.getClassLoader();
        // Obtener la URL del recurso (en este caso, la ubicación del directorio)
        // "file:" se quita de la URL para que sea compatible con diferentes sistemas operativos
        return new File(classLoader.getResource("").getFile()).getPath();
    }

    private static void copiarArchivo(String directorioOrigen, String nombreArchivo, String directorioDestino) {
        try (InputStream inputStream = ProgramaPortable.class.getClassLoader().getResourceAsStream(nombreArchivo)) {
            if (inputStream != null) {
                Files.copy(inputStream, new File(directorioDestino + File.separator + nombreArchivo).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Archivo copiado exitosamente.");
            } else {
                System.out.println("No se pudo encontrar el archivo.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//comparativa necesaria con DatosCeramico, Main y Tienda1
//21-24 N11-2023
