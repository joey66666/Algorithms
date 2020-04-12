/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (43.20%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    94.4K
 * Total Submissions: 218.2K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        int i = 0;
        int j = s.length() - i - 1;
        s = s.toLowerCase();
        // 跑到一半，节约时间
        while (i < s.length() / 2 + 1 && j > s.length() / 2 - 1) {
            Character front = s.charAt(i);
            Character back = s.charAt(j);
            // 0-9：48-57，A-Z：65-90，a-z：97-122
            if (((front > 47 && front < 58) || (front > 64 && front < 91) || (front > 96 && front < 123)) &&
                    ((back > 47 && back < 58) || (back > 64 && back < 91) || (back > 96 && back < 123))) {
                if (front.equals(back)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if ((front > 47 && front < 58) || (front > 64 && front < 91) || (front > 96 && front < 123)) {
                j--;
            } else {
                i++;
            }
        }
        return true;
    }
}
// @lc code=end

