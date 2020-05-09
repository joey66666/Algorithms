/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.34%)
 * Likes:    119
 * Dislikes: 0
 * Total Accepted:    31K
 * Total Submissions: 71.5K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
// 暴力
// Runtime: 11%
// class Solution {
//     public boolean isPerfectSquare(int num) {
//         for (int i = 1; i <= num / i; i++) {
//             if (Math.pow(i, 2) == num) return true;
//         }
//         return false;
//     }
// }

// 二分
// Runtime：100%
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long t = mid * mid;
            if(t == num) return true;
            else if(t < num) left = mid + 1;
            else right = mid - 1;
        } 
        return false;
    }
}
// @lc code=end

