/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

 // 遍历
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index=new int[]{0,1};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                    index[0]=i;
                    index[1]=j;
                    return index;
                }
            }
        }
        return index;
    }
}
// @lc code=end

