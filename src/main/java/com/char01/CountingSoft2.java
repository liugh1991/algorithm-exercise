package main.java.com.char01;

import java.util.Arrays;

public class CountingSoft2 {

    public static void countingSort(int[] array, int max) {
        int[] countArray = new int[max + 1]; // create count array

        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++; // count occurrence of each element
        }

        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1]; // update count array with cumulative sum
        }

        int[] sortedArray = new int[array.length]; // create sorted array

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i]] - 1] = array[i]; // place elements in sorted array
            countArray[array[i]]--; // decrement count
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = sortedArray[i]; // copy sorted array back to original array
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 5, 2, 3, 5};
        int max = 9;
        countingSort(array, max);
        System.out.println(Arrays.toString(array)); // prints [2, 2, 3, 5, 5, 5, 9]
    }
}

