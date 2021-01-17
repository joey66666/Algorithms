- [[3] 无重复字符的最长子串](#3-无重复字符的最长子串)
- [[8] 字符串转换整数 (atoi)](#8-字符串转换整数-atoi)
- [[15] 三数之和](#15-三数之和)
- [[19] 删除链表的倒数第N个节点](#19-删除链表的倒数第n个节点)
- [[31] 下一个排列](#31-下一个排列)
- [[33] 搜索旋转排序数组](#33-搜索旋转排序数组)
- [[36] 有效的数独](#36-有效的数独)
- [[46] 全排列](#46-全排列)
- [[48] 旋转图像](#48-旋转图像)
- [[49]  Group Anagrams，字母异位词分组](#49--group-anagrams字母异位词分组)
- [[55] 跳跃游戏](#55-跳跃游戏)
- [[61] 旋转链表](#61-旋转链表)
- [[62] 不同路径](#62-不同路径)
- [[64] 最小路径和](#64-最小路径和)
- [[78] 子集](#78-子集)
- [[86] 分隔链表](#86-分隔链表)
- [[92] Reverse Linked List II](#92-reverse-linked-list-ii)
- [[93] 复原IP地址](#93-复原ip地址)
- [[94] 二叉树的中序遍历](#94-二叉树的中序遍历)
- [[116] 填充每个节点的下一个右侧节点指针](#116-填充每个节点的下一个右侧节点指针)
- [[124] 二叉树中的最大路径和](#124-二叉树中的最大路径和)
- [[127] 单词接龙](#127-单词接龙)
- [[144] 二叉树的前序遍历](#144-二叉树的前序遍历)
- [[146] LRU缓存机制](#146-lru缓存机制)
- [[179] Largest Number](#179-largest-number)
- [[200] 岛屿数量](#200-岛屿数量)
- [[201] 数字范围按位与](#201-数字范围按位与)
- [[207] 课程表](#207-课程表)
- [[215] 数组中的第K个最大元素](#215-数组中的第k个最大元素)
- [[221] 最大正方形](#221-最大正方形)
- [[238] 除自身以外数组的乘积](#238-除自身以外数组的乘积)
- [[376] 摆动序列](#376-摆动序列)
- [[402] 移掉K位数字](#402-移掉k位数字)
- [[495] Teemo Attacking](#495-teemo-attacking)
- [[503] 下一个更大元素 II](#503-下一个更大元素-ii)
- [[525] 连续数组](#525-连续数组)
- [[540] 有序数组中的单一元素](#540-有序数组中的单一元素)
- [[560] 和为K的子数组](#560-和为k的子数组)
- [[649] Dota2 参议院](#649-dota2-参议院)
- [[659] 分割数组为连续子序列](#659-分割数组为连续子序列)
- [[678] 有效的括号字符串](#678-有效的括号字符串)
- [[714] 买卖股票的最佳时机含手续费](#714-买卖股票的最佳时机含手续费)
- [[738] 单调递增的数字](#738-单调递增的数字)
- [[861] 翻转矩阵后的得分](#861-翻转矩阵后的得分)
- [[901] 股票价格跨度](#901-股票价格跨度)
- [[907] 子数组的最小值之和](#907-子数组的最小值之和)
- [[1008] 先序遍历构造二叉树](#1008-先序遍历构造二叉树)
- [[1094] Car Pooling](#1094-car-pooling)
- [[1143] 最长公共子序列](#1143-最长公共子序列)
- [First Unique Numer](#first-unique-numer)
- [Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree](#check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree)

#### [3] 无重复字符的最长子串
- https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
1. Solution 1, 双循环遍历
   - Runtime：13%
2. Solution 2，双指针
   - [left, right]区间保存子串的左右区间，set里面是不重复的字符。
   - 使用while循环，如果right字符不在set中，put; 如果right在，就把left对应的字符remove。
   - Runtime: 48%
3. Solution 3, 保存前缀，一次遍历
   - 当right遍历若出现重复则这个区间不符合要求，移动left到right字符上次出现的下一位置（hm.get(s.charAt(right)) + 1）
   - left更新的时候需要保留最大（最右）的位置，即left不回头
   - e.g.: 对于abba，当right指向最后的a的时候，left指向的是字典中保留的有第一个位置的a，如果不对此进行判断的话，left会移动到第一个字符b（回头）


#### [8] 字符串转换整数 (atoi)
- https://leetcode-cn.com/problems/string-to-integer-atoi/description/
- 关键是处理各种corner case
- trim()处理空格
- 判断第一个符号后，后面再出现符号一律归类为!Character.isDigit()


#### [11] 盛最多水的容器
- https://leetcode-cn.com/problems/container-with-most-water/description/
1. Solution1: 双指针
   - 左右指针，中间距离为边长，左右指针指向高度中短的那个为容器的高度（木桶原理），盛水容量为 `边长 * 高`
   - 左右往中间逼近，移动`height`小的那个指针，因为逼近过程中边长一定`- 1`，所以尽可能减弱容器高度的短板，使盛水最多


#### [15] 三数之和
- https://leetcode-cn.com/problems/3sum/description/
- Solution：滑动窗口
  - 先排序，再找到第一个负数
  - 再对剩下的区间进行左右逼近，找到三数相加等于`0`的两数。
  - **注意过滤相同数字：往下走一位**


#### [16] 最接近的三数之和
- https://leetcode-cn.com/problems/3sum-closest/description/
1. Solution1: 排序后遍历，双指针逼近, Time: O(n^2), Runtime: 94%
   - 排序后从左到右，先遍历至`i`，再在`[i + 1, n - 1]`中寻找最靠近`target - nums[i]`的`left`和`right`
   - 优化：
     1. 遍历`i`时跳过重复
     2. `left`和`right`左右逼近时跳过重复
     3. 与`target`相等可直接`return`


#### [19] 删除链表的倒数第N个节点
- https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
- 双指针，`prev`和`cur`
- `cur`先走n步，若到尾部，则直接返回`head.next`
- 若`cur`不到尾部，则`prev`也和`cur`走，直到`cur`走到尾，`prev`走到待删除的前一个node


#### [31] 下一个排列
- https://leetcode-cn.com/problems/next-permutation/description/
1. 数组从后往前遍历，找到第一个降序数字
2. 与后面子序列中最小的大于它的值交换
3. 将子序列倒序
![image](https://user-images.githubusercontent.com/25404074/81701462-9d1db400-949c-11ea-9a4c-8d0b69c52351.png)


#### [33] 搜索旋转排序数组
- https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
- 做一次二分，分析应该搜索左边还是右边。每次二分有三种情况：
1. nums[mid] = target，则可以返回mid
2. nums[mid] < nums[right]，说明在[mid, right]区间是右边递增的区间，然后判断target是否在这个区间内
    - 如果nums[mid] < target <= nums[right]，说明target在右边区间里，则left = mid + 1;
    - 否则在左边区间里，搜索左边区间，right = mid - 1;
3. nums[mid] >= nums[right]，说明[elft, mid]区间是在左边的递增区间，然后判断target是否在这个左边区间里
    - 如果nums[left] <= target < nums[mid]，说明target在这个区间里，则使right = mid - 1;
    - 否则说明target在[mid, right]的不规则区间里，搜索右边区间，则使left = mid + 1;


#### [36] 有效的数独
- https://leetcode-cn.com/problems/valid-sudoku/description/
- 使用Set，关键在于校验cols, rows, cube里面数数字的唯一性
- Cube使用`基数 + 浮动数`的方式，`(/ 3) * 3`和`(% 3) * 3`作基数，`/ 3`和 `% 3`作浮动数


#### [46] 全排列
- https://leetcode-cn.com/problems/permutations/description/
- https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
- 回溯法框架：
  ```
  for 选择 in 选择列表:
    # 做选择
    将该选择从选择列表移除
    路径.add(选择)
    backtrack(路径, 选择列表)
    # 撤销选择
    路径.remove(选择)
    将该选择再加入选择列表
   ```


#### [48] 旋转图像
- https://leetcode-cn.com/problems/rotate-image/description/
- 二次调转
  1. 沿着左上右下对角线对调，选定左下角为：j = i + 1
  2. 沿着中轴纵线，两边对调


#### [49]  Group Anagrams，字母异位词分组
- https://leetcode-cn.com/problems/group-anagrams/description/
1. Solution1, Runtime: 95%: 
   - 每个单词 `sorted` 作为 `key`
     1. 实现1: `value`为`List<List<String>> res`每个`List<String>`的`index`
     2. 实现2: `value`为单独的`List<String>`
   - 判断`HashMap`是否存在`key`，不存在则新建`List<String>`，存在则取该`List`，添加当前单词
2. Solution2, Runtime: 11% : 
   - 每个单词每个字母映射成字母表 int 数组，组成唯一 String key (E.g. 1a1e1t) 作为 key 


#### [55] 跳跃游戏
- https://leetcode-cn.com/problems/jump-game/description/
- `dp`数组中 `dp[i]` 表示达到`i`位置时剩余的跳力，若到达某个位置时跳力为负了，说明无法到达该位置。
- 到达当前位置的剩余跳力跟上一个位置的剩余跳力（`dp` 值）和上一个位置新的跳力（`nums` 数组中的值）有关。所以当前位置的剩余跳力（`dp` 值）和当前位置新的跳力中的较大那个数决定了当前能到的最远距离，而下一个位置的剩余跳力（`dp` 值）就等于当前的这个较大值减去1，因为需要花一个跳力到达下一个位置
- 所以就有状态转移方程了：`dp[i] = max(dp[i - 1], nums[i - 1]) - 1`，如果当某一个时刻 `dp` 数组的值为负了，说明无法抵达当前位置，则直接返回 `false`，最后循环结束后直接返回 `true ` 即可


#### [61] 旋转链表
- https://leetcode-cn.com/problems/rotate-list/description/
- 双指针`prev, p`，常规移动题
- 注意 `k % length`，不然Time Limit


#### [62] 不同路径
- https://leetcode-cn.com/problems/unique-paths/description/
- DP数组，长宽+1，第一行第一列置0，dp[1][1] = 1
- dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，统计到该点的所有路径


#### [64] 最小路径和
- https://leetcode-cn.com/problems/minimum-path-dsum/description/
- 用`dp`数组记录当前行走到当前点的最小路径值，`dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1])`
- `dp`第一行只能从左走，第一列只能从上走，提前初始化


#### [75] 颜色分类
- https://leetcode-cn.com/problems/sort-colors/description/
- https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
1. Solution1: 单指针遍历两次, Time: O(n), Space: O(1), Runtime: 100%
   - 第一次把`0`交换到前面
   - 第二次把`1`继续上面的交换到前面
2. Solution2: 双指针遍历一次, Time: O(n), Space: O(1), Runtime: 100%
   - `p0, p1`分别表示`0`和`1`的位置，初始为`0`
   - 遇到`1`: 交换`nums[i], nums[p1]`,移动`p1`
   - 遇到`0`: 
     - 此情况下可能发生把前面的`1`交换到后面的情况，所以把`1`交换到后面后再交换到`p1`
     - 先交换`nums[i], nums[p0]`，
     - 如果`p0 < p1`, 再交换`nums[i], nums[p1]`, 
     - `p0`和`p1`均移动


#### [78] 子集
- https://leetcode-cn.com/problems/subsets/description/


#### [86] 分隔链表
- https://leetcode-cn.com/problems/partition-list/description/
- Solution1, in place
  1. 遍历到第一个大于`x`的Node `a`
  2. 再从这里遍历到第一个小于`x`的Node `b`
  3. `b`插到`a`之前


#### [92] Reverse Linked List II
- https://leetcode.com/problems/reverse-linked-list-ii/
1. Solution1:
  - 翻转开始前一个节点
  - 翻转完成后一个节点
  - 中间翻转
  - 转完连接
2. Solution2: 双指针，Runtime: 100%
   - `prev`移动到待操作结点`m`前一个，`node`从`m`到`n`移动，每个结点都接到`prev`的后面
   - 使用`sentinel node`防止在`list = [3, 5], m = 1, n = 2`的Testcase下出现`Null Pointer`


#### [93] 复原IP地址
- https://leetcode-cn.com/problems/restore-ip-addresses/description/
- 递归，DFS，分一位、两位、三位三种情况


#### [94] 二叉树的中序遍历
- https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
- https://juejin.im/post/59e3fde451882578c20858a5
- 将二叉树分为“左”（包括一路向左，经过的所有实际左+根）、“右”（包括实际的右）两种节点
- 使用同样的顺序将“左”节点入栈
- 在合适的时机转向（转向后，“右”节点即成为“左”节点）、访问节点、或出栈
- 在出栈之后才访问这个节点。因为先序先访问实际根，后访问实际左，而中序恰好相反。相同的是，访问完根+左子树（先序）或左子树+根（中序）后，都需要转向到“右”节点，使“右”节点称为新的“左”节点。


#### [98] 验证二叉搜索树
- https://leetcode-cn.com/problems/validate-binary-search-tree/description/
1. Solution1: 中序遍历为升序, Time: O(n), Space: O(n), Runtime: 29%
   - 中序遍历（先左，再根，后右）结果为升序序列，则满足二叉搜索树（左子节点小于根节点，根节点小于右子节点）
2. Solution2: 递归遍历, Time: O(n), Space: O(n), Runtime: 100%
   - 二叉搜索树，若根结点值为`node.val`，则左子树应满足`node.left.val < node.val`，即在开区间`(min, node.val)`内
   - 设计递归函数`traverse(TreeNode node, Integer min, Integer max)`，若递归过程中`node.val <= min` 或 `node.val >= max`，直接`false`
   - 遍历子树: `traverse(node.left, min, node.val)`
   - Tips: 
      1. 使用`Ineger`而不是`int`，并判断`min`是否为`null`(无法判断`int`是否为`null`)，解决遍历到无左/右子节点的corner case
      2. 调用为`traverse(root, null, null)`
      3. `if (node == null) return true`，否则无法work


#### [103] 二叉树的锯齿形层次遍历
- https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
1. Solution1, 递归，头尾插入
   - 判断当前层数，根据奇偶对`List`进行头插或尾插


#### [116] 填充每个节点的下一个右侧节点指针
- 递归，先中间走到底，再逐层向外
- 如果使用`parent`指向会导致不是父节点，同一层中间两个节点连不上
- 动图：![](https://cdn.jsdelivr.net/gh/joey66666/algorithms//Leetcode-cn/notes/pic/20200603221215.gif)


#### [124] 二叉树中的最大路径和
- https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
- 最大路径和 = 当前节点value + 左子树最大路径和 + 右子树最大路径和
- 如果子树路径 < 0 则返回 0，否则返回 当前节点value + Math.max(左子树最大路径和 + 右子树最大路径和)
- 使用数组来保存值，如果使用变量每次递归会更新值，无法保存最大的值
  

#### [127] 单词接龙
- https://leetcode-cn.com/problems/word-ladder/description/
- Solution1.1: https://www.acwing.com/solution/content/18017/
- Solution1.2: https://www.youtube.com/watch?v=hB_nYXFtwP0
1. Solution1.1，单向BFS，Time：7%
   - `Quene`记录当前`word`访问队列，下一邻结点需满足与`word`有且只有一个`char`不同，且未访问过，`HashMap`记录已访问过的结点及所需步数；
   - 若下一邻结点为`endWord`，return当前结点步数+1；
2. Solution1.2，单向BFS，Time：62%
   - 对`queue`里每个邻结点，对`String`的每个`char`进行`a ~ z`字母更换匹配，若在`wordList`中则放入`queue`



#### [144] 二叉树的前序遍历
- https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
- https://juejin.im/post/59e3fde451882578c20858a5
- 同[94] 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/


#### [146] LRU缓存机制
- https://leetcode-cn.com/problems/lru-cache/description/
- Time: O(1), Size: O(n)
- 双向链表中存储`Key`和`Value`, `HashMap`中存储`Key`和`Node`
- 链表从头到尾按以旧到新，新插入放到尾，最近get放到尾，`HashMap.size() >= capcity`删除头，`put`新`Node`
- ![image](https://user-images.githubusercontent.com/25404074/80353709-4fa02500-88a8-11ea-90ee-770fb2ad2277.png)


#### [179] Largest Number
- Overide the Comparator to self-compare in dict order
- e.g.: 
    - if s1="76", s2="53", str1 = s1 + s2="7653", str2 = s2 + s1="5375"
    - in which case str2 < str1
    - call Arrays.Sort() with new comparator
    - watch the corner case with all zero


#### [200] 岛屿数量
- https://leetcode-cn.com/problems/number-of-islands/description/
- == 1 则DFS遍历每个点的上下左右，把 1 变为 0，遍历结束count += 1


#### [201] 数字范围按位与
- https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/description/
- https://www.youtube.com/watch?v=fskPWs3Nuhc
1. Solution 1 
   - 最后的数是该数字范围内所有的数的左边共同的部分
   - 只要找到左边公共的部分
   - 直接平移m和n，每次向右移一位，直到m和n相等
   - 记录下所有平移的次数i，然后再把m左移i位即为最终结果
2. Solution 2
   - 从后往前每次 n = (n & (n-1)), 直到n <= m, 然后返回n,
   - 逐渐将最右边不同的置为0, 最后只剩下最左边m 和 n相同的位置.
   - 举例：110与上(110-1)，得到100，相当于去掉最低位的1，
   - n就这样每次去掉最低位的1，如果小于等于m了，返回此时的n


#### [207] 课程表
- https://leetcode-cn.com/problems/course-schedule/description/
1. Solution1, BFS
   - https://www.youtube.com/watch?v=fskPWs3Nuhc
   - 设置出度邻接表和入度数组，构建图
       - 邻接表结构：[index, index出度的List]
   - 设置一个Queue，放入入度为0的数a，即没有其他课程依赖该课程a
   - 然后while(!Queue.isEmpty()), Queue.poll()，即BFS依赖该课程a的其他课程
   - 邻接表 index==a 的List里的每个课程都-=1
   - 若过程中有课程b入度为0，则放入queue
   - 最后遍历入度数组，若存在>0则表示该课程仍有先修课没完成，即false；遍历完true
   - ![image](https://user-images.githubusercontent.com/25404074/90650728-c9508a00-e26e-11ea-9dbb-8a813cd8eb38.png)


#### [215] 数组中的第K个最大元素
- https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
- 先排序再输出，`Arrays.sort()`升序排列


#### [221] 最大正方形
- https://leetcode-cn.com/problems/maximal-square/description/
- dp[i][j]数组用来保存以matrix[i][j]为右下角的最大正方形边长
```java
if(matrix[i][j] == 1){ 
     dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]) + 1
}
```
- return dp 数组中最大值的 ^2 
- ![image](https://user-images.githubusercontent.com/25404074/80496729-2eb8fc00-899c-11ea-973d-8c0b39fde046.png)


#### [238] 除自身以外数组的乘积
- https://leetcode-cn.com/problems/product-of-array-except-self/description/
- 从左到右遍历保存`nums[i]`左边所有数的乘积`res[i] = left; left *= nums[i]`
再从右往左遍历，右边的所有数乘积乘上左边的` res[i] *= right; right *= nums[i];  `


#### [316] 去除重复字母
- https://leetcode-cn.com/problems/remove-duplicate-letters/description/
1. Solution1: Stack
   - 遍历，若当前字母小于栈顶字母，且后面存在栈顶字母，则弹出栈顶

#### [376] 摆动序列
- https://leetcode-cn.com/problems/wiggle-subsequence/description/
- https://www.acwing.com/solution/LeetCode/content/4912/
1. Solution 1, 贪心，Time: O(n)
   - ![image](https://user-images.githubusercontent.com/25404074/101989006-603ac980-3cd8-11eb-955e-c726b7e3ad74.png)
   - 寻找峰点（极大值）和谷点（极小值）
   - 使用一个变量`trend`标记上一个元素的趋势，`1`递增，`-1`递减
   - 若`nums[i] > nums[i - 1] && trend < 0`则为谷点，`res += 1`
   - 若`nums[i] < nums[i - 1] && trend > 0`则为峰点，`res += 1`
   - 否则为山腰点，即处于递增和递减的过程中，不计
2. Solution 2, DP，Time: O(n)
   - 寻找拐点
   - 状态表示：`dp_up[n]`代表前`i`个元素且最后一个状态是上升的最长摆动序列长度, `dp_down[n]`代表前`i`个元素且最后一个状态是下降的最长摆动序列长度, 
   - 初始状态：`dp_up, dp_down`初始化为1，仅有一个元素的情况
   - 状态转移：
     - 若`nums[i] > nums[i - 1]`则`dp_up[n] = dp_down[n - 1] + 1`，表示发生一次由下降到上升的转折
     - 若`nums[i] < nums[i - 1]`则`dp_down[n] = dp_up[n - 1] + 1`，表示发生一次由上升到下降的转折
     - 否则`dp_up[i] = dp_up[i - 1], dp_down[i] = dp_down[i - 1]`，表示趋势未变，即没有转折，最长摆动序列长度保持，不增加
   - 结果表示：`Math.max(dp_up[n - 1], dp_down[n - 1])`


#### [402] 移掉K位数字
- https://leetcode-cn.com/problems/remove-k-digits/description/
1. Solution1，贪心；
   - 从左到右找到第一个递减的位置，将前面的大数删掉；
     - 例如：
     - 1432219 “43”位置递减，将4删掉
     - 132219 “32”位置递减，将3删掉
     - 12219 “21”位置递减，将2删掉
     - 最后结果1219
   - 若整个数字全部是递增的，只把末尾删除；
   - 不能有前导0，即”0200“，把前导0删掉，即”200“



#### [495] Teemo Attacking
- Compare last time + duration and current time
- Time: O(n), Runtime: 99.3% 


#### [503] 下一个更大元素 II
- https://leetcode-cn.com/problems/next-greater-element-ii/description/
1. Solution1, 暴力，每个数向前向后遍历两次，注意判断当前index是否已被置过
2. Solution2, 单调栈
   1. 将数组中所有元素全部置为-1
   2. 遍历两次，相当于循环遍历，取余进行边界回归
   3. 第一遍遍历，入栈索引i
   4. 只要后面元素比栈顶索引对应的元素大，索引出栈，更改res[sta.pop()]的数值
   5. 最后栈里面剩余的索引对应的数组值，都为默认的-1（因为后面未找到比它大的值） */


#### [525] 连续数组
- https://leetcode-cn.com/problems/contiguous-array/description/
- 测试用例只包含0和1，遇0减1、遇1加1，存`sum`值到HashMap中，若`sum`之前存在，则说明`sum + 0 = sum`，即中间子序列和为0，即0和1个数相
- HashMap中需要先`put(0, -1)`来使比如在`[0, 1]`上遍历`sum = 0`时`index = 1`，此时应该更新`res = 2`，而非记录为`index=1, res = 0`


#### [540] 有序数组中的单一元素
- https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
- 其他成对出现，所以SingleNumber存在的序列长度为奇数
- 对于中点位置和左右进行判断，再对左右子序列中的元素个数进行判断奇偶，找到单个元素存在的方向，进行二分查找
- 注意若是偶数则 +=2 相同序列，否则 +=1
- 再搞不清打草稿列举一下（[11223],[12233],[1122334],[0112233]）


#### [560] 和为K的子数组
- https://leetcode-cn.com/problems/subarray-sum-equals-k/description/
-  prefixSum array 记录从0到i的前缀sum
-  subarray(i, j) = prefixSum(j) - prefixSum(i - 1)
-  找到 prefixSum(j)- prefixSum(i) == k == subarray(i, j)
-  HashMap<Integer, Integer>: <prefixSum, prefixSum出现的次数>
-  Time:O(n), Space:O(n)


#### [649] Dota2 参议院
- https://leetcode-cn.com/problems/dota2-senate/description/
- Solution：char[] newSenate
  
  - 不是要统计数字，而是要ban到一方无法投票为止；
  - 用一个新char数组记录senate，并统计两方被ban个数，有被ban则ban掉对方的senator；
  - 每一轮结束查看newSenate里双方情况；
  - 直到一方被ban空为止，退出循环，return另一方。


#### [659] 分割数组为连续子序列
- https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/description/
- Solution：
  - HashMap先统计一遍所有数字的出现频率
  - 遍历数组，记录subArray的大小，遍历当前数字的下一个数，统计频率
  - 若下一个数频率` > 1`，即可加入现有subArray或构建新array，下一个数频率`-= 1`， 继续遍历
  - 否则停止，比较subArray大小，若`> 1 && < 3`则当前subArray不符合条件，即无法拆分原数组，`return false`


#### [678] 有效的括号字符串
- https://leetcode-cn.com/problems/valid-parenthesis-string/description/
1. Solution 1 
    - 两个栈（ * 和 left ），遍历，存入index，遇到' ) '先用 left ，再用 * 抵消，都为空则false
    - 遍历完若两栈都不空，if（ index(left) > index(*) ) 则为" *( "形式，无法抵消，false；若可抵消则都pop
    - 若 pop 完 left 空，* 不空，* 可视为空字符串，true
    - 若 pop 完 left 不空，* 空，false
2. Solution 2
    - 先从左往右遍历，所有 * 视为 ( ，* 和 ( 则 + 1，否则 - 1
    - 若中间有 < 0，则表示所有 * 不够抵消 ) ，return false
    - 若遍历完 = 0，表示 * 和 ( 正好抵消 )，return true
    - 若 > 0 ，可能有 * 补充了没用完，进行下一步
    - 下一步从右往左遍历， 所有 * 视为 ) ，* 和 ) 则 + 1，否则 - 1
    - 若过程中 < 0 ，( 数量大于 ), return false
    - 若遍历完 = 0，* 正好抵消，return true
    - 若遍历完 > 0，之前一轮遍历中 * 变的 数量 ( < 这一轮数量 ) ，表示部分 * 可变为 ( 或 ) 抵消，部分为空字符串, return true


#### [714] 买卖股票的最佳时机含手续费
- https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
1. Solution1: DP，DP数组优化为DP变量
   - 两个变量`sold, hold`表示当天持有股票价值和卖出股票收益
   - 初始状态：第一天买入，`hold = -prices[0], sold = 0`；
   - 状态转移：
      1. 今天持有股票，取决于昨天持有股票或昨天今天买入新股票后两者的最大值 `hold = Math.max(hold, sold - prices[i])`
      2. 今天卖出股票，取决于继续持有股票(不卖出)或卖出今天股票获取收益后两者的最大值 `sold = Math.max(sold, hold + prices[i] -fee)`
      3. 最终收益为`sold`


#### [738] 单调递增的数字
- https://leetcode-cn.com/problems/monotone-increasing-digits/description/
1. Solution1: Greddy, Time:O(n), Runtime: 97%
   - 从左到右遍历，找到第一个转折点(非递增位)，将该位`-1`，后面所有位置为`9`


#### [861] 翻转矩阵后的得分
- https://leetcode-cn.com/problems/score-after-flipping-matrix/description/
- Solution: 
  1. 首先，翻转各行，把第一列全部置为1
  2. 然后，翻转各列，使各列内1数量达到最大
  3. 注意优化计算方式，可以在第二步同时计算结果
  

#### [901] 股票价格跨度
- https://leetcode-cn.com/problems/online-stock-span/description/
1. Solution1，暴力
2. Solution2，单调递减栈
   - 只需要找到数字A其前面有多少个连续的并且比它小的数字个数a
   - 出现数字B，当B>=A时，在B前面小于等于B的连续数字共有a + 1个
   - 当B < A时，在B前面小于等于B的连续数字只有1个，B自己
   - 两个栈，第一个保存数， 第二个保存当前的价格向前可以找连续的多少天
   - 如果新来的数值大于了栈顶元素，把栈顶的元素弹出，直到当前元素小于栈顶


#### [907] 子数组的最小值之和
- https://leetcode-cn.com/problems/sum-of-subarray-minimums/description/
1. Solution1，DP，三次遍历
   - 假设A[i]左边有L个数大于它，右边有R个数大于它
   - 则以A[i]为最小数共有 (L-1)*(R-1) 个子数组
   - 结果为 `A[i] * left[i] * right[i]`
   - 防止出现重复多算的情况，在一边计算大于等于，另一边计算大于
   - Time：O(N)
   - https://leetcode.flowerplayer.com/2019/04/12/leetcode-907-sum-of-subarray-minimums-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
2. Solution2，单调栈，思路同[901]
   

#### [1008] 先序遍历构造二叉树
- https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
- 第一个是根，往后遍历，<=根为左子树，剩下为右子树
- 递归遍历 


#### [1094] Car Pooling
- Use one-hot int array to record numbers at every location on and off the bus
- Compute all the locations and compare with capacity
- Two circle
- Time: O(n), Runtime: 100%


#### [1143] 最长公共子序列
- https://leetcode-cn.com/problems/longest-common-subsequence/description/
- dp[text1.length() + 1][text2.length() + 1]
- dp[i][j]表示两个字符串在i, j之前位置（不包含i, j）的最大公共子序列长度
- if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1
- else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
- ![image](https://user-images.githubusercontent.com/25404074/80450199-96972480-8953-11ea-8641-656efe8beffe.png)


#### [1551] 使数组中所有元素相等的最小操作数
- https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal/description/
- https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal/solution/shi-shu-zu-zhong-suo-you-yuan-su-xiang-deng-de-z-4/
1. Solution1，贪心, Time: O(n), Space: O(1), Runtime: 56%
   - 每次同时进行了「加」操作和「减」操作，只需要记录「减」操作的数量可知道操作了多少次。
   - 对于每一个大于 `n` 的数，其与 `n` 的差值即为该元素需要进行的「减」操作的数量。统计所有大于 `n` 的数与 `n` 的差值
2. Solution2，数学方法, Time: O(1), Space: O(1), Runtime: 100%
   - ANS展开，分奇偶，再合并，得出结果为`n^2 / 4`


#### First Unique Numer
Medium(Maybe)
- https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
- 思路同[[146] LRU Cache](https://leetcode-cn.com/problems/lru-cache/description/)
- 使用双链表 + HashMap，链表节点存`Key`，HashMap中存储`Key`和`Node`，添加时检查`number`是否为 unique ，否则的话从链表中删除。如果从HashMap中删除，可能存在单数形式被认为是unique number。
- 解决方法：不从HashMap中删除，在每次从`DoubleLinkedList`删除`Node`的逻辑里判断是否已经删除过这个`Node`了，如果已删除过，则重复，直接`return`


#### Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
Medium(Maybe)
- https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
- 必须从root开始，到leaf结束
- 两种情况
   1. 当前节点value != arr[i], return false;
   2. arr到达末尾，树未遍历到leaf, return false;
- 遍历左右子树，root为根有一棵子树为true则存在序列


#### 合并k个排序数组
- Lintcode 486. 合并k个排序数组
- https://www.lintcode.com/problem/merge-k-sorted-arrays/
1. Solution1: 暴力
   - 使用系统自带最小堆，add一遍在poll一遍，排序交给最小堆自动完成，暴力
   - Time: O(n^2logn), Runtime: 14%
   - 遍历放入后用系统内置数组排序，暴力
   - Time: O(nlogn), Runtime: 26%
  
2. Solution2: 改进最小堆
   - 最小堆放入每行第一个元素，取出元素后放入该元素的右一个，直到堆为空
   - 需要自定义一个数据结构表示该元素的坐标，并重写堆的Comparator
   - Time: O(nlogk)，总元素n，k行/个数组, Runtime: 64%
3. Solution3: Merge归并
   - 合并两个数组：双指针同时遍历比较，返回合并后的数组
   - 合并k个数组：对k维数组进行递归，拆解到最后每两个一组，使用合并两个数组方法两两再两两合并。结束条件为`left == right`或`left + 1 == right`
   - Time: O(nlogk), Runtime: 83%


#### 面试题 08.04. 幂集
- https://leetcode-cn.com/problems/power-set-lcci/
- https://wy-ei.github.io/leetcode/78-subsets/
1. Solution1, 迭代，Time: O(nlogn), Space: O(1), Runtime: 100%
   - 初始化 `res` 加入空 `List`，每新遇到一个数，把 `res` 中所有`List`都加上这个数，组成新 `List` 再放入 `res`
2. Solution2, 位图，Time: O(n*2^n), Space: O(1), Runtime: 88%
   - 长度为 `n` 的数组共有 `2 ^ n` 个幂集
   - 把 `nums` 中的元素映射到一个表中，对应位置有元素则可放入结果中
   - 这个方法，更像是数学题，找到了一种的规律
   - ![位图](https://github.com/joey66666/ImgHost/blob/main/leetcode/power-set-lcci-bitmap.png?raw=true)


#### 面试题 16.20. T9键盘
- https://leetcode-cn.com/problems/t9-lcci/
1. Solution1: 数组映射
   - 使用一个 `char` 数组映射每个字母对应的数字
   - 遍历，判断 `word` 每个 `char` 是否与 `num` 对应，整个 `word` 都对应加到 `res` 里