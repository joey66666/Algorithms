#
# @lc app=leetcode.cn id=692 lang=python3
#
# [692] 前K个高频单词
#
# https://leetcode-cn.com/problems/top-k-frequent-words/description/
#
# algorithms
# Medium (52.22%)
# Likes:    332
# Dislikes: 0
# Total Accepted:    54.6K
# Total Submissions: 94K
# Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
#
# 给一非空的单词列表，返回前 k 个出现次数最多的单词。
#
# 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
#
# 示例 1：
#
#
# 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
# 输出: ["i", "love"]
# 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
# ⁠   注意，按字母顺序 "i" 在 "love" 之前。
#
#
#
#
# 示例 2：
#
#
# 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"],
# k = 4
# 输出: ["the", "is", "sunny", "day"]
# 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
# ⁠   出现次数依次为 4, 3, 2 和 1 次。
#
#
#
#
# 注意：
#
#
# 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
# 输入的单词均由小写字母组成。
#
#
#
#
# 扩展练习：
#
#
# 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
#
#
#

# @lc code=start
# 1. Solution1, HashMap + Sort, Time: O(n + nlogn), Space: O(n), Runtime: 44%
#   - HashMap<k: word, v: frequency>, 再两次排序，先按词字母，再按出现次数排序
# class Solution:
#     def topKFrequent(self, words: List[str], k: int) -> List[str]:
#         dic = {}
#         for word in words:
#             if not word in dic:
#                 dic[word] = 1
#             else:
#                 dic[word] = dic[word] + 1
#         l = sorted(dic.items(), key=lambda x: x[0])
#         l = sorted(l, key=lambda x: x[1], reverse=True)
#         res = []
#         for i in range(k):
#             res.append(l[i][0])
#         return res

# 2. Solution2, Solution1的高级实现, Runtime: 85%
#   - 先统计每个单词出现的次数，再对字典进行双关键字排序
#       - sorted 方法默认正序排列
#       - 第一个参数 -hash[x] 即单词出现次数的相反数, 相当于词频的倒序排列
#       - 当词频相同时，用第二个参数 word 进行排序，即字母正序排列
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        # 记录每个单词出现的次数
        hash = collections.Counter(words)
        res = sorted(hash, key=lambda x: (-hash[x], x))
        return res[:k]

# @lc code=end
