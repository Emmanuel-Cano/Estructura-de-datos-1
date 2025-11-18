import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantos numeros deseas ingresar? > ");
        int n = sc.nextInt();

        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el numero > ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(numeros));

        bubbleSort.sort(numeros);

        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(numeros));

        int minimo = numeros[0];
        int maximo = numeros[numeros.length - 1];
        int diferencia = maximo - minimo;

        System.out.println("Valor minimo: " + minimo);
        System.out.println("Valor maximo: " + maximo);
        System.out.println("Diferencia: " + diferencia);
    }
}
