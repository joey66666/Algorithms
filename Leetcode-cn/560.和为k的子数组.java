/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 *
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.49%)
 * Likes:    297
 * Dislikes: 0
 * Total Accepted:    24.9K
 * Total Submissions: 55.6K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 *
 * 说明 :
 *
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 *
 */

// @lc code=start
// Solution1 Naive
// 暴力搜索，枚举所有子SubArray
// Time: O(n^3), Space: O(1)
//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int sum = 0;
//                for (int index = i; index <= j; index++)
//                    sum += nums[index];
//                if (sum == k) count += 1;
//            }
//        }
//        return count;
//    }
//}

// Solution 2 Optimized
// 去掉最里面的循环，用 prefixSum 变量表示
// Time:O(n^2), Space:O(1)
//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            int prefixSum = 0;
//            for (int j = i; j < nums.length; j++) {
//                prefixSum += nums[j];
//                if (prefixSum == k) count += 1;
//            }
//        }
//        return count;
//    }
//}

// Solution 3 Ultimate
// prefixSum array 记录从0到i的前缀sum
// subarray(i, j) = prefixSum(j) - prefixSum(i - 1)
// 找到 prefixSum(j)- prefixSum(i) == k == subarray(i, j)
// HashMap<Integer, Integer>: <prefixSum, prefixSum出现的次数>
// Time:O(n), Space:O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) count += hm.get(sum - k);
            if (!hm.containsKey(sum)) hm.put(sum, 1);
            else hm.put(sum, hm.get(sum) + 1);
            // 以下同义，写法优雅，速度慢一点
//            if (hm.containsKey(sum - k)) count += 1;
//            if (!hm.containsKey(sum)) hm.put(sum, 1);
//            else hm.put(sum, hm.get(sum) + 1);
        }
        return count;
    }
}
// @lc code=end

