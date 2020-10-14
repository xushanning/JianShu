//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 885 👎 0


package leetcode.editor.cn;

//Java：买卖股票的最佳时机 II
public class P122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new P122BestTimeToBuyAndSellStockIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            //这里的原理有一个解释很好：
            //[7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），所以一般人可能会想，怎么判断不是第三天就卖出了呢?
            // 这里就把问题复杂化了，根据题目的意思，当天卖出以后，当天还可以买入，所以其实可以第三天卖出，第三天买入，第四天又卖出（（5-1）+ （6-5） === 6 - 1）。
            // 所以算法可以直接简化为只要今天比昨天大，就卖出。


            //[7,1,5,3,6,7]   7   1买5卖，3买7卖

            //化成算法就是：
            //1-7<0.不管
            //5-1,能赚4块钱
            //3-5不算，可以看做第四天买了3，又在第四天卖了
            //6-3，赚3块
            //7-6,赚1块

            int len = prices.length;
            if (len == 0) {
                return 0;
            }
            int max = 0;
            for (int i = 1; i < len; i++) {
                int dif = prices[i] - prices[i - 1];
                if (dif > 0) {
                    max += dif;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}