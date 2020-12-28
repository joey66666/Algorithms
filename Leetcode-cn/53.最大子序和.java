/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
// 暴力
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             int temp = 0;
//             for (int j = i; j < nums.length; j++) {
//                 temp += nums[j];
//                 if (temp > max) {
//                     max = temp;
//                 }
//             }
//         }
//         return max;
//     }
// }

// DP 
// 初始状态 nums[0]
// 状态转移 last + now > now, now = last + now
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int[] sum = new int[nums.length];
//         sum[0] = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] + sum[i - 1] > nums[i]) {
//                 sum[i] = nums[i] + sum[i - 1];
//             } else {
//                 sum[i] = nums[i];
//             }
//         }
//         int temp = sum[0];
//         for (int i = 1; i < sum.length; i++) {
//             if (temp < sum[i]) {
//                 temp = sum[i];
//             }
//         }
//         return temp;
//     }
// }
// DP2
// 若last < 0, 则 now + last < now，故 now = now 而不是 last + now
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int[] sum = new int[nums.length];
//         sum[0] = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             if (sum[i - 1] < 0) {
//                 sum[i] = nums[i];

//             } else {
//                 sum[i] = nums[i] + sum[i - 1];
//             }
//         }
//         int temp = sum[0];
//         for (int i = 1; i < sum.length; i++) {
//             if (temp < sum[i]) {
//                 temp = sum[i];
//             }
//         }
//         return temp;
//     }
// }


// DP
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return n;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end
