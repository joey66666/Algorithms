/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 *
 * https://leetcode-cn.com/problems/number-complement/description/
 *
 * algorithms
 * Easy (68.38%)
 * Likes:    154
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 29.4K
 * Testcase Example:  '5'
 *
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 *
 * 示例 2:
 *
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 *
 *
 * 注意:
 *
 *
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 *
 */

// @lc code=start
// 直接 ~ 按位取反，前缀的0也会被取反，用 ^ 异或
// 如：101 ^ 111 = 010。怎么得到111？考虑111 + 1 = 1000，而1000又是 最小的 大于101的 只有一位是1 的二进制数。
// 解决方法：
// 1. 找到最小的大于原数字的二进制值仅有一位为1的数；
// 2. 将此数减1；
// 3. 与原数字按位求异或。
class Solution {
    public int findComplement(int num) {
        // Integer.highestOneBit(num)：拿到num最高位，后面补0，如 101 返回 100 
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
// @lc code=end

