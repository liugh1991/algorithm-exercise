package main.java.com.char02;

import java.util.Arrays;
import java.util.Collections;

public class GetKLargestNum {
     // k <= arr.length
    public static Integer getKLargestNum(int[] arr,int k){
        if (arr == null ) {
            return null;
        }
        int ans =  getKLargestNum(arr,0,arr.length -1 ,k);
        return ans;
    }

    private static int getKLargestNum(int[] arr, int L, int R, int K){
        if(L == R) return arr[L];
        int eq = parititon(arr,L,R);
        if(eq + 1 == K) return arr[eq];
        else if(eq + 1 > K){
           return getKLargestNum(arr,L,eq - 1,K);
        }else{
            return getKLargestNum(arr,eq + 1,R,K);
        }
    }

    private static  int parititon(int[] arr, int l, int r) {
        if(l == r) return l;
        int index = l;
        int less = l - 1;
        int more = r;
        while(index < more){
            if(arr[index] <= arr[r]){
                less++;
                index++;
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,r);
        return more;
    }

    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,8,2,4,7,11,15};
        System.out.println(getKLargestNum(arr,8));
        Arrays.sort(arr);
    }




}
