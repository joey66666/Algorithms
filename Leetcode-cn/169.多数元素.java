/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (62.87%)
 * Likes:    579
 * Dislikes: 0
 * Total Accepted:    161.1K
 * Total Submissions: 255.5K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 *
 */

// @lc code=start
// Solution1 HashMap，过程中 if hm.get(nums[i]) > nums.length /2 则返回
// Runtime: 38%
// Time: O(n), Space: O(n)

//class Solution {
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> hm = new HashMap();
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int cur = nums[i];
//            if (!hm.containsKey(cur)) hm.put(cur, 1);
//            else hm.put(cur, hm.get(cur) + 1);
//            if (hm.get(cur) > (nums.length / 2)) res = nums[i];
//        }
//        return res;
//    }
//}

// Solution2，摩尔投票法
// 假设 nums[0] 为最多元素，遍历，相同 + 1，不同 - 1
// 若归零，则前面其他和本身数量相等，对冲抵消，指针当下指向另一个数，换成另一个数，对后面继续遍历比较
// Runtime: 99%
// Time: O(n), Space: O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int start = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (start == nums[i]) count += 1;
            else {
                count -= 1;
                if (count == 0) {
                    start = nums[i];
                    count = 1;
                }
            }
            if (count > nums.length / 2) return start;
        }
        return start;
    }
}
// @lc code=end