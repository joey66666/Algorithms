#
# @lc app=leetcode.cn id=1011 lang=python3
#
# [1011] 在 D 天内送达包裹的能力
#
# https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/description/
#
# algorithms
# Medium (56.79%)
# Likes:    313
# Dislikes: 0
# Total Accepted:    44.7K
# Total Submissions: 71.5K
# Testcase Example:  '[1,2,3,4,5,6,7,8,9,10]\n5'
#
# 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
#
# 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
#
# 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
#
#
#
# 示例 1：
#
# 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
# 输出：15
# 解释：
# 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
# 第 1 天：1, 2, 3, 4, 5
# 第 2 天：6, 7
# 第 3 天：8
# 第 4 天：9
# 第 5 天：10
#
# 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9),
# (10) 是不允许的。
#
#
# 示例 2：
#
# 输入：weights = [3,2,2,4,1,4], D = 3
# 输出：6
# 解释：
# 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
# 第 1 天：3, 2
# 第 2 天：2, 4
# 第 3 天：1, 4
#
#
# 示例 3：
#
# 输入：weights = [1,2,3,1,1], D = 4
# 输出：3
# 解释：
# 第 1 天：1
# 第 2 天：2
# 第 3 天：3
# 第 4 天：1, 1
#
#
#
#
# 提示：
#
#
# 1 <= D <= weights.length <= 50000
# 1 <= weights[i] <= 500
#
#
#

# @lc code=start
# 1. Solution1, 二分查找, Time: O(nlogn), Space: O(1), Runtime: 72%
#   - 船舶容量的最小值是 weights 里最大的，不然装不下
#   - 船舶容量的最大值是 weights 里全部加起来，这样一次就能运完
#   - 在最大值和最小值之间双向逼近，每一次都使用当前的容量在 weights 上计算运输总天数 days，如果 days > D, 即当前的容量不能满足 D，需要增加；否则说明容量还有压缩的空间，继续压缩。这里使用二分查找，时间复杂度最好
#       - 每一轮计算天数：count += weights[i]，如果 count > capacity, 说明 weights[i] 应该放到下一天，即 count = weights[i], days += 1

class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        left = max(weights)
        right = sum(weights)
        while left < right:
            mid = (left + right) // 2
            res = self.calculateDays(weights, mid)
            # 需要的天数大于预期，即当下的 capacity 无法满足需求，需要加大
            if res > D:
                left = mid + 1
            else:
                right = mid
        return left

    def calculateDays(self, weights: List[int], capacity: int) -> int:
        count = 0
        days = 1
        for weight in weights:
            count += weight
            if count > capacity:
                count = weight
                days += 1
        return days

# @lc code=end
