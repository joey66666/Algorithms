// 面试题 08.04. 幂集
// 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

// 说明：解集不能包含重复的子集。

// 示例:

//  输入： nums = [1,2,3]
//  输出：
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// Solution1, 迭代，Time: O(nlogn), Space: O(1), Runtime: 100%
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        res.add(new ArrayList<Integer>());
        for(int num: nums){
            int t = res.size();
            for(int i = 0; i < t; i++){
                List l = new ArrayList(res.get(i));
                l.add(num);
                res.add(l);
            }
        }
        return res;
    }
}

// Solution2, 位图，Time: O(n*2^n), Space: O(1), Runtime: 88%
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        int length = 1 << n; // = 2 ^ n
        for(int i = 0; i < length; i++){
            List<Integer> t = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(((i >> j) & 1) == 1){
                    t.add(nums[j]);
                }
            }
            res.add(t);
        }
        return res;
    }
}