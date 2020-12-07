/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 *
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/description/
 *
 * algorithms
 * Medium (74.56%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    23.1K
 * Total Submissions: 28.5K
 * Testcase Example:  '[[0,0,1,1],[1,0,1,0],[1,1,0,0]]'
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 *
 */


// @lc code=start
class Solution {
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int rows = A.length;
        int cols = A[0].length;
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int res = 0;
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][j] == 0) {
                    count += 1;
                }
            }
            res += (1 << cols - 1 - j) * Math.max(count, rows - count);
        }

        return res;
    }
}
// @lc code=end

