/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (52.28%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    21.3K
 * Total Submissions: 40.3K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
 * 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */

import java.util.HashMap;

// @lc code=start
// Solution1, HashMap
// Runtime: 19%
// Time: O(m * n)
//class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        HashMap<Character, Integer> hm = new HashMap<>();
//        for (int i = 0; i < magazine.length(); i++) {
//            if (!hm.containsKey(magazine.charAt(i))) {
//                hm.put(magazine.charAt(i), 1);
//            } else {
//                hm.put(magazine.charAt(i), hm.get(magazine.charAt(i)) + 1);
//            }
//        }
//        for (int i = 0; i < ransomNote.length(); i++) {
//            if (!hm.containsKey(ransomNote.charAt(i))) return false;
//            else {
//                if (hm.get(ransomNote.charAt(i)) <= 0) return false;
//                hm.put(ransomNote.charAt(i), hm.get(ransomNote.charAt(i)) - 1);
//            }
//        }
//        return true;
//    }
//}

// Solution2, 思路同HashMap，使用数组统计26字母使用的次数
// Runtime: 68%
// Time:O(m * n)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alpha[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (alpha[ransomNote.charAt(i) - 'a'] <= 0) return false;
            alpha[ransomNote.charAt(i) - 'a'] -= 1;
        }
        return true;
    }
}

// @lc code=end

