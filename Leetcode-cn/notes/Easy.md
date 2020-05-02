**1. Two Sum 两数之和
Easy**
- https://leetcode-cn.com/problems/two-sum/
- HashSet 解决注意小index在前


**7 Reverse Int
Easy**
- https://leetcode-cn.com/problems/reverse-integer/


**9 isPalindrome
Easy**
- https://leetcode-cn.com/problems/palindrome-number/


**14 longestCommonPrefix
Easy**
- https://leetcode-cn.com/problems/longest-common-prefix
1. 暴力，注意边界条件，先纵向再横向，逻辑要写清晰
2. 从后往前裁剪至符合，若不符合则裁剪至空


**20 Valid Parentheses，判断对等括号
Easy**
- https://leetcode-cn.com/problems/valid-parentheses/
- 根据 now 指向来 push 对应的括号，判断 pop 是否==对应


**26. Remove Duplicated from Sorted Array 删除排序数组中的重复项
Easy**
- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
- 只需要前i个，后面不用管
- return的count要+1，因为根据count来print数组


**27. Remove Element 移除元素
Easy**
- https://leetcode-cn.com/problems/remove-element
- 循环中不动即跳过


**[28] 实现 strStr()
Easy**
- https://leetcode-cn.com/problems/implement-strstr/description/


**35. Search Insert Position 搜索插入位置
Easy**
- https://leetcode-cn.com/problems/search-insert-position
- once < or = 则返回，为插入位置
- 搜索不到返回 nums.length 即插入最大值位置
- 太巧妙了！


**[38] Count and Say 外观数列
Easy**
- https://leetcode-cn.com/problems/count-and-say/description/
- 这题挺有意思


**53. Maximum Subarray
Easy**
- https://leetcode-cn.com/problems/maximum-subarray
- 暴力, O(n^2). **（不正确）**
- DP 动态规划（初始状态 + 状态转移公式）


**[58] 最后一个单词的长度
Easy**
- https://leetcode-cn.com/problems/length-of-last-word/description/


**66 Plus One
Easy**
- https://leetcode-cn.com/problems/plus-one/
- 判断是否进位


**[67] 二进制求和
Easy**
- https://leetcode-cn.com/problems/add-binary/description/
- 当前位 = sum % 2，进位 = sum / 2，if (进位 != 0) { append 进位 }


**[70] 爬楼梯
Easy**
- https://leetcode-cn.com/problems/climbing-stairs/description/
- 斐波那契数列找规律 ( res[i] = res[i-1]  + res[i-2] )
- **直接递归 ( return res[i-1] + res[i-2] ) 会超时**


**[83] 删除排序链表中的重复元素
Easy**
- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
- 删除重复节点后若 last 后移一位则会移到已删除的节点上，所以若重复 last 不动，不重复 last 后移一位


**[88] Merge Sorted Array
Easy**
- https://leetcode-cn.com/problems/merge-sorted-array/
- 排序好的数组，从后往前插入
- 比大小，大于从尾插，小于则swap
- 剩下直接插在头


**[100] 相同的树
Easy**
- https://leetcode-cn.com/problems/same-tree/description/
- 递归写法


**[101] 对称二叉树
Easy**
- https://leetcode-cn.com/problems/symmetric-tree/description/
- 从外往内包裹着比较
- 不要想太复杂


**[104] 二叉树的最大深度
Easy**
- https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/


**[107] 二叉树的层次遍历 II
Easy**
- https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
- 自顶向下存储，```reverse```后输出
- 完全遍历下一层：
```java
for ( TreeNode node : next_level ){
    vals.add( node.val );
}
```


**[108] 将有序数组转换为二叉搜索树
Easy**
- https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
- 二叉平衡树定义：```left.val < root.val && right.val > root.val```
- 取中间值```(mid = (start + end) / 2)```为root，左边`nums[start, mid - 1]`为左子树，右边`nums[mid + 1, end]`为右子树


