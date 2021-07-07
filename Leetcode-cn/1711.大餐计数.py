#
# @lc app=leetcode.cn id=1711 lang=python3
#
# [1711] 大餐计数
#
# https://leetcode-cn.com/problems/count-good-meals/description/
#
# algorithms
# Medium (25.29%)
# Likes:    101
# Dislikes: 0
# Total Accepted:    24.4K
# Total Submissions: 70.1K
# Testcase Example:  '[1,3,5,7,9]'
#
# 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
# 
# 你可以搭配 任意 两道餐品做一顿大餐。
# 
# 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i^​​​​​​​​​​​​​​
# 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
# 
# 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
# 
# 
# 
# 示例 1：
# 
# 
# 输入：deliciousness = [1,3,5,7,9]
# 输出：4
# 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
# 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
# 
# 
# 示例 2：
# 
# 
# 输入：deliciousness = [1,1,1,3,3,3,7]
# 输出：15
# 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
# 
# 
# 
# 提示：
# 
# 
# 1 
# 0 
# 
# 
#

# @lc code=start
#
# @lc app=leetcode.cn id=1711 lang=python3
#
# [1711] 大餐计数
#
# https://leetcode-cn.com/problems/count-good-meals/description/
#
# algorithms
# Medium (25.29%)
# Likes:    101
# Dislikes: 0
# Total Accepted:    24.4K
# Total Submissions: 70.1K
# Testcase Example:  '[1,3,5,7,9]'
#
# 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
#
# 你可以搭配 任意 两道餐品做一顿大餐。
#
# 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i^​​​​​​​​​​​​​​
# 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
#
# 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
#
#
#
# 示例 1：
#
#
# 输入：deliciousness = [1,3,5,7,9]
# 输出：4
# 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
# 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
#
#
# 示例 2：
#
#
# 输入：deliciousness = [1,1,1,3,3,3,7]
# 输出：15
# 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
#
#
#
# 提示：
#
#
# 1
# 0
#
#
#

# @lc code=start
# 1. Solution1, Hash + 枚举2的幂 + 两数和 + visted, Time: O(nlogc), Space: O(n), Runtime: 99%
#   - 思路：
    #   1. 0 <= deliciousness[i] <= 2^20, 2的幂是有限的，即：pows=[2^0, 2^1, ..., 2^21]
    #   2. 相同的数字，餐品数量为：(n-1)! == n * (n-1) / 2
    #   3. 不同的数字，餐品数量为：n * m
#   - 解法
#       1. 统计deliciousness中每个数字出现的次数到Hash
#       2. 对Hash的key里的每个数字k，遍历pows，判断pow - k是否在Hash中
#           - 若存在，则(k, pow - k)可组成大餐，根据思路2和思路3可得到大餐数量
#       3. 如(1,3)和(3,1)可能统计两次，设置visited的set，通过两个数组成唯一key，判重

class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        dic, pows, res, visited = defaultdict(int), [0] * 22, 0, set()
        # 0 <= deliciousness[i] <= 20, 取到21
        for i in range(22):
            pows[i] = 2 ** i
        for num in deliciousness:
            dic[num] += 1
        for k, v in dic.items():
            for t in pows:
                if t > k and (t - k) in dic:
                    if t - k == k:
                        res += int((v * (v - 1)) / 2)
                    else:
                        key = f'{max(k, t - k)},{min(k, t - k)}'
                        # # 等价写法如下, e.g: '3,4'
                        # key = '{},{}'.format(min(t, t - k), max(t, t - k))
                        if key not in visited:
                            visited.add(key)
                            res += dic[k] * dic[t - k]

        return res % (10 ** 9 + 7)

    # @lc code=end

# @lc code=end

