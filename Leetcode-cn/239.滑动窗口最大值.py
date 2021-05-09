#
# @lc app=leetcode.cn id=239 lang=python3
#
# [239] 滑动窗口最大值
#
# https://leetcode-cn.com/problems/sliding-window-maximum/description/
#
# algorithms
# Hard (49.54%)
# Likes:    972
# Dislikes: 0
# Total Accepted:    149.3K
# Total Submissions: 301.3K
# Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
#
# 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
# 个数字。滑动窗口每次只向右移动一位。
#
# 返回滑动窗口中的最大值。
#
#
#
# 示例 1：
#
#
# 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
# 输出：[3,3,5,5,6,7]
# 解释：
# 滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# ⁠1 [3  -1  -3] 5  3  6  7       3
# ⁠1  3 [-1  -3  5] 3  6  7       5
# ⁠1  3  -1 [-3  5  3] 6  7       5
# ⁠1  3  -1  -3 [5  3  6] 7       6
# ⁠1  3  -1  -3  5 [3  6  7]      7
#
#
# 示例 2：
#
#
# 输入：nums = [1], k = 1
# 输出：[1]
#
#
# 示例 3：
#
#
# 输入：nums = [1,-1], k = 1
# 输出：[1,-1]
#
#
# 示例 4：
#
#
# 输入：nums = [9,11], k = 2
# 输出：[11]
#
#
# 示例 5：
#
#
# 输入：nums = [4,-2], k = 2
# 输出：[4]
#
#
#
# 提示：
#
#
# 1
# -10^4 
# 1
#
#
#

# @lc code=start
# 1. Solution1, 双端队列, Time: O(n), Space: O(k), Runtime: 56%
#   - 使用队列维护一个大小为 k 的滑动窗口，窗口中存 index
#   - 新进元素如果大于窗口中左边已有值，就把左边的值都弹出去；否则，放入队列中
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        # window 存 index, res 存 值
        window, res = [], []
        for i, num in enumerate(nums):
            if i >= k and i >= window[0] + k:
                window.pop(0)
            while window and nums[window[-1]] <= num:
                window.pop()
            window.append(i)
            if i >= k - 1:
                res.append(nums[window[0]])
        return res

# @lc code=end
