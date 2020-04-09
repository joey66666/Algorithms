/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.34%)
 * Likes:    340
 * Dislikes: 0
 * Total Accepted:    74.7K
 * Total Submissions: 142.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 *
 * 提示：
 *
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 *
 */

// @lc code=start
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) carry += a.charAt(i) - '0';
            if (j >= 0) carry += b.charAt(j) - '0';
            sb.append(carry % 2);
            carry /= 2;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
// @lc code=end