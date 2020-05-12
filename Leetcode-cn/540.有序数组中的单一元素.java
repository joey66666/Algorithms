/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 *
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (60.22%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 16.4K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 *
 * 示例 2:
 *
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 */

// @lc code=start
// 异或，很巧妙
// 但 Time:O(n)，不符合要求
//class Solution {
//    public int singleNonDuplicate(int[] nums) {
//        int n = 0;
//        for (int i = 0; i < nums.length; i++) {
//            n ^= nums[i];
//        }
//        return n;
//    }
//}


// 其他成对出现，所以SingleNumber存在的序列长度为奇数
// 对于中点位置和左右进行判断，再对左右子序列中的元素个数进行判断奇偶，找到单个元素存在的方向
// Time:O(logN)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid - 1]) {
                //nums[left, mid - 1]为偶数个且nums[mid - 1] == nums[mid]
                // 则nums[left, mid - 2]为奇数个，即存在SingleNumber
                if ((mid - left) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((right - mid) % 2 == 1) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else return nums[mid];
        }
        return nums[left];
    }
}
// @lc code=end

