/*
 * @lc app=leetcode.cn id=1395 lang=java
 *
 * [1395] 统计作战单位数
 *
 * https://leetcode-cn.com/problems/count-number-of-teams/description/
 *
 * algorithms
 * Medium (82.73%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    11.9K
 * Total Submissions: 14.6K
 * Testcase Example:  '[2,5,3,4,1]'
 *
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * 
 * 
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] >
 * rating[k] ，其中  0 
 * 
 * 
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == rating.length
 * 3 
 * 1 
 * rating 中的元素都是唯一的
 * 
 * 
 */

// @lc code=start
// Solution1, 统计左右, Time: O(n^2), Space: O(1), Runtime: 10%
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        if(n == 0) return res;

        for(int i = 1; i < n - 1; i++){
            int lless = 0, lmore = 0, rless = 0, rmore = 0;
            for(int j = 0; j < i; j++){
                if(rating[j] < rating[i]){
                    lless += 1;
                }else if(rating[j] > rating[i]){
                    lmore += 1;
                }
            }

            for(int k = i + 1; k < n; k++){
                if(rating[k] < rating[i]){
                    rless += 1;
                }else if(rating[k] > rating[i]){
                    rmore += 1;
                }
            }
            res += lless * rmore + lmore * rless;
        }
        return res;
    }
}

// @lc code=end

