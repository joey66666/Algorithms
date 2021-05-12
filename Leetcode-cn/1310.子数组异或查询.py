#
# @lc app=leetcode.cn id=1310 lang=python3
#
# [1310] 子数组异或查询
#
# https://leetcode-cn.com/problems/xor-queries-of-a-subarray/description/
#
# algorithms
# Medium (66.97%)
# Likes:    112
# Dislikes: 0
# Total Accepted:    31.7K
# Total Submissions: 44.7K
# Testcase Example:  '[1,3,4,8]\n[[0,1],[1,2],[0,3],[3,3]]'
#
# 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
#
# 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor
# arr[Ri]）作为本次查询的结果。
#
# 并返回一个包含给定查询 queries 所有结果的数组。
#
#
#
# 示例 1：
#
# 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
# 输出：[2,7,14,8]
# 解释：
# 数组中元素的二进制表示形式是：
# 1 = 0001
# 3 = 0011
# 4 = 0100
# 8 = 1000
# 查询的 XOR 值为：
# [0,1] = 1 xor 3 = 2
# [1,2] = 3 xor 4 = 7
# [0,3] = 1 xor 3 xor 4 xor 8 = 14
# [3,3] = 8
#
#
# 示例 2：
#
# 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
# 输出：[8,0,4,4]
#
#
#
#
# 提示：
#
#
# 1 <= arr.length <= 3 * 10^4
# 1 <= arr[i] <= 10^9
# 1 <= queries.length <= 3 * 10^4
# queries[i].length == 2
# 0 <= queries[i][0] <= queries[i][1] < arr.length
#
#
#

# @lc code=start
# 1. Solution1, 异或性质, Time: O(n), Space: O(n), Runtime: 80%
#   - `[l, r] = [0, l - 1] XOR [0, r]`  
#       - 如`[2, 3] = [0, 1] XOR [0, 3]`
#   - 先遍历一遍 `attr`, 计算 `[0, r]`，再遍历`queries`，`append([l - 1] ^ [right])`
#       - trick: `l == 0` 的直接返回`[0, r]`
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        preMap = {}
        t = 0
        for k, v in enumerate(arr):
            t ^= v
            preMap[k] = t
        res = []
        for left, right in queries:
            if left == 0:
                res.append(preMap[right])
            else:
                res.append(preMap[left - 1] ^ preMap[right])
        return res

# @lc code=end
