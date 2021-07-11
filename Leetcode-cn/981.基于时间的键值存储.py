#
# @lc app=leetcode.cn id=981 lang=python3
#
# [981] 基于时间的键值存储
#
# https://leetcode-cn.com/problems/time-based-key-value-store/description/
#
# algorithms
# Medium (43.18%)
# Likes:    98
# Dislikes: 0
# Total Accepted:    8.3K
# Total Submissions: 16.3K
# Testcase Example:  '["TimeMap","set","get","get","set","get","get"]\n' +
# '[[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]'
#
# 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
# 
# 1. set(string key, string value, int timestamp)
# 
# 
# 存储键 key、值 value，以及给定的时间戳 timestamp。
# 
# kv
# 2. get(string key, int timestamp)
# 
# 
# 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <=
# timestamp。
# 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
# 如果没有值，则返回空字符串（""）。
# 
# 
# 
# 
# 示例 1：
# 
# 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs =
# [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
# 输出：[null,null,"bar","bar",null,"bar2","bar2"]
# 解释：  
# TimeMap kv;   
# kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1   
# kv.get("foo", 1);  // 输出 "bar"   
# kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1
# 处（即 "bar"）   
# kv.set("foo", "bar2", 4);   
# kv.get("foo", 4); // 输出 "bar2"   
# kv.get("foo", 5); // 输出 "bar2"   
# 
# 
# 
# 示例 2：
# 
# 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs =
# [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
# 输出：[null,null,null,"","high","high","low","low"]
# 
# 
# 
# 
# 提示：
# 
# 
# 所有的键/值字符串都是小写的。
# 所有的键/值字符串长度都在 [1, 100] 范围内。
# 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
# 1 <= timestamp <= 10^7
# TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
# 
# 
#

# @lc code=start
class TimeMap:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.dic.keys():
            self.dic[key] = [[value, timestamp]]
        else:
            # 最后一个元素比将插进来的元素小，尾插入
            if self.dic[key][-1][1] < timestamp:
                t = self.dic[key]
                t.append([value, timestamp])
                self.dic[key] = t
            # 第一个元素比将插进来的元素大，头插入
            elif self.dic[key][0][1] > timestamp:
                t = self.dic[key]
                t.insert(0, [value, timestamp])
                self.dic[key] = t

    def get(self, key: str, timestamp: int) -> str:
        # key存在
        res = ""
        if key in self.dic.keys():
            value = self.dic[key]
            start, end = 0, len(value) - 1
            while start <= end:
                mid = start + (end - start) // 2
                if value[mid][1] <= timestamp:
                    res = value[mid][0]
                    start = mid + 1
                else:
                    end = mid - 1
        return res
# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
# @lc code=end

