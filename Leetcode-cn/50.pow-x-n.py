#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#
# https://leetcode-cn.com/problems/powx-n/description/
#
# algorithms
# Medium (37.53%)
# Likes:    680
# Dislikes: 0
# Total Accepted:    194K
# Total Submissions: 516.5K
# Testcase Example:  '2.00000\n10'
#
# 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
#
#
#
# 示例 1：
#
#
# 输入：x = 2.00000, n = 10
# 输出：1024.00000
#
#
# 示例 2：
#
#
# 输入：x = 2.10000, n = 3
# 输出：9.26100
#
#
# 示例 3：
#
#
# 输入：x = 2.00000, n = -2
# 输出：0.25000
# 解释：2^-2 = 1/2^2 = 1/4 = 0.25
#
#
#
#
# 提示：
#
#
# -100.0
# -2^31 
# -10^4
#
#
#

# @lc code=start
# 1. Solution1, 递归分治, Time: O(logn), Space: O(1), Runtime: 40%
#   - 按奇偶分组，x^n -> x^(n/2) -> ... -> x^1 -> x^0
#       1. 偶数: y = x^(n/2), res = y^2
#       2. 奇数: y = x^(n//2), res = x * y^2
#   - 注意 n < 0，需要计算导数，即res = myPow(1 / x, -n)
# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         if n == 0:
#             return 1
#         if n < 0:
#             return self.myPow(1 / x, -n)
#         # 偶数
#         if n % 2 == 0:
#             return self.myPow(x ** 2, n // 2)
#         # 奇数
#         else:
#             return self.myPow(x ** 2, n // 2) * x

# 1. Solution2, 非递归，分治，Time: O(logn), Space: O(1), Runtime: 66%
#   - 思路与 Solution1 相同
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        pow = 1
        while n:
            if n & 1:
                pow *= x
            x *= x
            n >>= 1
        return pow
        
# @lc code=end
