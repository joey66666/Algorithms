/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[count]!=nums[i]){
                count+=1;
                nums[count]=nums[i];
            }
        }
        return count+1;
    }
}
// @lc code=end

