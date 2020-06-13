/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (50.29%)
 * Likes:    99
 * Dislikes: 0
 * Total Accepted:    17.5K
 * Total Submissions: 34.8K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 *
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 *
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 *
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 *
 *
 */

// @lc code=start
// Solution1 暴力
//class Solution {
//    public boolean backspaceCompare(String S, String T) {
//        String s1 = "";
//        String t1 = "";
//
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) != '#') {
//                s1 += S.charAt(i);
//            } else {
//                if (s1.length() == 0) continue;
//                else s1 = s1.substring(0, s1.length() - 1);
//            }
//        }
//        for (int i = 0; i < T.length(); i++) {
//            if (T.charAt(i) != '#') {
//                t1 += T.charAt(i);
//            } else {
//                if (t1.length() == 0) continue;
//                else t1 = t1.substring(0, t1.length() - 1);
//            }
//        }
//        return s1.equals(t1);
//    }
//}

// Solution2 改进暴力（提升不大）
class Solution {
   public boolean backspaceCompare(String S, String T) {
       String s1 = "";
       String t1 = "";
       int length = Math.max(S.length(), T.length());

       for (int i = 0; i < length; i++) {

           if (i < S.length()) {
               if (S.charAt(i) != '#') {
                   s1 += S.charAt(i);
               } else {
                   if (s1.length() == 0) {
                   } else s1 = s1.substring(0, s1.length() - 1);
               }
           }

           if (i < T.length()) {
               if (T.charAt(i) != '#') {
                   t1 += T.charAt(i);
               } else {
                   if (t1.length() == 0) {
                   } else t1 = t1.substring(0, t1.length() - 1);
               }
           }
       }
       return s1.equals(t1);
   }
}

// Solution3 栈
// class Solution {
//     public boolean backspaceCompare(String S, String T) {
//         Stack<Character> s1 = new Stack<>();
//         Stack<Character> t1 = new Stack<>();
//         int length = Math.max(S.length(), T.length());

//         for (int i = 0; i < length; i++) {

//             if (i < S.length()) {
//                 if (S.charAt(i) != '#') {
//                     s1.push(S.charAt(i));
//                 } else if (!s1.isEmpty()) {
//                     s1.pop();
//                 }
//             }

//             if (i < T.length()) {
//                 if (T.charAt(i) != '#') {
//                     t1.push(T.charAt(i));
//                 } else if (!t1.isEmpty()) {
//                     t1.pop();
//                 }
//             }
//         }
//         return t1.equals(s1);
//     }
// }
// @lc code=end