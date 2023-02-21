package main.java.com.char01;

public class CountingSort {
    public static void countingSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        int[] countArr = new int[max + 1];
        for(int i = 0; i < arr.length;i++){
            countArr[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while(countArr[i] > 0){
                arr[index++] = i;
                countArr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,4,15,6,7,4,5,7,2,8};
        countingSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
