/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (47.28%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    36.4K
 * Total Submissions: 77K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */


// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0 && t.length() == 0) return true;
        else if (s.length() == 0 || t.length() == 0) return false;
        else {
            Object[] chars = new Object[128];
            for (int i = 0; i < s.length(); i++) {
                int key = s.charAt(i);
                char val = t.charAt(i);
                if (chars[key] == null) {
                    chars[key] = val;
                } else {
                    if (!chars[key].equals(val)) return false;
                }
            }
            chars = new Object[128];
            for (int i = 0; i < t.length(); i++) {
                int key = t.charAt(i);
                char val = s.charAt(i);
                if (chars[key] == null) {
                    chars[key] = val;
                } else {
                    if (!chars[key].equals(val)) return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

