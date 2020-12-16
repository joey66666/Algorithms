/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 *
 * https://leetcode-cn.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (44.33%)
 * Likes:    113
 * Dislikes: 0
 * Total Accepted:    14.3K
 * Total Submissions: 29.5K
 * Testcase Example:  '10'
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * 
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 
 * 示例 1:
 * 
 * 输入: N = 10
 * 输出: 9
 * 
 * 
 * 示例 2:
 * 
 * 输入: N = 1234
 * 输出: 1234
 * 
 * 
 * 示例 3:
 * 
 * 输入: N = 332
 * 输出: 299
 * 
 * 
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * 
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] NArray = String.valueOf(N).toCharArray();
        int max = -1;
        int index = -1;
        for(int i = 0; i < NArray.length - 1; i++){
            if(max < NArray[i]){
                max = NArray[i];
                index = i;
            }
            if(NArray[i] > NArray[i + 1]){
                NArray[index] -= 1;
                for(int j = index + 1; j < NArray.length; j++){
                    NArray[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(NArray));
    }
}
// @lc code=end

