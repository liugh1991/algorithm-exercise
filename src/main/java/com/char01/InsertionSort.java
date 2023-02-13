package main.java.com.char01;

public class InsertionSort {
    public static  void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1 ; j >= 0; j--) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,1,6,77,4,7,3,6,3,45,2,6,8,};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
