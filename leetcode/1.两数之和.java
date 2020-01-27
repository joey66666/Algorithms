import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// https://www.jianshu.com/p/6cd3d9194062
// 1. 遍历
// // @lc code=start
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] index=new int[]{0,1};
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 int sum=nums[i]+nums[j];
//                 if(sum==target){
//                     index[0]=i;
//                     index[1]=j;
//                     return index;
//                 }
//             }
//         }
//         return index;
//     }
// }

// 2. HashSet
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1, index2;
        int[] index = new int[] { 0, 1 };
        Set nset = new HashSet();

        for (index1 = 0; index1 < nums.length; index1++) {
            if (nset.add(target - nums[index1])) {
                nset.remove(target - nums[index1]);
                nset.add(nums[index1]);
            } else {
                index[1] = index1;
                for (index2 = 0; index2 < index1; index2++) {
                    if (nums[index1] + nums[index2] == target) {
                        index[0] = index2;
                    }
                }
            }
        }
        return index;
    }
}

// @lc code=end
