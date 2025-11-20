import java.io.*;
import java.util.*;

public class OrdenarHashMapPersistencia {

    public static void main(String[] args) {
        String archivoEntrada = "C:\\archivos\\nombres.txt";
        String archivoSalida = "C:\\archivos\\nombres_ordenados.txt";

        try {
            // 1. Leer HashMap desde archivo
            HashMap<Integer, String> tabla = leerHashMapDesdeArchivo(archivoEntrada);

            System.out.println("Datos originales:");
            imprimirMapa(tabla);

            // 2. Ordenar por nombre (valor)
            List<Map.Entry<Integer, String>> listaOrdenada =
                    new ArrayList<>(tabla.entrySet());
            listaOrdenada.sort(Map.Entry.comparingByValue());

                 System.out.println("\nDatos ordenados por nombre:");
            imprimirLista(listaOrdenada);

            // 3. Guardar lista ordenada en archivo
            guardarEnArchivo(listaOrdenada, archivoSalida);

            System.out.println("\nArchivo guardado correctamente en:\n" + archivoSalida);

        } catch (IOException e) {
            System.out.println("Error al leer o escribir archivo: " + e.getMessage());
        }
    }
 // -------------------------------------------------------
    // LEE EL ARCHIVO Y LO GUARDA EN UN HASHMAP
    // -------------------------------------------------------
    public static HashMap<Integer, String> leerHashMapDesdeArchivo(String ruta) throws IOException {
        HashMap<Integer, String> mapa = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(" ");

            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];

            mapa.put(id, nombre);
        }
        br.close();
        return mapa;
    }
     // -------------------------------------------------------
    // GUARDA DATOS ORDENADOS EN ARCHIVO
    // -------------------------------------------------------
    public static void guardarEnArchivo(List<Map.Entry<Integer, String>> lista, String ruta)
            throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

        for (Map.Entry<Integer, String> entrada : lista) {
            bw.write(entrada.getKey() + " " + entrada.getValue());
            bw.newLine();
        }

        bw.close();
    }
     // -------------------------------------------------------
    // MÉTODOS DE IMPRESIÓN
    // -------------------------------------------------------
    public static void imprimirMapa(HashMap<Integer, String> mapa) {
        for (Map.Entry<Integer, String> e : mapa.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }

    public static void imprimirLista(List<Map.Entry<Integer, String>> lista) {
        for (Map.Entry<Integer, String> e : lista) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }
}