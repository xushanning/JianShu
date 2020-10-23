//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 583 👎 0


package leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
        solution.maxProfit(new int[]{1, 2, 3, 0, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) {
                return 0;
            }
            //状态是当天交易完后的状态
            //dp[i][0]:第i天不持有
            //dp[i][1]:第i天持有
            //dp[i][2]:冷冻
            int[][] dp = new int[len][4];


            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;

            for (int i = 1; i < len; i++) {
                //昨天不持有、昨天持有，今天卖出
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //昨天冷冻、昨天持有、昨天不持有(为什么这种不能加？)
                //dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]), dp[i - 1][0] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
                //昨天卖出,也就是不持有
                dp[i][2] = dp[i - 1][0];
            }
            //最大值肯定是最后一天手里没有股票
            return Math.max(dp[len - 1][0], dp[len - 1][2]);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}