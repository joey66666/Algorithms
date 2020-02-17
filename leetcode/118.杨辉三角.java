import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int arry[][]=new int[numRows][numRows];
        List<Integer> list1= null;

        for(int i=0;i<numRows;i++){
            arry[i][0]=1;
            list1=new ArrayList<Integer>();
            list1.add(arry[i][0]);
            for(int j=1;j<=i;j++){
                arry[i][j]=arry[i-1][j-1]+arry[i-1][j];
                list1.add(arry[i][j]);
            }
            list.add(list1);
        }
        return list;
    }
}
// @lc code=end
