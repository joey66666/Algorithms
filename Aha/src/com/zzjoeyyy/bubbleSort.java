package com.zzjoeyyy;

import java.util.Arrays;

public class bubbleSort {

    public static void Sort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] < nums[j + 1]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        int[] nums = {6, 4, 3, 2, 12, 9, 1, 8, 5};
        Sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
