/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (50.06%)
 * Likes:    459
 * Dislikes: 0
 * Total Accepted:    88.7K
 * Total Submissions: 174.9K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是
 * "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 *
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 *
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 *
 *
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 *
 *
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
// 递归，DFS
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // Corner Case
        if (s.length() < 4 || s.length() > 12) return res;
        dfs(res, "", s, 0);
        return res;
    }

    // sub: 当前取的string
    // s: 剩下未取的string
    public void dfs(List<String> res, String sub, String s, int index) {
        // 优化
        if (s.length() > 3 * (4 - index)) return;
        // 递归出口
        if (index == 4 && s.length() == 0) {
            res.add(sub.substring(1));
            return;
        }
        if (index == 4 || s.length() == 0) return;
        // 一位
        dfs(res, sub + "." + s.charAt(0), s.substring(1), index + 1);
        // 两位，不能以0开头
        if (s.charAt(0) != '0' && s.length() > 1) {
            dfs(res, sub + "." + s.substring(0, 2), s.substring(2), index + 1);
            // 三位, <= 255
            if (s.length() > 2 && Integer.parseInt(s.substring(0, 3)) <= 255) {
                dfs(res, sub + "." + s.substring(0, 3), s.substring(3), index + 1);
            }
        }
    }
}
// @lc code=end

