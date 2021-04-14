#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#
# https://leetcode-cn.com/problems/valid-parentheses/description/
#
# algorithms
# Easy (41.29%)
# Likes:    1486
# Dislikes: 0
# Total Accepted:    243.1K
# Total Submissions: 588.4K
# Testcase Example:  '"()"'
#
# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
#
# 有效字符串需满足：
#
#
# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
#
#
# 注意空字符串可被认为是有效字符串。
#
# 示例 1:
#
# 输入: "()"
# 输出: true
#
#
# 示例 2:
#
# 输入: "()[]{}"
# 输出: true
#
#
# 示例 3:
#
# 输入: "(]"
# 输出: false
#
#
# 示例 4:
#
# 输入: "([)]"
# 输出: false
#
#
# 示例 5:
#
# 输入: "{[]}"
# 输出: true
#
#

# @lc code=start
# 1. Solution1, 栈，Time: O(n), Space: O(n), Runtime: 86%
#    - 简单栈，左边括号放进去，右边括号pop出来并匹配
#    - 注意只有一个括号的边界情况
class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        for ch in s:
            if ch == '(' or ch == '[' or ch == '{':
                stack.append(ch)
            elif len(stack) > 0:
                chr = stack.pop()
                if ch == ')' and chr == '(':
                    continue
                if ch == ']' and chr == '[':
                    continue
                if ch == '}' and chr == '{':
                    continue
                else:
                    return False
            else:
                return False
        if len(stack) > 0:
            return False
        return True
# @lc code=end
