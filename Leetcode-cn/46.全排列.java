/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (76.05%)
 * Likes:    746
 * Dislikes: 0
 * Total Accepted:    139.1K
 * Total Submissions: 182.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> back = new LinkedList<>();
        backtrack(nums, back);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> back) {
        if (back.size() == nums.length) {
            res.add(new LinkedList<>(back));
            return;
        }

        for (int i : nums) {
            if (back.contains(i))
                continue;
            back.add(i);
            backtrack(nums, back);
            back.removeLast();
        }
    }
}
// @lc code=end

