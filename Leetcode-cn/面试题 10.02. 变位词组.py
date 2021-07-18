# 面试题 10.02. 变位词组
# 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

# 注意：本题相对原题稍作修改

# 示例:

# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
#   ["ate","eat","tea"],
#   ["nat","tan"],
#   ["bat"]
# ]
# 说明：

# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
# 1. Solution1, Hash, Time: O(n), Space: O(n), Runtime: 98%
#   - 使用排序后的str作为key
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict()
        for str in strs:
            key = "".join(sorted(str))
            if key not in dic:
                dic[key] = [str]
            else:
                t = dic[key]
                t.append(str)
                dic[key] = t
        res = []
        for v in dic.values():
            res.append(v)
        return res