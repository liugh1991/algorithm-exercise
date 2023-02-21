package main.java.com.char01;

public class RadixSoft {
    public static void radixSoft(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int maxDigit = getMaxDigit(arr);
        int[] help = new int[arr.length];
        final int radix = 10;
        for (int digit = 1 ; digit <= maxDigit ; digit++) {//从各位到最高位
            int[] count = new int[radix];
            for (int j = 0; j < arr.length; j++) {
                count[getDigitValue(arr[j],digit)]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
            for (int j = arr.length - 1;j >= 0; j--){
                int value = getDigitValue(arr[j], digit);
                help[count[value] - 1] = arr[j];
                count[value]--;
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = help[j];
            }
        }
    }

    private static int getDigitValue(int num,int digit) {
        return ((num / ((int) Math.pow(10, digit - 1))) % 10);
    }

    private static int getMaxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        int ans = 0;
        while(max > 0){
            max = max / 10;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,4,15,6,7,4,5,7,2,8};
        radixSoft(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
