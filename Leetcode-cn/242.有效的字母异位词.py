#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
# https://leetcode-cn.com/problems/valid-anagram/description/
#
# algorithms
# Easy (63.98%)
# Likes:    394
# Dislikes: 0
# Total Accepted:    244.5K
# Total Submissions: 382.2K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
# 
# 示例 1:
# 
# 输入: s = "anagram", t = "nagaram"
# 输出: true
# 
# 
# 示例 2:
# 
# 输入: s = "rat", t = "car"
# 输出: false
# 
# 说明:
# 你可以假设字符串只包含小写字母。
# 
# 进阶:
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
# 
#

# @lc code=start
# Solution1, Hash, Time: O(n), Space: O(n), Runtime: 48%
# class Solution:
#     def isAnagram(self, s: str, t: str) -> bool:
#         if len(s) != len(t):
#             return False

#         dic = {}
#         for c in s:
#             if not c in dic:
#                 dic[c] = 1
#             else:
#                 dic[c] = dic[c] + 1
#         for c in t:
#             if c in dic and dic[c] > 0:
#                 dic[c] -= 1
#             else:
#                 return False
#         return True

# Solution2, 排序后比较两个str，Time: O(nlogn), Space: O(1), Runtime: 78%
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s = sorted(s)
        t = sorted(t)
        return s.equal(t)

# @lc code=end

