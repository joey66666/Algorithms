/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (29.65%)
 * Likes:    282
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 79.3K
 * Testcase Example:  '"1432219"\n3'
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 *
 * 示例 1 :
 *
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 *
 * 示例 2 :
 *
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 *
 * 示例 3 :
 *
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 *
 */

import java.util.Stack;

// @lc code=start
// Solution1，贪心；
// 从左到右找到第一个递减的位置，将前面的大数删掉；
// 1432219 “43”位置递减，将4删掉
// 132219 “32”位置递减，将3删掉
// 12219 “21”位置递减，将2删掉
// 最后结果1219
// 若整个数字全部是递增的，只把末尾删除；
// 不能有前导0，即”0200“，把前导0删掉，即”200“

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 边角情况
        if (k >= num.length()) {
            return "0";
        }

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k -= 1;
            }
            // 去掉前导0：charAt(i)==0且stack.isEmpty()表示当前0前无数字，是前导0
            if (num.charAt(i) != '0' || !stack.isEmpty())
                stack.push(num.charAt(i));
        }

        // 递增，没去除干净，从尾部开始去除
        while (k > 0) {
            stack.pop();
            k -= 1;
        }

        // 答案只为0的情况
        if (stack.isEmpty()) {
            return "0";
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

