
import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr, String[] names ){

        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++ ){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;

            String name = names[minIndex];
            names[minIndex] = names[i];
            names[i]= name;
        }
    }

}