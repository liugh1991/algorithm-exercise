package main.java.com.char02;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (e >= s){
            int mid = s + (e-s)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[e]) {//mid --》 e 有序
                if (target < nums[mid] || target > nums[e]) {
                    e = mid - 1;
                } else s = mid + 1;
            } else {
                if (target < nums[s] || target > nums[mid]) {
                    s = mid + 1;
                } else e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("123".hashCode());
        System.out.println((48690 ^ (48690 >>> 16)) & (16 -1));
    }

}
