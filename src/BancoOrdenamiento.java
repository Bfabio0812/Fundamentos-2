import java.util.Random;
import java.util.Vector;

public class BancoOrdenamiento {

    // Función para generar 25 nombres aleatorios y añadirlos a un Vector
    public static Vector<String> generarNombresAleatorios() {
        String[] nombres = {"Ana", "Carlos", "Beatriz", "Daniel", "Elena", "Fernando", "Gloria", "Hugo",
                "Irene", "Javier", "Karla", "Luis", "María", "Nora", "Oscar", "Patricia",
                "Ricardo", "Sofia", "Tomás", "Ulises", "Verónica", "Walter", "Ximena",
                "Yolanda", "Zacarías"};

        Vector<String> vectorNombres = new Vector<>();
        Random random = new Random();

        while (vectorNombres.size() < 25) {
            int indiceAleatorio = random.nextInt(nombres.length);
            String nombreAleatorio = nombres[indiceAleatorio];
            if (!vectorNombres.contains(nombreAleatorio)) {
                vectorNombres.add(nombreAleatorio);
            }
        }
        return vectorNombres;
    }

    // Implementación de QuickSort para ordenar el Vector de nombres
    public static void quickSort(Vector<String> nombres, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(nombres, inicio, fin);
            quickSort(nombres, inicio, indicePivote - 1); // Ordenar sublista izquierda
            quickSort(nombres, indicePivote + 1, fin);    // Ordenar sublista derecha
        }
    }

    // Función auxiliar para dividir el Vector en dos partes alrededor de un pivote
    public static int particion(Vector<String> nombres, int inicio, int fin) {
        String pivote = nombres.get(fin);  // El último elemento como pivote
        int i = inicio - 1;  // Índice del menor elemento

        for (int j = inicio; j < fin; j++) {
            // Si el elemento actual es menor o igual que el pivote
            if (nombres.get(j).compareTo(pivote) <= 0) {
                i++;
                // Intercambiar nombres[i] con nombres[j]
                String temp = nombres.get(i);
                nombres.set(i, nombres.get(j));
                nombres.set(j, temp);
            }
        }

        // Intercambiar nombres[i + 1] con el pivote (nombres[fin])
        String temp = nombres.get(i + 1);
        nombres.set(i + 1, nombres.get(fin));
        nombres.set(fin, temp);

        return i + 1;
    }

    // Función para imprimir los nombres
    public static void imprimirNombres(Vector<String> nombres) {
        System.out.println("Nombres ordenados alfabéticamente:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {
        // Generar nombres aleatorios y almacenarlos en un Vector
        Vector<String> vectorNombres = generarNombresAleatorios();

        // Ordenar los nombres usando QuickSort
        quickSort(vectorNombres, 0, vectorNombres.size() - 1);

        // Imprimir los nombres ordenados
        imprimirNombres(vectorNombres);
    }
}