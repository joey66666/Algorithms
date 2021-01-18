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