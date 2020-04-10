/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (48.25%)
 * Likes:    920
 * Dislikes: 0
 * Total Accepted:    167.1K
 * Total Submissions: 346.4K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 */

// @lc code=start
/* Solution1 找规律
 是一个斐波那契数列
 n = 1, res = 1
 n = 2, res = 2
 n = 3, res = 3
 n = 4, res = 5
 n = 5, res = 8
 */
class Solution {
   public int climbStairs(int n) {
       int last = 0, now = 1, res = 0;
       for (int i = 0; i < n; i++) {
           res = now + last;
           last = now;
           now = res;
       }
       return res;
   }
}
// @lc code=end

