/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (53.23%)
 * Likes:    289
 * Dislikes: 0
 * Total Accepted:    87.3K
 * Total Submissions: 163.1K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */

// @lc code=start
// Solution1 暴力
// Time: O(n^2)
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] res = new int[2];
//         for (int i = 0; i < numbers.length - 1; i++) {
//             for (int j = i + 1; j < numbers.length; j++) {
//                 if (numbers[i] + numbers[j] == target) {
//                     res[0] = i + 1;
//                     res[1] = j + 1;
//                 }
//             }
//         }
//         return res;
//     }
// }

// Solution2 头尾指针
// 头尾和 > target, 尾指针左移
// 头尾和 < target, 头指针右移
// Time: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] + nums[right] < target){
                left += 1;
            }else if(nums[left] + nums[right] > target) {
                right -= 1;
            }else if(nums[left] + nums[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}

// @lc code=end

