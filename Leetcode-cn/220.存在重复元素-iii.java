/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 *
 * https://leetcode-cn.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (26.52%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    43.7K
 * Total Submissions: 160.2K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j])
 * ，同时又满足 abs(i - j)  。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 *
 * 示例 3：
 *
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *
 * 0
 * -2^31
 * 0
 * 0
 *
 *
 */

// @lc code=start
// 1. Solution1, DP + TreeSet, Time: O(n * log(min(n, k))), Space: O(min(n, k)), Runtime: 43%
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long index = set.ceiling((long) nums[i] - (long) t);
            if (index != null && index <= (long)nums[i] + (long)t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

// @lc code=end

