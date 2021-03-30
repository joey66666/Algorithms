#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#
# https://leetcode-cn.com/problems/search-a-2d-matrix/description/
#
# algorithms
# Medium (41.18%)
# Likes:    401
# Dislikes: 0
# Total Accepted:    123.9K
# Total Submissions: 281.6K
# Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
#
# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
#
#
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。
#
#
#
#
# 示例 1：
#
#
# 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
# 输出：true
#
#
# 示例 2：
#
#
# 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
# 输出：false
#
#
#
#
# 提示：
#
#
# m == matrix.length
# n == matrix[i].length
# 1
# -10^4
#
#
#

# @lc code=start


# Solution1, 两次查找，先确定是否在这行左右区间，再从左往右扫描, Time: O(m + n), Space: O(1), Runtime: 83%
#    - 从右上往左下角找，更显著, Runtime: 83%
# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         rows, cols = len(matrix), len(matrix[0])
#         if rows == 0 or cols == 0:
#             return False
#         for i in range(rows):
#             left, right = 0, cols - 1
#             if (target >= matrix[i][left]) and (target <= matrix[i][right]):
#                 while right >= left:
#                     if target == matrix[i][right]:
#                         return True
#                     else:
#                         right -= 1
#         return False

# Solution2, 一次二分，用二分查找改进Solution1中单向遍历, Time: O(n + logM), Space: O(1), Runtime: 94%
# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         rows, cols = len(matrix), len(matrix[0])
#         if rows == 0 or cols == 0:
#             return False
#         for i in range(rows):
#             if (target >= matrix[i][0]) and (target <= matrix[i][-1]):
#                 left, right = 0, cols - 1
#                 while left <= right:
#                     mid = int(left + (right - left) / 2)
#                     if target < matrix[i][mid]:
#                         right = mid - 1
#                     elif target > matrix[i][mid]:
#                         left = mid + 1
#                     else:
#                         return True
#                 return False
#         return False

# Solution3, 两次二分，用二分查找改进Solution2中第一次单向遍历, Time: O(logN + logM), Space: O(1), Runtime: 94%
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, cols = len(matrix), len(matrix[0])
        if rows == 0 or cols == 0:
            return False
        up, down, middle = -1, rows - 1, 0
        while up < down:
            middle = int(up + (down - up + 1) / 2)
            if target >= matrix[middle][0]:
                up = middle
            else:
                down = middle - 1

        if (target >= matrix[up][0]) and (target <= matrix[up][-1]):
            left, right = 0, cols - 1
            while left <= right:
                mid = int(left + (right - left) / 2)
                if target < matrix[up][mid]:
                    right = mid - 1
                elif target > matrix[up][mid]:
                    left = mid + 1
                else:
                    return True
            return False
        return False
# @lc code=end
