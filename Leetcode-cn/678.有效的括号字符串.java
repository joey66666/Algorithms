/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 *
 * https://leetcode-cn.com/problems/valid-parenthesis-string/description/
 *
 * algorithms
 * Medium (30.79%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    4.6K
 * Total Submissions: 14.7K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 *
 * 示例 1:
 *
 *
 * 输入: "()"
 * 输出: True
 *
 *
 * 示例 2:
 *
 *
 * 输入: "(*)"
 * 输出: True
 *
 *
 * 示例 3:
 *
 *
 * 输入: "(*))"
 * 输出: True
 *
 *
 * 注意:
 *
 *
 * 字符串大小将在 [1，100] 范围内。
 *
 *
 */

import java.util.Stack;

// @lc code=start

/**
 * Solution 1
 * 两个栈（ * 和 left ），遍历，存入index，遇到' ) '先用 left ，再用 * 抵消，都为空则false
 * 遍历完若两栈都不空，if（ index(left) > index(*) ) 则为" *( "形式，无法抵消，false；若可抵消则都pop
 * 若 pop 完 left 空，* 不空，* 可视为空字符串，true
 * 若 pop 完 left 不空，* 空，false
 **/
//class Solution {
//    public boolean checkValidString(String s) {
//        int l = s.length();
//        if (l == 0) return true;
//        Stack<Integer> star = new Stack<>();
//        Stack<Integer> left = new Stack<>();
//        for (int i = 0; i < l; i++) {
//            Character now = s.charAt(i);
//            if (now.equals('*')) {
//                star.push(i);
//            } else if (now.equals('(')) {
//                left.push(i);
//            } else {
//                if (!left.empty()) {
//                    left.pop();
//                } else if (!star.empty()) {
//                    star.pop();
//                } else {
//                    return false;
//                }
//            }
//        }
//        while (!star.empty() && !left.empty()) {
//            if (left.peek() < star.peek()) {
//                left.pop();
//                star.pop();
//            } else {
//                return false;
//            }
//        }
//        if (!left.empty()) {
//            return false;
//        }
//        return true;
//    }
//}


/**
 * Solution 2
 * 先从左往右遍历，所有 * 视为 ( ，* 和 ( 则 + 1，否则 - 1
 * 若中间有 < 0，则表示所有 * 不够抵消 ) ，return false
 * 若遍历完 = 0，表示 * 和 ( 正好抵消 )，return true
 * 若 > 0 ，可能有 * 补充了没用完，进行下一步
 * 下一步从右往左遍历， 所有 * 视为 ) ，* 和 ) 则 + 1，否则 - 1
 * 若过程中 < 0 ，( 数量大于 ), return false
 * 若遍历完 = 0，* 正好抵消，return true
 * 若遍历完 > 0，之前一轮遍历中 * 变的 数量 ( < 这一轮数量 ) ，表示部分 * 可变为 ( 或 ) 抵消，部分为空字符串, return true
 **/
class Solution {
    public boolean checkValidString(String s) {
        int l = s.length();
        if (l == 0) return true;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != ')') {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (sum < 0) return false;
        }
        if (sum == 0) return true;
        else {
            sum = 0;
            for (int i = l - 1; i >= 0; i--) {
                if (s.charAt(i) != '(') {
                    sum += 1;
                } else {
                    sum -= 1;
                }
                if (sum < 0) return false;
            }
            return true;
        }
    }
}
// @lc code=end