**[110] 平衡二叉树
Easy**
- https://leetcode-cn.com/problems/balanced-binary-tree/description/
- 中间使用`-1`判断`false`，若`-1`则再次直接`return -1`


**[111] 二叉树的最小深度
Easy**
- https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
- 与 [[104] 二叉树的最大深度 ](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/) 做法类似，https://github.com/joey66666/Algorithms/issues/2#issuecomment-612340952
- 注意区分`root.left != null, root.right != null` 的情况，分开讨论


**[112] 路径总和
easy**
- https://leetcode-cn.com/problems/path-sum/description/
- 到叶子节点判断 `sum - root.val == 0`，没到叶子节点 `sum - root.val`继续递归 `root.left`或`root.right`


**[118] 杨辉三角
Easy**
- https://leetcode-cn.com/problems/pascals-triangle/
- [i][0] = 1
- [i][j] = [i-1][j-1] + [i-1][j]


**[119] 杨辉三角2
Easy**
- https://leetcode-cn.com/problems/pascals-triangle-ii/
- 设置中间变量保存上一层，与当前层迭代更新


**[121] best-time-to-buy-and-sell-stock，买卖股票的最佳时机
Easy**
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
- 典型DP，把握初始状态（ prices[0] ）和状态转移条件 ( now < start & now_profit > last_profit )



**[122] best-time-to-buy-and-sell-stock-ii，买卖股票的最佳时机 II
Easy**
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
- **包含当天买入，当天卖出的情况**
- 贪心体现在追求当下利润最大 ( now_profit > 0 )


**[125] 验证回文串
Easy**
- https://leetcode-cn.com/problems/valid-palindrome/description/


**[136] SingleNumber
Easy**
- https://leetcode-cn.com/problems/single-number/
1. Solution1 HashSet, if ( ! s.add ( x ))  s.remove( x );
2. Solution2 异或运用尤其巧妙，0 ^ int = int，int ^ int = 0;


**[141] 环形链表
Easy**
- https://leetcode-cn.com/problems/linked-list-cycle/description/
- 快慢指针，若存在环则指针总会相遇，以`fast != null && fast.next != null`为循环条件


**[155] 最小栈
Easy**
- https://leetcode-cn.com/problems/min-stack/description/
- 用另一个栈保存最小元素，栈顶最小（不是最小push栈顶本身，保证两个栈大小相等）


**[160] 相交链表
Easy**
- https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
- 计算长度差，长的先走到两边平齐，再一起走，相交则return，走到头不相交return null


**[167] 两数之和 II - 输入有序数组
Easy**
- https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
- 头尾指针，头尾和 > target, 尾指针左移；头尾和 < target, 头指针右移
- Time: O(n)


**[202] Happy Number
Easy**
- https://leetcode-cn.com/problems/happy-number


**[206] Reverse Linked List
Easy**
- https://leetcode.com/problems/reverse-linked-list/


**[278] 第一个错误的版本
Easy**
- https://leetcode-cn.com/problems/first-bad-version/description/
- 简单二分，注意循环条件


**[283]  Move Zeros，0元素移到最后，其他不变
Easy**
- https://leetcode-cn.com/problems/move-zeroes
1. S1，快慢双指针遍历
2. S2，单指针，非0往前移，统计0个数n；后n个置0


**[543] 二叉树的直径
Easy**
- https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
- **depth = Math.max( depth, left_depth + right_depth )**
- **向上一层 return 1 + Math.max( left_depth, right_depth )**


**[771] 宝石与石头
Easy**
- https://leetcode-cn.com/problems/jewels-and-stones/description/
- 简单`HashMap`


**[844] 比较含退格的字符串
Easy**
- https://leetcode-cn.com/problems/backspace-string-compare/description/
- 栈比字符串性能高挺多


**[876] 链表的中间结点
Easy**
- https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
- 快慢指针，注意 if( p.next! = null )


**[1046] 最后一块石头的重量
Easy**
- https://leetcode-cn.com/problems/last-stone-weight/description/