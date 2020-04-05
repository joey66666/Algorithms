/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (41.29%)
 * Likes:    1486
 * Dislikes: 0
 * Total Accepted:    243.1K
 * Total Submissions: 588.4K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */


// @lc code=start
// Solution1 土方法
// class Solution {
//     public boolean isValid(String s) {
//         if (s.length() == 0 || s == null) return true;
//         Stack<Character> stack = new Stack<Character>();
//         for (int i = 0; i < s.length(); i++) {
//             Character now = s.charAt(i);
//             if (now.equals('(') || now.equals('{') || now.equals('[')) {
//                 stack.push(now);
//                 continue;
//             }
//             else if ((now.equals(')') || now.equals(']') || now.equals(']')) && stack.empty() || i == 0) return false;
//             else switch (now) {
//                     case (')'): {
//                         if (stack.peek().equals('(') && !stack.empty()) {
//                             stack.pop();
//                             continue;
//                         } else return false;
//                     }
//                     case ('}'): {
//                         if (stack.peek().equals('{') && !stack.empty()) {
//                             stack.pop();
//                             continue;
//                         } else return false;
//                     }
//                     case (']'): {
//                         if (stack.peek().equals('[') && !stack.empty()) {
//                             stack.pop();
//                             continue;
//                         } else return false;
//                     }
//                 }
//         }
//         if (stack.empty()) return true;
//         else return false;
//     }
// }

// Solution2 改进土方法，效率不变
// class Solution {
//     public boolean isValid(String s) {
//         if (s.length() == 0 || s == null) return true;
//         Stack<Character> stack = new Stack();
//         for (int i = 0; i < s.length(); i++) {
//             Character now = s.charAt(i);
//             if (now.equals('(') || now.equals('{') || now.equals('[')) {
//                 stack.push(now);
//                 continue;
//             }
//             // '('，')'，'{'，'}'，'['，']' 的 ASCII 码分别是 40、41、91、93、123、125
//             // 包含了 stack.pop() 后为空的情况
//             else if (stack.empty() || Math.abs(now - stack.pop()) > 2) return false;
//         }
//         return stack.empty();
//     }
// }

// Solution3
class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else if(stack.isEmpty() || c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
// @lc code=end

