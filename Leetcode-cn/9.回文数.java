/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (57.27%)
 * Likes:    983
 * Dislikes: 0
 * Total Accepted:    286.1K
 * Total Submissions: 499.5K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
// class Solution {
//     public boolean isPalindrome(int x) {
//         String n = Integer.toString(x);
//         for (int i = 0; i < n.length() / 2; i++) {
//             if (n.charAt(i) != n.charAt(n.length() - i - 1)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int m = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (res == m) ? true : false;
    }
}
// @lc code=end
