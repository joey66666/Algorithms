#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#
# https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
#
# algorithms
# Medium (71.35%)
# Likes:    713
# Dislikes: 0
# Total Accepted:    106.9K
# Total Submissions: 149.8K
# Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
#   '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
#
# Trie（发音类似 "try"）或者说 前缀树
# 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
#
# 请你实现 Trie 类：
#
#
# Trie() 初始化前缀树对象。
# void insert(String word) 向前缀树中插入字符串 word 。
# boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
# 。
# boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true
# ；否则，返回 false 。
#
#
#
#
# 示例：
#
#
# 输入
# ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
# [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
# 输出
# [null, null, true, false, true, null, true]
#
# 解释
# Trie trie = new Trie();
# trie.insert("apple");
# trie.search("apple");   // 返回 True
# trie.search("app");     // 返回 False
# trie.startsWith("app"); // 返回 True
# trie.insert("app");
# trie.search("app");     // 返回 True
#
#
#
#
# 提示：
#
#
# 1
# word 和 prefix 仅由小写英文字母组成
# insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
#
#
#

# @lc code=start
# 1. Solution1, 前缀树, Time: O(字符串长度)，Space: O(字符串长度)，Runtime: 18%
#    - 每一层都是字符数组[26]，每个 cell 表示指向下一个字符
#    - 设置一个 bool 标识当前字符是否是末尾字符
# class Trie:
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.children = [None] * 26
#         self.isEnd = False

#     def insert(self, word: str) -> None:
#         """
#         Inserts a word into the trie.
#         """
#         node = self
#         for ch in word:
#             ch = ord(ch) - ord('a')
#             if not node.children[ch]:
#                 node.children[ch] = Trie()
#             node = node.children[ch]
#         node.isEnd = True

#     def searchPrefix(self, prefix: str) -> "Trie":
#         node = self
#         for ch in prefix:
#             ch = ord(ch) - ord('a')
#             if not node.children[ch]:
#                 return None
#             node = node.children[ch]
#         return node

#     def search(self, word: str) -> bool:
#         """
#         Returns if the word is in the trie.
#         """
#         node = self.searchPrefix(word)
#         return node is not None and node.isEnd is True


#     def startsWith(self, prefix: str) -> bool:
#         """
#         Returns if there is any word in the trie that starts with the given prefix.
#         """
#         return self.searchPrefix(prefix) is not None

# 2. Solution2, 前缀树, Time: O(字符串长度)，Space: O(字符串长度)，Runtime: 15%
#    - 每一层用 dict 实现
class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.children = {}
        self.isEnd = False

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self
        for ch in word:
            # ch = ord(ch) - ord('a')
            if ch not in node.children:
                node.children[ch] = Trie()
            node = node.children[ch]
        node.isEnd = True

    def searchPrefix(self, prefix: str) -> "Trie":
        node = self
        for ch in prefix:
            if ch not in node.children:
                return None
            node = node.children[ch]
        return node

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.searchPrefix(word)
        return node is not None and node.isEnd is True

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        return self.searchPrefix(prefix) is not None
    
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end
