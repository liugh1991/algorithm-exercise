package main.java.com.char01;

public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //将数组变成大根堆
        for(int i = arr.length - 1;i >= 0 ;i--){
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        while(left < length){
            int large = left + 1 < length && arr[left + 1] > arr[left] ? left + 1: left;
            large = arr[i] < arr[large] ? large : i;
            if(large == i){
                break;
            }
            swap(arr,i,large);
            i = large;
            left = 2 * i + 1;
        }
    }

    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,4,15,6,7,4,5,7,2,8};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


