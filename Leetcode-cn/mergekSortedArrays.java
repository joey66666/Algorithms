import java.util.List;

/**
Lintcode 486. 合并k个排序数组
将 k 个有序数组合并为一个大的有序数组。

样例
Example 1:

Input: 
  [
    [1, 3, 5, 7],
    [2, 4, 6],
    [0, 8, 9, 10, 11]
  ]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Example 2:

Input:
  [
    [1,2,3],
    [1,2]
  ]
Output: [1,1,2,2,3]
挑战
在 O(N log k) 的时间复杂度内完成：

N 是所有数组包含的整数总数量。
k 是数组的个数。
 */


// Solution1: 使用系统自带最小堆，暴力
// Time: O(n^2logn), Runtime: 14%
// public class Solution {
//     /**
//      * @param arrays: k sorted integer arrays
//      * @return: a sorted array
//      */
//     public int[] mergekSortedArrays(int[][] arrays) {
//         // write your code here
//         if (arrays.length == 0 || arrays[0].length == 0) return new int[0];
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //最小堆
//         int count = 0;
//         for (int i = 0; i < arrays.length; i++) {
//             for (int j = 0; j < arrays[i].length; j++) {
//                 minHeap.add(arrays[i][j]);
//                 count += 1;
//             }
//         }
//         int[] res = new int[count];
//         int index = 0;
//         while (!minHeap.isEmpty()) {
//             res[index] = minHeap.poll();
//             index += 1;
//         }
//         return res;
//     }
// }

// Solution1: 系统自带数组排序，暴力
// Time: O(nlogn), Runtime: 26%
// public class Solution {
//     /**
//      * @param arrays: k sorted integer arrays
//      * @return: a sorted array
//      */
//     public int[] mergekSortedArrays(int[][] arrays) {
//         // write your code here
//         if (arrays.length == 0 || arrays[0].length == 0) return new int[0];
//         List<Integer> list = new ArrayList<>();
//         for(int i = 0; i < arrays.length; i++){
//             for(int j = 0; j < arrays[i].length; j++){
//                 list.add(arrays[i][j]);
//             }
//         }
//         int[] res = new int[list.size()];
//         for(int i = 0; i < list.size(); i++){
//             res[i] = list.get(i);
//         }
//         Arrays.sort(res);
//         return res;
//     }
// }

// Solution2: 改进最小堆
// 最小堆放入每行第一个元素，取出元素后放入该元素的右一个，直到堆为空
// 需要自定义一个数据结构表示该元素的坐标，并重写堆的Comparator
// Time: O(nlogk)，总元素n，k行/个数组, Runtime: 64%
// public class Solution {
//     /**
//      * @param arrays: k sorted integer arrays
//      * @return: a sorted array
//      */
//     class num {
//         public int row, col, val;

//         num(int row, int col, int val) {
//             this.row = row;
//             this.col = col;
//             this.val = val;
//         }
//     }

//     public int[] mergekSortedArrays(int[][] arrays) {
//         // write your code here
//         if (arrays.length == 0 || arrays[0].length == 0) return new int[0];
//         PriorityQueue<num> heap = new PriorityQueue<num>(arrays.length, new Comparator<num>() {
//             @Override
//             public int compare(num o1, num o2) {
//                 return o1.val - o2.val;
//             }
//         });
//         int count = 0;
//         for (int i = 0; i < arrays.length; i++) {
//             num n = new num(i, 0, arrays[i][0]);
//             heap.add(n);
//             count += arrays[i].length;
//         }
//         int[] res = new int[count];
//         int index = 0;
//         while (!heap.isEmpty()) {
//             num n = heap.poll();
//             res[index++] = n.val;
//             if (n.col + 1 < arrays[n.row].length) {
//                 n.col += 1;
//                 n.val = arrays[n.row][n.col];
//                 heap.add(n);
//             }
//         }
//         return res;
//     }
// }

// Solution3: Merge归并
// 合并两个数组：双指针同时遍历比较，返回合并后的数组
// 合并k个数组：对k维数组进行递归，拆解到最后每两个一组，使用合并两个数组方法两两再两两合并。结束条件为`left == right`或`left + 1 == right`
// Time: O(nlogk), Runtime: 83%
public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
            if(arrays == null || arrays.length == 0)
                return null;
            
            return helper(arrays, 0, arrays.length-1);
 
    }
    
    private int[] helper(int[][] arrays, int l, int r){
        if(l == r)
            return arrays[l];
        if(l + 1 == r)
            return merge2Arrays(arrays[l], arrays[r]);
        
        int mid = l + (r-l)/2;
        int[] left = helper(arrays, l, mid);
        int[] right = helper(arrays, mid+1, r);
        
        return merge2Arrays(left, right);
    }
    
    private int[] merge2Arrays(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        
        int i=0, j=0;
        for(int k=0; k<res.length; k++){
            if(i >= a.length)
                res[k] = b[j++];
            else if(j >= b.length)
                res[k] = a[i++];
            else if(a[i] < b[j])
                res[k] = a[i++];
            else
                res[k] = b[j++];
        }
        
        return res;
    }
}
