import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SelectionSort sorting = new SelectionSort();

        System.out.println("Cuantas calificaciones deseas ingresar?: ");
        int n = scanner.nextInt();

        String[] names = new String[n];
        int[] arr = new int[n];

        System.out.println("Ingresa los datos del aliumno: ");
        for(int i = 0; i < n; i ++){
            System.out.println("Nombre del alumno >" );
            names[i] = scanner.next();
            System.out.println("Calificacion del alumno >" );
            arr[i] = scanner.nextInt();
        }

        System.out.println("Calificaciones sin ordenar: ");
        for(int i= 0; i< n; i++){
            System.out.println(names[i] + ": " + arr[i]);
        }
        sorting.sort(arr, names);
        System.out.println("Calificaciones ordenadas: ");
        for(int i= 0; i< n; i++){
            System.out.println(names[i] + ": " + arr[i]);
        }


    }
}
