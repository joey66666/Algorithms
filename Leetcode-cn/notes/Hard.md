# Leetcode Hard

- [[25] K 个一组翻转链表](#25-k-个一组翻转链表)
- [[87] 扰乱字符串](#87-扰乱字符串)
- [[135] 分发糖果](#135-分发糖果)
- [[145] 二叉树的后序遍历](#145-二叉树的后序遍历)
- [[239] 滑动窗口最大值](#239-滑动窗口最大值)
- [[363] 矩形区域不超过 K 的最大数值和](#363-矩形区域不超过-k-的最大数值和)
- [[480] 滑动窗口中位数](#480-滑动窗口中位数)
- [[1269] 停在原地的方案数](#1269-停在原地的方案数)


#### [25] K 个一组翻转链表
- https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 1. Solution1，遍历, Time: O(n), Space: O(1), Runtime: 100%
    - prev每次移动k个节点，tail先移动这组的末尾，和prev一起框定边界，再对这组倒序，再把首位重新连接
    1. 框定边界
    2. 切断该组，组内倒序
    3. 重新连接该组首尾


#### [87] 扰乱字符串
- https://leetcode-cn.com/problems/scramble-string/description/
- https://leetcode-cn.com/problems/scramble-string/solution/rao-luan-zi-fu-chuan-by-leetcode-solutio-8r9t/
1. Solution1, 递归 + DP, Time: O(n^4), Space: O(n^3), Runtime: 43%


#### [135] 分发糖果
- https://leetcode-cn.com/problems/candy/description/
1. Solution1: 贪心，正反遍历
   - 首先每个人派发一个
   - 正向遍历，如果后一个`rating`高，后一个加一个糖果
   - 反向遍历，如果后一个`rating`高，后一个糖果数为`Math.max(现有糖果，前一个糖果数 + 1)`


 #### [145] 二叉树的后序遍历
- https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
- https://juejin.im/post/59e3fde451882578c20858a5
- 递归
- 非递归，栈实现。
- 先`stack.push()`进入最左子结点，到最左子结点再`stack.peek()`，判断该结点.right是否为空或已访问过（使用一个`TreeNode last`），若访问过则放入`res`，再`stakck.pop()`，再更新`last`


#### [239] 滑动窗口最大值
- https://leetcode-cn.com/problems/sliding-window-maximum/description/
1. Solution1, 双端队列, Time: O(n), Space: O(k), Runtime: 56%
   - 使用队列维护一个大小为 k 的滑动窗口，窗口中存 index
   - 新进元素如果大于窗口中左边已有值，就把左边的值都弹出去；否则，放入队列中


#### [363] 矩形区域不超过 K 的最大数值和
- https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
- https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/ju-xing-qu-yu-bu-chao-guo-k-de-zui-da-sh-70q2/
1. Solution1, 有序集合, Time: O(m^2nlogn), Spac: O(n), Runtime:
   - 其实就是暴力，在每一行的上下边界内，对每一列进行计算方格满足条件的值，进而遍历矩阵内每一个方格
   - 将：寻找矩阵内部矩形区域的不超过 k 的最大数值和 的问题 -> 转化成：计算每组最大区间和, 找到不大于 k 的区间和


#### [480] 滑动窗口中位数
- https://leetcode-cn.com/problems/sliding-window-median/description/
- https://zxi.mytechroad.com/blog/difficulty/hard/leetcode-480-sliding-window-median/
1. Solution1, 插入排序改进BF，`Time: O((n – k + 1) * k), Space: O(k), Runtime: 67%`
   - `BF: O((n - k + 1) * klogk)` 会 **TLE**，因为每次加入新元素都要重新 `sort(window)`，消耗 `O(nlogn)` 时间，而没有这个必要
   - 改进思路是构造一个 `window`，实现 `insert()` 和 `remove()` 方法，`remove` 时先 `binarySearch` 到 `num`，再把后面的数字往前面补；`insert` 先`binarySearch` 到 `num`，再把前面的往后面补，空出位置，插入 `num`
   - 将每个 `window` 的处理时间优化到 `O(k)`，从而将整体时间复杂度降低一个量级, 到 `O((n - k + 1) * k)`


#### [1269] 停在原地的方案数
- https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/
1. Solution1, DP, Time: O(m * n), Space: O(m * n), Runtime: 50%
  - 定义: `dp[i][j]dp[i][j]` 代表 step 为 i, arr 数组下标为 j 时, 方案的个数
  - 状态转移方程: `dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j+1]dp[i][j]=dp[i−1][j]+dp[i−1][j−1]+dp[i−1][j+1]`
     - 到达 j 原地不动的话, `dp[i][j] = dp[i-1][j]dp[i][j]=dp[i−1][j]`, 就是把 step = i-1 的方案数拿过来
     - 到达 j 是从 j-1, 从 j 左边过来的, 移动一位可以到达 j, 所以把 `dp[i-1][j-1]dp[i−1][j−1]` 的方案数加上
     - 到达 j 是从 j+1, 从 j 右边过来的, 移动一位可以到达 j, 所以把 `dp[i-1][j+1]dp[i−1][j+1]` 的方案数加上
     - 题目允许不移动或者左右移动一位, 所以可以把以上的结果都加起来
 - 初始状态: `dp[0][0] = 1，在[0][0]` 位置上只有一种方案是不动
 - 注意下标边界
     - 当 `j = 0` 时，`dp[i−1][j−1] = 0`
     - 当 `j = min(arrLen−1, steps)` 时，`dp[i−1][j+1] = 0`