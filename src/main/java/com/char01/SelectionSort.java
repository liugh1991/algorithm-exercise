package main.java.com.char01;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //在0~n-1上找到最小值，放在0位置
        //在1~n-1上找到最小值，放在1位置
        //...
        for (int i = 0; i < arr.length ; i++) {
            int min = i;
            for(int j = i; j < arr.length; j++){
                min =  arr[j] < arr[min] ? j : min;
            }
            swap(arr,min,i);
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
        selectionSort(arr1);
        Arrays.stream(arr).forEach((e) -> System.out.print(e + " "));
        System.out.println();
        System.out.println("------------------------");
        Arrays.stream(arr1).forEach((e) -> System.out.print(e + " "));
    }
}
