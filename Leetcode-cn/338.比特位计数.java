/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (78.92%)
 * Likes:    689
 * Dislikes: 0
 * Total Accepted:    120.2K
 * Total Submissions: 152.3K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */

// @lc code=start
// Solution1, 遍历，每个num再遍历计算，Time: O(n*sizeof(integer)), Space: O(n), Runtime: 23%
// class Solution {
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];
//         for(int i = 0; i <= num; i++) {
//             res[i] = count(i);
//         }
//         return res;
//     }

//     public int count(int num) {
//         int res = 0;
//         while(num != 0) {
//             res += num & 1;
//             num >>= 1;
//         }
//         return res;
//     }
// }

// Solution2, 利用之前计算好的，Time: O(n), Space: O(n), Runtime: 99%
//   - i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        // 从0和1开始Runtime一样，0开始Space16%，1开始%53，
        for(int i = 1; i <= num; i++) { 
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
// @lc code=end

