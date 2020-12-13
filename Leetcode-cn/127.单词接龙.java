/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (45.43%)
 * Likes:    662
 * Dislikes: 0
 * Total Accepted:    91.4K
 * Total Submissions: 200.4K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 *
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 *
 * 说明:
 *
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 *
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 */

import java.util.*;

// @lc code=start
// Solution1, 单向BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        Queue<String> q = new ArrayDeque();
        hm.put(beginWord, 0);
        q.add(beginWord);

        while (!q.isEmpty()) {
            String t = q.poll();
            for (String word : wordList) {
                if (check(word, t) && !hm.containsKey(word)) {
                    hm.put(word, hm.get(t) + 1);
                    q.add(word);
                    if (Objects.equals(endWord, word)) {
                        return hm.get(word) + 1;
                    }
                }
            }
        }
        return 0;
    }

    public boolean check(String a, String b) {
        int count = 0;
        int n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
            }
        }
        return count == 1;
    }
}
// @lc code=end


