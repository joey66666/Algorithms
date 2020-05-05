/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (44.73%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    74.8K
 * Total Submissions: 167.2K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 */


// @lc code=start
// Solution1, HashMap计次数
// Runtime: 30%
// Time: O(n) //2n
//class Solution {
//    public int firstUniqChar(String s) {
//        if (s == null || s.length() == 0) return -1;
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!hm.containsKey(s.charAt(i))) hm.put(s.charAt(i), 1);
//            else hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (hm.get(s.charAt(i)) == 1) return i;
//        }
//        return -1;
//    }
//}


// 字母表数组计数，原理同HashMap
// Runtime: 86%
// Time: O(n) //2n
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
// @lc code=end

