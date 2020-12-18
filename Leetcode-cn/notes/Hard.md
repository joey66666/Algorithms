- [[145] 二叉树的后序遍历](#145-二叉树的后序遍历)
##### [145] 二叉树的后序遍历
- https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
- https://juejin.im/post/59e3fde451882578c20858a5
- 递归
- 非递归，栈实现。
- 先`stack.push()`进入最左子结点，到最左子结点再`stack.peek()`，判断该结点.right是否为空或已访问过（使用一个`TreeNode last`），若访问过则放入`res`，再`stakck.pop()`，再更新`last`