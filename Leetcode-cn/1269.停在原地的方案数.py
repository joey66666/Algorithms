#
# @lc app=leetcode.cn id=1269 lang=python3
#
# [1269] 停在原地的方案数
#
# https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
#
# algorithms
# Hard (41.00%)
# Likes:    158
# Dislikes: 0
# Total Accepted:    23.2K
# Total Submissions: 47.8K
# Testcase Example:  '3\n2'
#
# 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
#
# 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
#
# 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
#
# 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
#
#
#
# 示例 1：
#
# 输入：steps = 3, arrLen = 2
# 输出：4
# 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
# 向右，向左，不动
# 不动，向右，向左
# 向右，不动，向左
# 不动，不动，不动
#
#
# 示例  2：
#
# 输入：steps = 2, arrLen = 4
# 输出：2
# 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
# 向右，向左
# 不动，不动
#
#
# 示例 3：
#
# 输入：steps = 4, arrLen = 2
# 输出：8
#
#
#
#
# 提示：
#
#
# 1 <= steps <= 500
# 1 <= arrLen <= 10^6
#
#
#

# @lc code=start
# 1. Solution1, DP, Time: O(m * n), Space: O(m * n), Runtime: 50%
#   - 定义: dp[i][j]dp[i][j] 代表 step 为 i, arr 数组下标为 j 时, 方案的个数
#   - 状态转移方程: dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1]dp[i][j]=dp[i−1][j]+dp[i−1][j−1]+dp[i−1][j+1]
#      - 到达 j 原地不动的话, dp[i][j] = dp[i-1][j]dp[i][j]=dp[i−1][j], 就是把 step = i-1 的方案数拿过来
#      - 到达 j 是从 j-1, 从 j 左边过来的, 移动一位可以到达 j, 所以把 dp[i-1][j-1]dp[i−1][j−1] 的方案数加上
#      - 到达 j 是从 j+1, 从 j 右边过来的, 移动一位可以到达 j, 所以把 dp[i-1][j+1]dp[i−1][j+1] 的方案数加上
#      - 题目允许不移动或者左右移动一位, 所以可以把以上的结果都加起来
#  - 注意下标边界
#      - 当 j=0 时，dp[i−1][j−1]=0
#      - 当 j=min(arrLen−1,steps) 时，dp[i−1][j+1]=0  

class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        MOD = 10**9 + 7
        maxLen = min(steps//2 + 1, arrLen)
        dp = [[0] * maxLen for _ in range(steps + 1)]
        dp[0][0] = 1
        for step in range(1, steps + 1):
            for j in range(maxLen):
                # 不动
                dp[step][j] = dp[step - 1][j] % MOD
                # 从左往右移一步
                if j-1 >= 0:
                    dp[step][j] = (dp[step][j]+dp[step - 1][j - 1]) % MOD
                # 从右往左移一步
                if j+1 < maxLen:
                    dp[step][j] = (dp[step][j] + dp[step - 1][j + 1]) % MOD
        return dp[steps][0]


# @lc code=end
