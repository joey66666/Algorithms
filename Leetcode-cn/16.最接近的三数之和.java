/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.81%)
 * Likes:    648
 * Dislikes: 0
 * Total Accepted:    174.9K
 * Total Submissions: 381.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int res = 10000;
        for(int i = 0; i < n; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return sum;
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum < target){
                    int index = left;
                    while(index < right && nums[index] == nums[left]){
                        index += 1;
                    }
                    left = index;
                }else{
                    int index = right;
                    while(index > left && nums[index] == nums[right]){
                        index -= 1;
                    }
                    right = index;
                }
            }
        }
        return res;
    }
}
// @lc code=end

