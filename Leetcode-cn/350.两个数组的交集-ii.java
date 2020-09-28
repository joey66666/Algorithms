/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (52.39%)
 * Likes:    394
 * Dislikes: 0
 * Total Accepted:    144.5K
 * Total Submissions: 273.1K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶：
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List list = new ArrayList<Integer>();
        for (int num1 : nums1) {
            if (!hm.containsKey(num1)) {
                hm.put(num1, 1);
            } else {
                hm.put(num1, hm.get(num1) + 1);
            }
        }

        for (int num2 : nums2) {
            if (hm.containsKey(num2)) {
                if (hm.get(num2) <= 0) {
                    continue;
                }
                hm.put(num2, hm.get(num2) - 1);
                list.add(num2);
            }
        }
        int[] res = new int[list.toArray().length];
        for (int i = 0; i < list.toArray().length; i++) {
            res[i] = (int) list.get(i);
        }
        return res;
    }
}
// @lc code=end

