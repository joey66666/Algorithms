/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/description/
 *
 * algorithms
 * Easy (44.44%)
 * Likes:    768
 * Dislikes: 0
 * Total Accepted:    106.5K
 * Total Submissions: 239.5K
 * Testcase Example:  '[1,2,3,1]'
 *
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 */

// @lc code=start
/*
 * 维护一个一位数组 dp，其中 dp[i] 表示 [0, i] 区间可以抢夺的最大值
 * 对当前i来说，有抢和不抢两种互斥的选择
 * 不抢即为 dp[i-1]（等价于去掉 nums[i] 只抢 [0, i-1] 区间最大值）
 * 抢即为 dp[i-2] + nums[i]（等价于去掉 nums[i-1]）
 * 比如 nums为{3, 2, 1, 5}，首先 dp[0]=3 , dp[1]，由于3比2大，所以抢第一个房子的3，当前房子的2不抢，则dp[1]=3
 * dp[2]，由于不能抢相邻的，所以可以用再前面的一个的 dp 值加上当前的房间值，和当前房间的前面一个 dp 值比较，取较大值当做当前 dp 值
 * 状态转移方程 dp[i] = max(num[i] + dp[i - 2], dp[i - 1]),
 * 需要初始化 dp[0] 和 dp[1]
 * dp[0] 为 num[0]，dp[1] 为 max(num[0], num[1])
 * */
class Solution {
    public int rob(int[] nums) {
        int res = 0;
        if (nums == null || nums.length == 0) return res;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
// @lc code=end

