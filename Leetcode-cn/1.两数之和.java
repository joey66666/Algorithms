/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
// HashSet
// @lc code=start
// Solution1: HashMap, Runtime: 67%
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         for(int i = 0;i < nums.length; i++){
//             hm.put(nums[i], i);
//         }
//         int[] res = new int[2];
//         for(int i = 0; i < nums.length; i++){
//             if(hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i){
//                 res[0] = i;
//                 res[1] = hm.get(target - nums[i]);
//                 break;
//             }
//             hm.put(nums[i], i);
//         }
//         return res;   
//     }
// }

// Solution2, HashMap, Runtime: 100%
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            if(hm.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = hm.get(target - nums[i]);
                return res;
            }
            hm.put(nums[i], i); 
        }
        return res;   
    }
}
// @lc code=end
