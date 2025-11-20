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
