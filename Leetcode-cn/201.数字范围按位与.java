/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 *
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (44.49%)
 * Likes:    103
 * Dislikes: 0
 * Total Accepted:    10.4K
 * Total Submissions: 23.3K
 * Testcase Example:  '5\n7'
 *
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 */

// @lc code=start

// Solution 1
// 最后的数是该数字范围内所有的数的左边共同的部分
// 只要找到左边公共的部分
// 直接平移m和n，每次向右移一位，直到m和n相等
// 记录下所有平移的次数i，然后再把m左移i位即为最终结果
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i += 1;
        }
        return m << i;
    }
}

// Solution 2
// 从后往前每次 n = (n & (n-1)), 直到n <= m, 然后返回n,
// 逐渐将最右边不同的置为0, 最后只剩下最左边m 和 n相同的位置.
// 举例：110与上(110-1)，得到100，相当于去掉最低位的1，
// n就这样每次去掉最低位的1，如果小于等于m了，返回此时的n

//class Solution {
//    public int rangeBitwiseAnd(int m, int n) {
//        while (n > m) {
//            n &= n - 1;
//        }
//        return n;
//    }
//}


// @lc code=end

