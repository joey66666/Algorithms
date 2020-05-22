/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (34.51%)
 * Likes:    3674
 * Dislikes: 0
 * Total Accepted:    492.9K
 * Total Submissions: 1.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */

import java.util.HashMap;

// @lc code=start
// 双循环遍历
// Runtime: 13%
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1 || s.length() == 0) return s.length();
//        HashMap<Character, Integer> hm = new HashMap<>();
//        int count = 0;
//        int max = 0;
//        for (int j = 0; j < s.length(); j++) {
//            for (int i = j; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (!hm.containsKey(c)) {
//                    hm.put(c, 1);
//                    count += 1;
//                } else {
//                    hm.clear();
//                    count = 0;
//                    break;
//                }
//                max = Math.max(count, max);
//            }
//        }
//        return max;
//    }
//}

// Solution 2, 双指针
// [left, right]区间保存子串的左右区间，set里面是不重复的字符。
// 使用while循环，如果right字符不在set中，put; 如果right在，就把left对应的字符remove。
// Runtime: 48%
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1 || s.length() == 0) return s.length();
//        HashMap<Character, Integer> hm = new HashMap<>();
//
//        int left = 0;
//        int right = 0;
//        int res = 0;
//        while (left < s.length() && right < s.length()) {
//            char l = s.charAt(left);
//            char r = s.charAt(right);
//            if (!hm.containsKey(r)) {
//                hm.put(r, right);
//                right += 1;
//                res = Math.max(res, hm.size());
//            } else {
//                if (hm.containsKey(l)) {
//                    left = hm.get(l);
//                    hm.remove(l);
//                }
//                left += 1;
//            }
//        }
//        return res;
//    }
//}

// Solution 3, 保存前缀，一次遍历
// 当right向后遍历的过程中，如果这个字符在字典中，说明这个字符在前面出现过，即这个区间已经不是题目要求的不含重复字符的区间了
// 因此，需要移动left到right字符上次出现的下一位置，hm.get(s.charAt(right)) + 1。
// left更新的时候需要保留最大（最右）的位置，即left不回头
// e.g.: 对于abba，当right指向最后的a的时候，left指向的是字典中保留的有第一个位置的a，如果不对此进行判断的话，left会移动到第一个字符b（回头）
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (hm.containsKey(r)) {
                left = Math.max(left, hm.get(r) + 1);
            }
            hm.put(r, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
// @lc code=end

