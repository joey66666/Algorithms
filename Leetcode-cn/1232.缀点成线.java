/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 *
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/description/
 *
 * algorithms
 * Easy (51.25%)
 * Likes:    23
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 11.8K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]'
 *
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y]
 * 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 *
 *
 *
 * 提示：
 *
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 *
 *
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2 && coordinates[0].length == 2) return true;
        double xa = coordinates[0][0];
        double ya = coordinates[0][1];
        double xb = coordinates[1][0];
        double yb = coordinates[1][1];

        double angle = (yb - ya) / (xb - xa);
        for (int i = 2; i < coordinates.length; i++) {
            double tmp = (coordinates[i][1] - ya) / (coordinates[i][0] - xa);
            if (angle != tmp) return false;
        }
        return true;
    }
}
// @lc code=end

