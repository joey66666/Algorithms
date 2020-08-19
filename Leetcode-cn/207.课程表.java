/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (51.12%)
 * Likes:    354
 * Dislikes: 0
 * Total Accepted:    40.6K
 * Total Submissions: 78.9K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 *
 * 提示：
 *
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 *
 *
 */

import java.util.*;


// @lc code=start
// Solution1, BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组
        int[] inDegree = new int[numCourses];
        // 出度邻接表[index, index出度的List]
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (hm.containsKey(prerequisites[i][1])) {
                hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
                inDegree[prerequisites[i][0]] += 1;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                hm.put(prerequisites[i][1], list);
                inDegree[prerequisites[i][0]] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> list = hm.get(index);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    inDegree[list.get(i)] -= 1;
                    if (inDegree[list.get(i)] == 0) {
                        queue.add(list.get(i));
                    }
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

