/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (57.10%)
 * Likes:    743
 * Dislikes: 0
 * Total Accepted:    161.9K
 * Total Submissions: 283.2K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 进阶：
 *
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 示例 3：
 *
 *
 * 输入：nums = [0]
 * 输出：[0]
 *
 *
 * 示例 4：
 *
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 *
 *
 * 提示：
 *
 *
 * n == nums.length
 * 1
 * nums[i] 为 0、1 或 2
 *
 *
 */


// @lc code=start
// Solution1: 单指针遍历两次
// 第一次把 0 交换到前面
// 第二次把 1 交换到前面
// Time: O(n), Space: O(1), Runtime: 100%
// class Solution {
//     public void sortColors(int[] nums) {
//         int n = nums.length;
//         if (n == 0 || n == 1) return;
//         int start = 0;
//         int p = 0;
//         while(p < n){
//             if(nums[p] == 0){
//                 nums[p] = nums[start];
//                 nums[start] = 0;
//                 p += 1;
//                 start += 1;
//             }else{
//                 p += 1;
//             }
//         }
//         p = start;
//         while(p < n){
//             if(nums[p] == 1){
//                 nums[p] = nums[start];
//                 nums[start] = 1;
//                 p += 1;
//                 start += 1;
//             }else{
//                 p += 1;
//             }
//         }
//     }
// }


// Solution2: 双指针遍历一次
// p0, p1分别表示0和1的位置，初始为0
    // 遇到1: 交换nums[i], nums[p1],移动p1
    // 遇到0: 
        // 此情况下可能发生把前面的1交换到后面的情况，所以把1交换到后面后再交换到p1
        // 先交换nums[i], nums[p0]，
        // 如果p0 < p1, 再交换nums[i], nums[p1], 
        // p0和p1均移动
// Time: O(n), Space: O(1), Runtime: 100%
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p1];
                nums[p1] = 1;
                p1 += 1;
            } else if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                if (p0 < p1) {
                    int t = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = t;
                }
                p0 += 1;
                p1 += 1;
            }
        }
    }
}
// @lc code=end

