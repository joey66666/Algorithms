/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (40.99%)
 * Likes:    561
 * Dislikes: 0
 * Total Accepted:    121.1K
 * Total Submissions: 293.3K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *
 */

// @lc code=start
// Solution1, 头插法
// Runtime: 21%
// Time:O( k * n)
//class Solution {
//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k %= n;
//        for (int i = 0; i < k; i++) {
//            int tmp = nums[n - 1];
//            for (int j = n - 1; j > 0; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = tmp;
//        }
//    }
//}

// Solution2, 三次翻转，第一次数组倒序，第二次以k为分界线前后子数组分别倒序
// 比如12345经过翻转就变成了54321，这样已经做到了把前面的数字放到后面去，但是还没有完全达到要求，只需要把12放在后面去，目标数组就是34512。与54321对比发现我们就只需要在把分界线前后数组再进行翻转一次就可得到目标数组了
// Runtime: 100%
// Time:O(n) //O(2n)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }
}
// @lc code=end

