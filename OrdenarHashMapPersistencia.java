import java.util.*;

public class OrdenarHashMapNombres {
    public static void main(String[] args) {

        HashMap<Integer, String> nombres = new HashMap<>();
        nombres.put(3, "Juan");
        nombres.put(1, "Pedro");
        nombres.put(2, "Ana");

        // Convertir entradas a lista
        List<Map.Entry<Integer, String>> lista = new ArrayList<>(nombres.entrySet());

        // Ordenar por el nombre (valor)
        lista.sort(Map.Entry.comparingByValue());

        // Mostrar ordenados
        System.out.println("Ordenados por nombre:");
        for (Map.Entry<Integer, String> entrada : lista) {
            System.out.println(entrada.getKey() + " → " + entrada.getValue());
        }
    }
}
