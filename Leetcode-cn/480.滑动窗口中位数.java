/*
 * @lc app=leetcode.cn id=480 lang=java
 *
 * [480] 滑动窗口中位数
 *
 * https://leetcode-cn.com/problems/sliding-window-median/description/
 *
 * algorithms
 * Hard (37.51%)
 * Likes:    168
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 28.1K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 *
 *
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1
 * 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * ⁠1 [3  -1  -3] 5  3  6  7      -1
 * ⁠1  3 [-1  -3  5] 3  6  7      -1
 * ⁠1  3  -1 [-3  5  3] 6  7       3
 * ⁠1  3  -1  -3 [5  3  6] 7       5
 * ⁠1  3  -1  -3  5 [3  6  7]      6
 *
 *
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *
 *
 * 提示：
 *
 *
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *
 *
 */


// @lc code=start
// BF: Time: O((n - k + 1)*klogk) = O(n^2logn), all pass，but TLE
//class Solution {
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        double[] tmp = new double[k];
//        // 奇偶标志，奇 true，偶 false
//        boolean flag = k % 2 == 1;
//        double[] res = new double[n - k + 1];
//        for (int i = 0; i < n - k + 1; i++) {
//            for (int j = 0; j < k; j++) {
//                tmp[j] = nums[i + j];
//            }
//            Arrays.sort(tmp);
//            // 长度为奇数
//            double left = tmp[(k - 1) / 2];
//            if (flag) {
//                res[i] = left;
//            } else {
//                double right = tmp[(k - 1) / 2 + 1];
//                res[i] = (left + (right - left) / 2);
//            }
//            if (n == k) {
//                return res;
//            }
//        }
//        return res;
//    }
//}

// Solution1: 改进BF 插入排序，Time: O(k*logk +  (n – k + 1)*k), Space: O(k), Runtime: 67%
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[k];
        double[] res = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        for (int j = k; j <= n; j++) {
            res[j - k] = ((double)window[k / 2] + window[(k - 1) / 2]) / 2;
            if(j == n) break;
            remove(window, nums[j - k]);
            insert(window, nums[j]);
        }
        return res;
    }

    public void remove(int[] window, int num) {
        // 手动遍历查找，Runtime: 44%
        // int i = 0;
        // while (i < window.length && window[i] != num) {
        //     i += 1;
        // }

        // 使用BinarySearch改进, Runtime: 67%
        int i = Arrays.binarySearch(window, num);
        while (i < window.length - 1) {
            window[i] = window[++i];
        }
    }

    private void insert(int[] window, int num) {
        // int i = 0;
        // while (i < window.length - 1 && window[i] < num) {
        //     i += 1;
        // }

        int i = Arrays.binarySearch(window, num);
        if (i < 0) i = - i - 1;
        int j = window.length - 1;
        while (j > i) {
            window[j] = window[--j];
        }
        window[j] = num;
    }
}

// @lc code=end
