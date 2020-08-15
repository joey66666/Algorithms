/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 *
 * https://leetcode-cn.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (66.63%)
 * Likes:    250
 * Dislikes: 0
 * Total Accepted:    41.9K
 * Total Submissions: 62.5K
 * Testcase Example:  '38'
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 *
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 */

// @lc code=start
// Solution1, 找规律
class Solution {
    public int addDigits(int num) {
        // 每9个循环一次，直接 % 9的话18这种9的倍数会出错
        // % 9的升级版
        return (num - 1) % 9 + 1;
    }
}

// Solution2，硬解
//class Solution {
//    public int addDigits(int num) {
//        if (num == 0) return 0;
//        else if (num % 9 == 0) return 9;
//        else return num % 9;
//    }
//}

// @lc code=end

