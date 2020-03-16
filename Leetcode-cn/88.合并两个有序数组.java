/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[m - 1 + n] = nums2[n - 1];
                n--;
            } else {
                int temp;
                temp = nums1[m - 1];
                nums1[m - 1] = nums1[m - 1 + n];
                nums1[m - 1 + n] = temp;
                m--;
            }
        }
        if (m == 0 && n > 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
// @lc code=end
