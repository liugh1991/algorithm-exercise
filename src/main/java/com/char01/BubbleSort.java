package main.java.com.char01;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i = arr.length - 1; i >= 0;i--){
            for(int j = 0; j < i ; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //for test
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int[] arr = {6,5,8,1,2};
        comparator(arr);
        int[] arr1 = {6,5,8,1,2};
        bubbleSort(arr1);
        Arrays.stream(arr).forEach((e) -> System.out.print(e + " "));
        System.out.println();
        System.out.println("------------------------");
        Arrays.stream(arr1).forEach((e) -> System.out.print(e + " "));
    }
}
