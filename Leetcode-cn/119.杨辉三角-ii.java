import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        if (rowIndex == 0) {
            return last;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(last.get(j)+last.get(j-1));
            }
            temp.add(1);
            last=temp;

        }
        return last;
    }
}
// @lc code=end
