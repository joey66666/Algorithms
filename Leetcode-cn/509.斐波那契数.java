/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 *
 * https://leetcode-cn.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (66.20%)
 * Likes:    223
 * Dislikes: 0
 * Total Accepted:    131.4K
 * Total Submissions: 192.8K
 * Testcase Example:  '2'
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 
 * 
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 
 * 
 * 给你 n ，请计算 F(n) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * 
 * 
 */

// @lc code=start
// 经典DP, Time: O(n), Space: O(1), Runtime: 100%
// class Solution {
//     public int fib(int n) {
//         if(n == 0 || n == 1) return n;
//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;
//         for(int i = 2; i < n + 1; i++){
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

// 优化DP, 滚动数组, Space: O(1), Runtime: 100%
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int i = 0;
        int j = 1;
        int k = i + j;
        for(int index = 0; index < n - 2; index++){
            i = j;
            j = k;
            k = i + j;
        }
        return k;
    }
}
// @lc code=end

