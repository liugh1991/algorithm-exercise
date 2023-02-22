package main.java.com.char01;

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L >= R){
            return;
        }
       int[] range =  partition(arr,L,R);
        process(arr,L,range[0] - 1);
        process(arr,range[1] + 1,R);
    }

    private static int[] partition(int[] arr, int l, int r) {
        if(l > r){
            return new int[]{-1,-1};
        }
        if(l == r){
            return new int[]{l,r};
        }
        int index = l;
        int less = l - 1;
        int more = r;
        int flag = l + (int)(Math.random() * (r - l + 1));
        swap(arr,flag,r);
        while(index < more){
            if(arr[index] < arr[r]){
                swap(arr,index++,++less);
            }else if(arr[index] == arr[r]){
                index++;
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more ,r);
        return new int[] {less + 1,more};

    }

    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,4,15,6,7,4,5,7,2,8};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
