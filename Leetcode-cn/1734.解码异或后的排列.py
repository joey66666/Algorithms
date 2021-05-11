#
# @lc app=leetcode.cn id=1734 lang=python3
#
# [1734] 解码异或后的排列
#
# https://leetcode-cn.com/problems/decode-xored-permutation/description/
#
# algorithms
# Medium (45.06%)
# Likes:    114
# Dislikes: 0
# Total Accepted:    23.4K
# Total Submissions: 32.7K
# Testcase Example:  '[3,1]'
#
# 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
# 
# 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1]
# 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
# 
# 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
# 
# 
# 
# 示例 1：
# 
# 输入：encoded = [3,1]
# 输出：[1,2,3]
# 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
# 
# 
# 示例 2：
# 
# 输入：encoded = [6,5,4,6]
# 输出：[2,4,1,5,3]
# 
# 
# 
# 
# 提示：
# 
# 
# 3 <= n < 10^5
# n 是奇数。
# encoded.length == n - 1
# 
# 
#

# @lc code=start
# 1. Solution1, 数学规律, Time: O(n), Space: O(1) (return 不算), Runtime: 47%
#   - 读题：perm 是前 n 个正整数的排列，即 perm 里的值为[1, n]
#   - 关键是找到 p[0]
#   - 1) p[0] ^ p[1] ^ … ^ p[n-1] = 1 ^ 2 ^ … ^ n
#   - 2) encoded[1] ^ encode[3] ^ … ^ encoded[n-2] = (p[1] ^ p[2]) ^ (p[3] ^ p[4]) ^ … ^ (p[n-2] ^ p[n-1])
#   - 1) xor 2) = p[0]
#   - p[i] = p[i – 1] ^ encoded[i – 1]
class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        n = len(encoded) + 1
        perm = [0] * n
        for i in range(1, n + 1):
            perm[0] ^= i
        for i in range(1, n, 2):
            perm[0] ^= encoded[i]
        for i in range(1, n):
            perm[i] = perm[i - 1] ^ encoded[i - 1]
        return perm
# @lc code=end

