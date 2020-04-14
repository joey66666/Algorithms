// Perform String Shifts
// You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:

// direction can be 0 (for left shift) or 1 (for right shift). 
// amount is the amount by which string s is to be shifted.
// A left shift by 1 means remove the first character of s and append it to the end.
// Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
// Return the final string after all operations.


// Example 1:

// Input: s = "abc", shift = [[0,1],[1,2]]
// Output: "cab"
// Explanation: 
// [0,1] means shift to left by 1. "abc" -> "bca"
// [1,2] means shift to right by 2. "bca" -> "cab"
// Example 2:

// Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
// Output: "efgabcd"
// Explanation:  
// [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
// [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
// [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
// [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"


// Constraints:

// 1 <= s.length <= 100
// s only contains lower case English letters.
// 1 <= shift.length <= 100
// shift[i].length == 2
// 0 <= shift[i][0] <= 1
// 0 <= shift[i][1] <= 100

// 先计算所有移动值
// 记得 while(sum > s.length) sum %= s.length 
class Solution {
    public String stringShift(String s, int[][] shift) {
        //0: left, 1: right
        int n = shift.length;
        int l = s.length();
        String res = "";
        if (n == 0) return null;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int direction = shift[i][0];
            int amount = shift[i][1];
            sum += direction == 1 ? (direction * amount) : (-amount);
        }
        // right
        if (sum > 0) {
            while (sum > l) {
                sum %= l;
            }
            String front = s.substring(0, l - sum);
            String back = s.substring(l - sum);
            res = back + front;
        }
        // left
        else if (sum < 0) {
            sum = Math.abs(sum);
            while (sum > l) {
                sum %= l;
            }
            String front = s.substring(0, sum);
            String back = s.substring(sum);
            res = back + front;

        }
        return res;
    }
}