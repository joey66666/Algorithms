#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#
# https://leetcode-cn.com/problems/decode-ways/description/
#
# algorithms
# Medium (24.87%)
# Likes:    566
# Dislikes: 0
# Total Accepted:    76.1K
# Total Submissions: 305.1K
# Testcase Example:  '"12"'
#
# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
#
#
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。
#
# 题目数据保证答案肯定是一个 32 位的整数。
#
#
#
# 示例 1：
#
#
# 输入：s = "12"
# 输出：2
# 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
#
#
# 示例 2：
#
#
# 输入：s = "226"
# 输出：3
# 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
#
#
# 示例 3：
#
#
# 输入：s = "0"
# 输出：0
#
#
# 示例 4：
#
#
# 输入：s = "1"
# 输出：1
#
#
# 示例 5：
#
#
# 输入：s = "2"
# 输出：1
#
#
#
#
# 提示：
#
#
# 1
# s 只包含数字，并且可能包含前导零。
#
#
#

# @lc code=start
# Solution1, DP数组, Time: O(n), Space: O(n), Runtime: 71%
#   - DP含义：`dp[i]`表示前`i`个字符的解码方式数
#   - 初始条件：`dp[0] = 1`, 空字符串有一种解码方式，解析出空字符串
#   - 状态转移方程：
#         1. 使用当前位解析一位数, 需要满足的条件: `s[i] != "0"`，当前解码方式数等`i - 1`解码方式数，即`dp[i] = dp[i - 1]`
#         2. 使用上一位和这一位解析两位数, 需要满足的条件：`s[i - 1] != "0" and s[i - 1] + s[i] <= 26`, 此时 `dp[i] = dp[i - 2]`
#   - 终止：每一步满足条件时对`dp[i]`进行累加，最后结果为`dp[-1]`

# class Solution:
#     def numDecodings(self, s: str) -> int:
#         n = len(s)
#         if n == 0:
#             return 1
#         dp = [1] + [0] * n
#         for i in range(1, n + 1):
#             if s[i - 1] != "0":
#                 dp[i] += dp[i - 1]
#             if i > 1 and s[i - 2] != "0" and (int(s[i - 2]) * 10 + int(s[i - 1])) < 27:
#                 dp[i] += dp[i - 2]
#         return dp[-1]

# Solution2, DP变量, Time: O(n), Space: O(1), Runtime: 5%
class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if n == 0:
            return 1
        a, b, c = 0, 1, 0  # i-2, i-1, i
        for i in range(1, n + 1):
            c = 0
            if s[i - 1] != "0":
                c += b
            if i > 1 and s[i - 2] != "0" and int(s[i - 2:i]) < 27:
                c += a
            a, b = b, c
        return c
# @lc code=end
