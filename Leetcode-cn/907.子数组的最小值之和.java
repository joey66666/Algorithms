/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 *
 * https://leetcode-cn.com/problems/sum-of-subarray-minimums/description/
 *
 * algorithms
 * Medium (30.09%)
 * Likes:    148
 * Dislikes: 0
 * Total Accepted:    5.3K
 * Total Submissions: 17.7K
 * Testcase Example:  '[3,1,2,4]'
 *
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= A <= 30000
 * 1 <= A[i] <= 30000
 *
 *
 *
 *
 */

// @lc code=start
// Solution1，DP，三次遍历
// 假设A[i]左边有L个数大于它，右边有R个数大于它
// 则以A[i]为最小数共有 (L-1)*(R-1) 个子数组
// 防止出现重复多算的情况，在一边计算大于等于，另一边计算大于
// Time：O(N)
// https://leetcode.flowerplayer.com/2019/04/12/leetcode-907-sum-of-subarray-minimums-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
//class Solution {
//    public int sumSubarrayMins(int[] A) {
//        int[] leftDP = new int[A.length];
//        int[] rightDP = new int[A.length];
//        long mod = 1000000007;
//        // 左边
//        for (int i = 0; i < A.length; i++) {
//            int j = i - 1;
//            int leftNum = 1;
//            while (j >= 0 && A[j] >= A[i]) {
//                leftNum += leftDP[j];
//                j -= leftDP[j];
//            }
//            leftDP[i] = leftNum;
//        }
//
//        // 右边
//        for (int i = A.length - 1; i >= 0; i--) {
//            int j = i + 1;
//            int rightNum = 1;
//            while (j < A.length && A[j] > A[i]) {
//                rightNum += rightDP[j];
//                j += rightDP[j];
//            }
//            rightDP[i] = rightNum;
//        }
//
//        long res = 0;
//        for (int i = 0; i < A.length; i++) {
//            res += A[i] * leftDP[i] * rightDP[i];
//        }
//        return (int) (res % mod);
//    }
//}

import java.util.Stack;

// Solution2，单调栈，思路同[901]
class Solution {
    public int sumSubarrayMins(int[] A) {
        long mod = 1000000007;
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> steps = new Stack<>();
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        // 左边
        for (int i = 0; i < A.length; i++) {
            int s = 1;
            while (!nums.empty() && nums.peek() >= A[i]) {
                nums.pop();
                s += steps.pop();
            }
            nums.push(A[i]);
            steps.push(s);
            left[i] = s;
        }
        nums.clear();
        steps.clear();

        // 右边
        for (int i = A.length - 1; i >= 0; i--) {
            int s = 1;
            while (!nums.empty() && nums.peek() > A[i]) {
                nums.pop();
                s += steps.pop();
            }
            nums.push(A[i]);
            steps.push(s);
            right[i] = s;
        }

        long res = 0;
        for (int i = 0; i < A.length; i++) {
            res += left[i] * A[i] * right[i];
        }
        return (int) (res % mod);
    }
}

// @lc code=end
