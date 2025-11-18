import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        InsertionSort sorting = new InsertionSort();
        int[] temperaturas = {1,6, 20, 24, 30, 45};

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(temperaturas));

        sorting.sort(temperaturas);

        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(temperaturas));

        int min = temperaturas[0];
        int max = temperaturas[temperaturas.length - 1];
        int rango = max - min;

        System.out.println("Temperatura minima: " + min);
        System.out.println("Temperatura maxima: " + max);
        System.out.println("Rango: " + rango);

        System.out.println("temperaturas mas bajas:");
        for (int i = 0; i < 3 && i < temperaturas.length; i++) {
            System.out.println(temperaturas[i]);
        }

        System.out.println("temperaturas mas altas:");
        for (int i = temperaturas.length - 1; i >= temperaturas.length - 3 && i >= 0; i--) {
            System.out.println(temperaturas[i]);
        }
    }
}
