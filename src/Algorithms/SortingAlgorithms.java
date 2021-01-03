package Algorithms;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] arr = new int[]{6,5,8,12,16,14,10};
//        arr = quickSort(arr, 0, arr.length - 1);
        arr = bubbleSort(arr);
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i] +" - ");
        }
    }

    private static int[] bubbleSort(int [] arr){
        for(int i=0; i<arr.length -1; i++){
            for(int j= i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] mergeSort(){

    }

    private static int[]  quickSort(int[] arr, int low, int high) {
        if(low < high){
            int partition = partition(arr, low, high);
            arr = quickSort(arr, low, partition -1);
            arr = quickSort(arr, partition + 1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for(int j = low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return (i + 1);
    }
}
