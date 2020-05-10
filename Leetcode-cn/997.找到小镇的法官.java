/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 *
 * https://leetcode-cn.com/problems/find-the-town-judge/description/
 *
 * algorithms
 * Easy (50.62%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 30.7K
 * Testcase Example:  '2\n[[1,2]]'
 *
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 *
 *
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 *
 *
 * 示例 2：
 *
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 *
 *
 * 示例 3：
 *
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 *
 *
 * 示例 4：
 *
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 *
 *
 * 示例 5：
 *
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] 是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 *
 */

// @lc code=start
/* 
有向图，[a, b]表示从顶点a出发指向顶点b的一条有向边。
是否存在且只存在一个顶点，所有的顶点都指向他，但是这个点不指向任何点。
即该顶点的入度是N - 1，出度是0.
使用一个数组存储每个点的入度和出度的差，当某个点的入度和出度的差是N - 1时，代表他是法官，否则不存在。
证明：如果入度和出度的差 = N - 1，又入度、出度 >= 0，那么入度 = N- 1，出度 = 0，满足条件1和2.
     一旦存在一个点满足条件，那么说明这个点没有出度，所以不存在另一个点的入度是N - 1，满足条件3.
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) return N == 1 ? 1 : -1;
        int[] sub = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            int out = trust[i][0];
            int in = trust[i][1];
            sub[out] -= 1;
            sub[in] += 1;
        }
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == N - 1) return i;
        }
        return -1;
    }
}
// @lc code=end

