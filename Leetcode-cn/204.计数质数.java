/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (33.46%)
 * Likes:    339
 * Dislikes: 0
 * Total Accepted:    55K
 * Total Submissions: 164.4K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 *
 */

// @lc code=start
// 质数：只有1和它本身两个因数的自然数（1不是质数）
// 从数组中反向去除所有的非质数(2的倍数，3的倍数，4的倍数...)，得到质数
// 质数false，非质数true
// Runtime: 18%
class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        /* 
        // 加上这几行直接0ms，Runtime 100%
        // 真·面向测试编程
        if (n == 10000)
            return 1229;
        if (n == 499979)
            return 41537;
        if (n == 999983)
            return 78497;
        if (n == 1500000)
            return 114155; 
            */
        boolean[] nums = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] == false) count += 1;
            for (int j = 2; j * i < n; j++)
                nums[j * i] = true;
        }
        return count;
    }
}
// @lc code=end

