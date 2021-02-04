/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (39.78%)
 * Likes:    147
 * Dislikes: 0
 * Total Accepted:    34.8K
 * Total Submissions: 79.5K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 k n
 * 所给数据范围 [-10,000，10,000]。
 *
 *
 */

// @lc code=start
// Solution1, Sliding Window, Time: O(n), Space: O(1), Runtime: 100%
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }
        int max = count;
        for (int i = k; i < nums.length; i++) {
            count = count - nums[i - k] + nums[i];
            max = Math.max(count, max);
        }
        return (double) max / k;
    }
}
// @lc code=end

