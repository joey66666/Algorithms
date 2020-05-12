/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (33.34%)
 * Likes:    484
 * Dislikes: 0
 * Total Accepted:    60K
 * Total Submissions: 179.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */

// 字典序如下：
// 1 2 3
// 1 3 2
// 2 1 3
// 2 3 1
// 3 1 2
// 3 2 1


/*
 * Solution:
 * 1. 数组从后往前遍历，找到第一个降序数字
 * 2. 与后面子序列中最小的大于它的值交换
 * 3. 将子序列倒序
 * */
// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i -= 1;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) j -= 1;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
    }
    
    public void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }
}
// @lc code=end

