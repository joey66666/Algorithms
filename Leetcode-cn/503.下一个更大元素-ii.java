/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 *
 * https://leetcode-cn.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (54.50%)
 * Likes:    169
 * Dislikes: 0
 * Total Accepted:    26.7K
 * Total Submissions: 47.2K
 * Testcase Example:  '[1,2,1]'
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x
 * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 *
 * 注意: 输入数组的长度不会超过 10000。
 *
 */

// @lc code=start
// Solution1, 暴力，每个数向前向后遍历两次
//class Solution {
//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        // 数组初始化
//        for (int i = 0; i < n; i++) {
//            res[i] = Integer.MIN_VALUE;
//        }
//        for (int i = 0; i < n; i++) {
//            // 向后
//            for (int j = i; j < n; j++) {
//                if (nums[i] < nums[j]) {
//                    res[i] = nums[j];
//                    break;
//                }
//            }
//            if (res[i] == Integer.MIN_VALUE) {
//                // 向前
//                for (int j = i; j >= 0; j--) {
//                    if (nums[i] < nums[j]) {
//                        res[i] = nums[j];
//                    }
//                }
//            }
//            if (res[i] == Integer.MIN_VALUE) {
//                res[i] = -1;
//            }
//        }
//        return res;
//    }
//}

import java.util.Arrays;
import java.util.Stack;

// Solution2，单调栈
// 1.将数组中所有元素全部置为-1
// 2.遍历两次，相当于循环遍历
// 3.第一遍遍历，入栈索引i
// 4.只要后面元素比栈顶索引对应的元素大，索引出栈，更改res[sta.pop()]的数值
// 5.最后栈里面剩余的索引对应的数组值，都为默认的-1（因为后面未找到比它大的值） */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;

    }
}
// @lc code=end

