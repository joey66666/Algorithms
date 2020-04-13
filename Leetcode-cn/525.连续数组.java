/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 *
 * https://leetcode-cn.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (41.73%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    4K
 * Total Submissions: 9.5K
 * Testcase Example:  '[0,1]'
 *
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 
 * 示例 2:
 * 
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * 
 * 
 * 
 * 注意: 给定的二进制数组的长度不会超过50000。
 * 
 */

// @lc code=start
// Solution 1 先处理再比较
// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n = nums.length;
//         if (n == 0 || n == 1) return 0;
//         int[] sum = new int[n + 1];
//         for (int i = 1; i <= n; i++) {
//             sum[i] = sum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
//         }


//         HashMap<Integer, Integer> hm = new HashMap<>();
//         hm.put(0, 0);
//         int res = 0;
//         for (int i = 1; i <= sum.length - 1; i++) {
//             if (!hm.containsKey(sum[i])) {
//                 hm.put(sum[i], i);
//             } else {
//                 res = (i - hm.get(sum[i]) > res) ? (i - hm.get(sum[i])) : res;
//             }
//         }
//         return res;
//     }
// }

// Solution 2 边处理边比较
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (hm.containsKey(sum)) {
                res = i - hm.get(sum) > res ? i - hm.get(sum) : res;
            } else {
                hm.put(sum, i);
            }
        }
        return res;
    }
}
// @lc code=end

