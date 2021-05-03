#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#
# https://leetcode-cn.com/problems/reverse-integer/description/
#
# algorithms
# Easy (33.94%)
# Likes:    1780
# Dislikes: 0
# Total Accepted:    314.6K
# Total Submissions: 927K
# Testcase Example:  '123'
#
# 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
#
# 示例 1:
#
# 输入: 123
# 输出: 321
#
#
# 示例 2:
#
# 输入: -123
# 输出: -321
#
#
# 示例 3:
#
# 输入: 120
# 输出: 21
#
#
# 注意:
#
# 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
#
#

# @lc code=start
# 1. Solution1, 模拟运算, Time: O(n), Space: O(1), Runtime: 77%
#   - res = res * 10 + x % 10
#   - x //= 10
#   - 在 python 里 //= 会对负数向下取整，所以正负数分情况
class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        if x > 0:
            flag = 1
        elif x < 0:
            flag = -1
        else:
            return 0
        x = abs(x)
        while x != 0:
            res = res * 10 + x % 10
            x //= 10
        res = flag * res
        if (res > (2 ** 31) - 1) or (res < -(2 ** 31)):
            return 0
        else:
            return res
# @lc code=end
