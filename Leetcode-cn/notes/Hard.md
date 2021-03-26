#### [25] K 个一组翻转链表
- https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 1. Solution1，遍历, Time: O(n), Space: O(1), Runtime: 100%
    - prev每次移动k个节点，tail先移动这组的末尾，和prev一起框定边界，再对这组倒序，再把首位重新连接
    1. 框定边界
    2. 切断该组，组内倒序
    3. 重新连接该组首尾


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


#### [480] 滑动窗口中位数
- https://leetcode-cn.com/problems/sliding-window-median/description/
- https://zxi.mytechroad.com/blog/difficulty/hard/leetcode-480-sliding-window-median/
1. Solution1, 插入排序改进BF，`Time: O((n – k + 1) * k), Space: O(k), Runtime: 67%`
   - `BF: O((n - k + 1) * klogk)` 会 **TLE**，因为每次加入新元素都要重新 `sort(window)`，消耗 `O(nlogn)` 时间，而没有这个必要
   - 改进思路是构造一个 `window`，实现 `insert()` 和 `remove()` 方法，`remove` 时先 `binarySearch` 到 `num`，再把后面的数字往前面补；`insert` 先`binarySearch` 到 `num`，再把前面的往后面补，空出位置，插入 `num`
   - 将每个 `window` 的处理时间优化到 `O(k)`，从而将整体时间复杂度降低一个量级, 到 `O((n - k + 1) * k)`