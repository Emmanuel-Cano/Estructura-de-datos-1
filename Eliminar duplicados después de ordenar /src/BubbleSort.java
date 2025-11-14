import java.util.Arrays;


public class BubbleSort {
    public void sort(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        //Recorremos todos los elementos del arreglo
        for (int i = 0; i < n - 1; i++){
            //Recorremos todos lo elementos adyacentes -1 -i (por los que ya fueron recorridos)
            for (int j = 0; j < n - 1 -i; j++){

                //Preguntar si el ele,ento corriente es mayor que el siguiente
                if(arr[j] > arr[j + 1]){
                    //Se realiza el intercambio
                    int temp = arr[j]; //pasa el elemento siguiente al actual
                    arr[j] = arr[j + 1]; //asigna el elemento actual con el valor del siguiente
                    arr[j + 1] = temp; //asigna el siguiente elemento con el valor de temp
                    swapped = true;
                }
            }
            if(!swapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }
public int[] eliminarDuplicados(int[] arr) {
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) count++;
        }
        int[] result = new int[count];
        result[0] = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[++index] = arr[i];
            }
        }
        return result;
    }
}
