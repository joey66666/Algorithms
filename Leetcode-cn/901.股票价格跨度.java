/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 *
 * https://leetcode-cn.com/problems/online-stock-span/description/
 *
 * algorithms
 * Medium (42.42%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    7K
 * Total Submissions: 14.8K
 * Testcase Example:  '["StockSpanner","next","next","next","next","next","next","next"]\n' +
  '[[],[100],[80],[60],[70],[60],[75],[85]]'
 *
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4,
 * 6]。
 *
 *
 *
 * 示例：
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"],
 * [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 *
 *
 */

// @lc code=start
// Solution1，暴力
//class StockSpanner {
//    int n = 0;
//    int[] stocks;
//    public StockSpanner() {
//        stocks = new int[100000];
//    }
//
//    public int next(int price) {
//        stocks[n] = price;
//        int res = 0;
//        for (int i = n; i >= 0; i--) {
//            if (stocks[i] <= stocks[n]) {
//                res += 1;
//            } else {
//                break;
//            }
//        }
//        n += 1;
//        return res;
//    }
//}

import java.util.Stack;

// Solution2，单调递减栈
// 只需要找到数字A其前面有多少个连续的并且比它小的数字个数a，
// 出现数字B，当B>=A时，在B前面小于等于B的连续数字共有a + 1个；
// 当B < A时，在B前面小于等于B的连续数字只有1个，B自己。
// 栈保存的是当前的价格向前可以找连续的多少天。
// 如果新来的数值大于了栈顶元素，把栈顶的元素弹出，直到当前元素小于栈顶
class StockSpanner {
    Stack<Integer> prices;
    Stack<Integer> steps;

    public StockSpanner() {
        prices = new Stack<>();
        steps = new Stack<>();
    }

    public int next(int price) {
        int s = 1;
        while (!prices.empty() && price >= prices.peek()) {
            prices.pop();
            s += steps.pop();
        }
        prices.push(price);
        steps.push(s);
        return s;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

