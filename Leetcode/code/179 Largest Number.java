//Largest Number
//
//Solution
//Given a list of non negative integers, arrange them such that they form the largest number.
//
//Example 1:
//
//Input: [10,2]
//Output: "210"
//Example 2:
//
//Input: [3,30,34,5,9]
//Output: "9534330"


import java.util.Arrays;
import java.util.Comparator;

class Solution {

    class stringComp implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }

    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, new stringComp());
        if (stringNums[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : stringNums) {
            sb.append(s);
        }
        return sb.toString();
    }
}
