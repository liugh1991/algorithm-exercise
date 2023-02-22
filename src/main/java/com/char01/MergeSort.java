package main.java.com.char01;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr,0,arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if( l == r){
            return;
        }
        int middle = l + (r - l) / 2;
        process(arr,l,middle);
        process(arr,middle + 1,r);
        merge(arr,l,middle,r);
    }

    private static void merge(int[] arr, int l, int middle, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = middle + 1;
        while(p1 <= middle && p2 <= r ){
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= middle){
           help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for (int e = 0; e < help.length; e++) {
            arr[l + e] = help[e];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,1,6,77,4,7,3,6,3,45,2,6,8,};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
