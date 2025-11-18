import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SelectionSort sorting = new SelectionSort();
        Scanner sc = new Scanner(System.in);

        System.out.print("cuantos numeros deseas ingresar? > ");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("ingresa el numero > ");
            numeros[i] = sc.nextInt();
        }

        int[] pares = new int[n];
        int[] impares = new int[n];
        int cPares = 0, cImpares = 0;

        for (int i = 0; i < n; i++) {
            if (numeros[i] % 2 == 0) {
                pares[cPares] = numeros[i];
                cPares++;
            } else {
                impares[cImpares] = numeros[i];
                cImpares++;
            }
        }

        sorting.sort(pares, cPares);
        sorting.sort(impares, cImpares);

        System.out.println("arreglo original:");
        System.out.println(Arrays.toString(numeros));

        System.out.println("pares ordenados:");
        System.out.println(Arrays.toString(Arrays.copyOf(pares, cPares)));

        System.out.println("impares ordenados:");
        System.out.println(Arrays.toString(Arrays.copyOf(impares, cImpares)));
    }
}
