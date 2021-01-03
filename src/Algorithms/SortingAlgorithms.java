package Algorithms;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int [] arr = new int[]{6,5,8,12,16,14,10};
        arr = quickSort(arr, 0, arr.length - 1);
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

    private static int[]  quickSort(int[] arr, int low, int high) {
        if(low < high){
            int pivot = partitionArr(arr, low, high);
            quickSort(arr, pivot+ 1, high);
            quickSort(arr, low, pivot -1);
        }
        return arr;
    }

    private static int partitionArr(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low; j<high ; j++){
            if(arr[j] <= pivot){
                System.out.println(arr[j]+"-"+i+"-"+j);
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
