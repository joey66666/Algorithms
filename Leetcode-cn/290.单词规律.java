/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (42.52%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    26.1K
 * Total Submissions: 60.9K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 */

import java.util.HashMap;
import java.util.Objects;

// @lc code=start
// 简单HashMap，注意区分a和b的value不能相等
// 使用`Object.equals()`取代 `==` 更健壮
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.split(" ");
        HashMap<Character, String> hm = new HashMap<>();
        if (pattern.length() != splitStr.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char word = pattern.charAt(i);
            if (hm.containsKey(word)) {
                if (!Objects.equals(splitStr[i], hm.get(word))) {
                    return false;
                }
            } else {
                if (hm.containsValue(splitStr[i])) return false;
                hm.put(word, splitStr[i]);
            }
        }
        return true;
    }
}
// @lc code=end

