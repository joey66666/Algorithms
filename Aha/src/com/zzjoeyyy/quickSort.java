package com.zzjoeyyy;

import java.util.Arrays;

public class quickSort {

    public static void Sort(int[] nums, int left, int right) {
        int i, j, p;
        int temp = 0;

        if (left >= right)
            return;

        i = left;
        j = right;
        p = nums[i];

        while (i < j) {
            while (nums[j] >= p && i < j) {
                j--;
            }
            while (nums[i] <= p && i < j) {
                i++;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[left] = nums[i];
        nums[i] = p;

        Sort(nums, left, j - 1);
        Sort(nums, i + 1, right);

    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {6, 4, 3, 2, 12, 9, 1, 8, 5};
        Sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
