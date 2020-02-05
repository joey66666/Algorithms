package com.zzjoeyyy;

public class Queue {

    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 7, 5, 8, 9, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int head = 0;
        int tail = 9;

        while (head < tail) {
            System.out.print(nums[head]);
            head++;

            nums[tail] = nums[head];
            tail++;
            head++;
        }
    }
}
