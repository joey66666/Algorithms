/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (59.90%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    111K
 * Total Submissions: 183.9K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */

import java.util.Arrays;
import java.util.HashMap;

// @lc code=start
// Solution1, HashMap
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> hm = new HashMap<>();
//        if (s.length() != t.length()) return false;
//        for (int i = 0; i < s.length(); i += 1) {
//            Character c = s.charAt(i);
//            if (hm.containsKey(c)) {
//                hm.put(c, hm.get(c) + 1);
//            } else {
//                hm.put(c, 1);
//            }
//        }
//        for (int j = 0; j < t.length(); j += 1) {
//            Character c2 = t.charAt(j);
//            if (!hm.containsKey(c2) || hm.get(c2) <= 0) {
//                return false;
//            } else {
//                hm.put(c2, hm.get(c2) - 1);
//            }
//        }
//        return true;
//    }
//}

// Solution2, Alphabet数组
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        int[] alpha = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            Character c1 = s.charAt(i);
//            Character c2 = t.charAt(i);
//            alpha[c1 - 'a'] += 1;
//            alpha[c2 - 'a'] -= 1;
//        }
//        for (int i = 0; i < alpha.length; i++) {
//            if (alpha[i] != 0) return false;
//        }
//        return true;
//    }
//}

// Solution3, Sort()
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] charArr1 = s.toCharArray();
        char[] charArr2 = t.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        return Arrays.equals(charArr1, charArr2);
    }
}
// @lc code=end

