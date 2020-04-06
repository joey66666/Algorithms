/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.17%)
 * Likes:    308
 * Dislikes: 0
 * Total Accepted:    62.9K
 * Total Submissions: 102.8K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start\
// Solution1，排序
// Time: O(m * n * logn)，runtime：99%
// Space: O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (hm.containsKey(sortedString)) {
                List<String> list = res.get(hm.get(sortedString));
                list.add(str);

            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hm.put(sortedString, res.size());
                res.add(list);
            }
        }
        return res;
    }
}

// Solution2，字母数组映射替代排序
// Time: O(m * n)，但 runtime：11%
// Space: O(n)
// class Solution {
// public List<List<String>> groupAnagrams(String[] strs) {
// HashMap<String, List<String>> hm = new HashMap<>();

// for (String str : strs) {
// int[] count = new int[26];
// for (Character ch : str.toCharArray()) {
// count[ch - 'a']++;
// }
// String s = "";
// for (int i = 0; i < count.length; i++) {
// if (count[i] != 0) {
// s += String.valueOf(count[i]) + String.valueOf((char) (i + 'a'));
// }
// }
// if (hm.containsKey(s)) {
// List<String> list = hm.get(s);
// list.add(str);
// } else {
// List<String> list = new ArrayList<>();
// list.add(str);
// hm.put(s, list);
// }
// }
// return new ArrayList<>(hm.values());
// }
// }
// @lc code=end
