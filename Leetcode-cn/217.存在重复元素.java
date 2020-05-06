/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (52.17%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    131.5K
 * Total Submissions: 251.8K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 */


// @lc code=start
// 简单HashMap
// Runtime: 48%
// import java.util.HashMap;
//class Solution {
//    public boolean containsDuplicate(int[] nums) {
//        if (nums.length == 0) return false;
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!hm.containsKey(nums[i])) {
//                hm.put(nums[i], 1);
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//}



// HashSet
// Set特点：不存储重复元素；没有get，只可以iterator访问；无序
// Runtime: 70%
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Set<Integer> hs = new HashSet<Integer>();
        for (int i : nums) hs.add(i);
        return hs.size() < nums.length ? true : false;
    }
}
// @lc code=end

