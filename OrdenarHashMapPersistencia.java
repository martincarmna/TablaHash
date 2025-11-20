import java.io.*;
import java.util.*;

public class OrdenarHashMapPersistencia {

    public static void main(String[] args) {
        String archivoEntrada = "C:\\archivos\\nombres.txt";
        String archivoSalida = "C:\\archivos\\nombres_ordenados.txt";

        try {
            //  Leer nombres SIN ID, se asignan automáticamente
            HashMap<Integer, String> tabla = leerHashMapDesdeArchivo(archivoEntrada);

            System.out.println("Nombres originales:");
            imprimirMapa(tabla);

            //  Ordenar por nombre
            List<Map.Entry<Integer, String>> listaOrdenada =
                    new ArrayList<>(tabla.entrySet());
            listaOrdenada.sort(Map.Entry.comparingByValue());

            System.out.println("\nNombres ordenados:");
            imprimirLista(listaOrdenada);

            //  Guardar en archivo
            guardarEnArchivo(listaOrdenada, archivoSalida);

            System.out.println("\nArchivo guardado correctamente en:");
            System.out.println(archivoSalida);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // LEE ARCHIVO CON SOLO NOMBRES (SIN ID)
    public static HashMap<Integer, String> leerHashMapDesdeArchivo(String ruta) throws IOException {
        HashMap<Integer, String> mapa = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));

        String linea;
        int id = 1; // Generamos ID automáticamente

        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) {
                mapa.put(id, linea);
                id++;
            }
        }

        br.close();
        return mapa;
    }


    // GUARDA LOS DATOS ORDENADOS EN ARCHIVO
    public static void guardarEnArchivo(List<Map.Entry<Integer, String>> lista, String ruta)
            throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

        for (Map.Entry<Integer, String> entrada : lista) {
            bw.write(entrada.getKey() + " " + entrada.getValue());
            bw.newLine();
        }

        bw.close();
    }

    // IMPRIMIR HASHMAP
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
