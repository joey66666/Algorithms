/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (60.18%)
 * Likes:    542
 * Dislikes: 0
 * Total Accepted:    127K
 * Total Submissions: 210.9K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
// Solution1 双指针遍历
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int j = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 if (nums[j] == 0) {
//                     nums[j] = nums[i];
//                     nums[i] = 0;
//                 }
//                 j++;

//             }
//         }
//     }
// }

// Solution2 先把非零移到前面，统计0个数n，把后n个置0
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            } else
                count++;
        }
        for (int k = 0; k < count; k++) {
            nums[nums.length - k - 1] = 0;
        }
    }
}
// @lc code=end
