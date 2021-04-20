#
# @lc app=leetcode.cn id=28 lang=python3
#
# [28] 实现 strStr()
#
# https://leetcode-cn.com/problems/implement-strstr/description/
#
# algorithms
# Easy (39.66%)
# Likes:    404
# Dislikes: 0
# Total Accepted:    148.9K
# Total Submissions: 375.5K
# Testcase Example:  '"hello"\n"ll"'
#
# 实现 strStr() 函数。
#
# 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
# (从0开始)。如果不存在，则返回  -1。
#
# 示例 1:
#
# 输入: haystack = "hello", needle = "ll"
# 输出: 2
#
#
# 示例 2:
#
# 输入: haystack = "aaaaa", needle = "bba"
# 输出: -1
#
#
# 说明:
#
# 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
#
# 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
#
#

# @lc code=start
# 1. Solution1, 暴力，Time: O(n * m), Space: O(1), Runtime: 39%
#   - 每个 haystack 按字符匹配 needle, 不符合立即停止该字串匹配,
# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         n1, n2 = len(haystack), len(needle)
#         if n2 == 0:
#             return 0
#         for i in range(0, n1 - n2 + 1):
#             if haystack[i] == needle[0]:
#                 p1, p2 = i, 0
#                 while p1 <= n1 and p2 < n2 and haystack[p1] == needle[p2]:
#                     p1 += 1
#                     p2 += 1
#                 if p2 == n2:
#                     return i
#         return -1

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n1, n2 = len(haystack), len(needle)
        if n2 == 0:
            return 0
        for i in range(0, n1 - n2 + 1):
            flag = True
            for j in range(0, n2):
                if haystack[i + j] != needle[j]:
                    flag = False
                    break
            if flag:
                return i
        return -1
# @lc code=end
