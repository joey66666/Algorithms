/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 *
 * https://leetcode-cn.com/problems/fair-candy-swap/description/
 *
 * algorithms
 * Easy (55.88%)
 * Likes:    142
 * Dislikes: 0
 * Total Accepted:    43.3K
 * Total Submissions: 68.5K
 * Testcase Example:  '[1,1]\n[2,2]'
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 1 
 * 1 
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 * 
 * 
 */

// @lc code=start
// Solution1, 暴力，Time: O(n * m), Space: O(1), Runtime: 15%
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aLength = A.length, bLength = B.length;
        int[] res = new int[2];
        if(aLength == 0 || bLength == 0) return res;
        int aCount = 0, bCount = 0;
        for(int a: A){
            aCount += a;
        }
        for(int b: B){
            bCount += b;
        }
        for(int i = 0; i < aLength; i++){
            for(int j = 0; j < bLength; j++){
                int aIndex = A[i];
                int bIndex = B[j];
                int resA = aCount - aIndex;
                int resB = bCount - bIndex;
                if((aIndex + resB) == (bIndex + resA)){
                    res[0] = aIndex;
                    res[1] = bIndex;
                    return res;
                }
            }
        }
        return res;
    }
}

// Solution2, 二分，Time: O(max(m, n)), Space: O(1), Runtime: 48%
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aLength = A.length, bLength = B.length;
        int[] res = new int[2];
        if(aLength == 0 || bLength == 0) return res;
        int aCount = 0, bCount = 0;
        for(int a: A){
            aCount += a;
        }
        for(int b: B){
            bCount += b;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        int diff = aCount - (aCount + bCount) / 2;
        while(i < aLength || j < bLength){
            if(A[i] - B[j] == diff){
                res[0] = A[i];
                res[1] = B[j];
                return res;
            }else if(A[i] - B[j] > diff){
                j += 1;
            }else if(A[i] - B[j] < diff){
                i += 1;
            }
        }
        return res;
    }
}
// @lc code=end

