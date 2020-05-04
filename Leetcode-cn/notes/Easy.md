**[1] Two Sum 两数之和
Easy**
- https://leetcode-cn.com/problems/two-sum/
- HashSet 解决注意小index在前


**[7] Reverse Int
Easy**
- https://leetcode-cn.com/problems/reverse-integer/


**[9] isPalindrome
Easy**
- https://leetcode-cn.com/problems/palindrome-number/


**[14] longestCommonPrefix
Easy**
- https://leetcode-cn.com/problems/longest-common-prefix
1. 暴力，注意边界条件，先纵向再横向，逻辑要写清晰
2. 从后往前裁剪至符合，若不符合则裁剪至空


**[20] Valid Parentheses，判断对等括号
Easy**
- https://leetcode-cn.com/problems/valid-parentheses/
- 根据 now 指向来 push 对应的括号，判断 pop 是否==对应


**[26] Remove Duplicated from Sorted Array 删除排序数组中的重复项
Easy**
- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
- 只需要前i个，后面不用管
- return的count要+1，因为根据count来print数组


**[27] Remove Element 移除元素
Easy**
- https://leetcode-cn.com/problems/remove-element
- 循环中不动即跳过


**[28] 实现 strStr()
Easy**
- https://leetcode-cn.com/problems/implement-strstr/description/


**[35] Search Insert Position 搜索插入位置
Easy**
- https://leetcode-cn.com/problems/search-insert-position
- once < or = 则返回，为插入位置
- 搜索不到返回 nums.length 即插入最大值位置
- 太巧妙了！


**[38] Count and Say 外观数列
Easy**
- https://leetcode-cn.com/problems/count-and-say/description/
- 这题挺有意思


**[53] Maximum Subarray
Easy**
- https://leetcode-cn.com/problems/maximum-subarray
- 暴力, O(n^2). **（不正确）**
- DP 动态规划（初始状态 + 状态转移公式）


**[58] 最后一个单词的长度
Easy**
- https://leetcode-cn.com/problems/length-of-last-word/description/


**[66] Plus One
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


**[168] Excel表列名称
Easy**
- https://leetcode-cn.com/problems/excel-sheet-column-title/description/
- 思路：取余到底，转换成字母，再反向输出
- n直接除以26会出错，如`52/26=2···0`，但在Excel用实际`AZ`表示，所以先`n -= 1`。深层原因即计算机以0为第一位，Excel以1为第一位
- `StringBuilder.append()`比`String += `速度快很多


**[169] 多数元素
Easy**
- https://leetcode-cn.com/problems/majority-element/description/
1. Solution1: HashMap
   - HashMap，过程中 `if hm.get(nums[i]) > nums.length /2`则return
   - Runtime: 38%
   - Time: O(n), Space: O(n)
2. Solution2: 摩尔投票法
   - 假设 nums[0] 为最多元素，遍历，相同 + 1，不同 - 1
   - 若归零，则前面其他和本身数量相等，对冲抵消，指针当下指向另一个数，换成另一个数，对后面继续遍历比较
   - Runtime: 99%
   -  Time: O(n), Space: O(1)


**[171] Excel表列序号
Easy**
- https://leetcode-cn.com/problems/excel-sheet-column-number/description/
- [[168] Excel表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title/description/)的反面题
- 等同 26 -> 10 进制转换


**[172] 阶乘后的零
Easy**
- https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
- 0 的个数，即 10 ^ 个数
- 10 = 5 * 2
- 2 的个数易得到，所以10的个数 = 5的个数
- 如15！中有15，10，5，结果为3


**[189] 旋转数组
Easy**
- https://leetcode-cn.com/problems/rotate-array/description/
- Solution2, 三次翻转，第一次数组倒序，第二次以k为分界线前后子数组分别倒序
- 比如12345经过翻转就变成了54321，这样已经做到了把前面的数字放到后面去，但是还没有完全达到要求，只需要把12放在后面去，目标数组就是34512。与54321对比发现我们就只需要在把分界线前后数组再进行翻转一次就可得到目标数组了
- Time:O(n) //O(2n)


**[190] 颠倒二进制位
Easy**
- https://leetcode-cn.com/problems/reverse-bits/description/
- 思路：把n最右边一位取出来，res左移一位后加到res上，循环移动32次
```
res = res * 2 + n % 2
n /= 2
```
- 以上运算，有符号数下不能用，因为使用补码表示
- 应使用位操作实现：`n & 1`来取最后一位
```
res = (res << 1) | (n & 1)
n >>= 1
```
- Time: O(logN)


**[191] 位1的个数
Easy**
- https://leetcode-cn.com/problems/number-of-1-bits/description/
- 取最低位数，为1相加


**[198] 打家劫舍
Easy**
- https://leetcode-cn.com/problems/house-robber/description/
- 维护一个一位数组 dp，其中 dp[i] 表示 [0, i] 区间可以抢夺的最大值，对当前i来说，有抢和不抢两种互斥的选择。
- 不抢：dp[i-1]（等价于去掉 nums[i] 只抢 [0, i-1] 区间最大值）
- 抢：dp[i-2] + nums[i]（等价于去掉 nums[i-1]）
- 比如 nums为{3, 2, 1, 5}，首先 dp[0]=3 , dp[1]，由于3比2大，所以抢第一个房子的3，当前房子的2不抢，则dp[1]=3。dp[2]由于不能抢相邻的，所以可以用再前面的一个的 dp 值加上当前的房间值，和当前房间的前面一个 dp 值比较，取较大值当做当前 dp 值
- 状态转移方程 dp[i] = max(num[i] + dp[i - 2], dp[i - 1]),
- 需要初始化 dp[0] 和 dp[1]，dp[0] 为 num[0]，dp[1] 为 max(num[0], num[1])


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


**[383] 赎金信
Easy**
- https://leetcode-cn.com/problems/ransom-note/description/
- `int[26]`数组遍历`magzine`统计26个字母使用次数，再遍历`ransomNote`, `if 对应字母 <= 0`则return


**[476] 数字的补数
Easy**
- https://leetcode-cn.com/problems/number-complement/description/
- 直接 ~ 按位取反，前缀的0也会被取反。
- 所以用 ^ 异或，直接`^1`前面的位数也会异或，用与`num`相同位数的数异或
- 如：101 ^ 111 = 010。怎么得到111？考虑111 + 1 = 1000，而1000又是 最小的 大于101的 只有一位是1 的二进制数。
- 解决方法：
   1. 找到最小的大于原数字的二进制值仅有一位为1的数；
   2. 将此数减1；
   3. 与原数字按位求异或。
- `Integer.highestOneBit(num)`：拿到num最高位，后面补0，如 101 返回 100 

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