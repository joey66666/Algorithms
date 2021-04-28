#
# @lc app=leetcode.cn id=633 lang=python3
#
# [633] 平方数之和
#
# https://leetcode-cn.com/problems/sum-of-square-numbers/description/
#
# algorithms
# Medium (35.38%)
# Likes:    195
# Dislikes: 0
# Total Accepted:    49K
# Total Submissions: 134.2K
# Testcase Example:  '5'
#
# 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
# 
# 
# 
# 示例 1：
# 
# 输入：c = 5
# 输出：true
# 解释：1 * 1 + 2 * 2 = 5
# 
# 
# 示例 2：
# 
# 输入：c = 3
# 输出：false
# 
# 
# 示例 3：
# 
# 输入：c = 4
# 输出：true
# 
# 
# 示例 4：
# 
# 输入：c = 2
# 输出：true
# 
# 
# 示例 5：
# 
# 输入：c = 1
# 输出：true
# 
# 
# 
# 提示：
# 
# 
# 0 <= c <= 2^31 - 1
# 
# 
#

# @lc code=start
# 1. Solutio1, 双指针, Time: O(n), Space: O(1), Runtime: 48%
#   - 在 [1, int(根号c + 1)] 区间内计算，结果大于 c 右指针左移，结果小于 c 左指针右移
class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        left, right = 0, int(c ** 0.5) + 1
        while left <= right:
            t = left ** 2 + right ** 2
            if t > c:
                right -= 1
            elif t < c:
                left += 1
            else:
                return True
        return False

# @lc code=end

