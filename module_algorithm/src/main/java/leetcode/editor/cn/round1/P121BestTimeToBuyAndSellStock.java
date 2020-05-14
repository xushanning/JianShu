//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn.round1;

//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //自己想出来的，哦也
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len <= 1) {
                return 0;
            }
            int[] dp = new int[len + 2];


            //前i天的最大利润可以看成分成两种情况：
            //第i天，卖了，那么最大利润就是第i天减去前面最小的一个
            //第i天，不卖，那么就是前i-1天中买了，又卖了
            //状态转移方程：dp[i]=max{dp[i-1],prices[i]-min[i-1]}
            //min[i-1]为前i-1项最小的值


            //边界
            dp[1] = 0;
            //前i-1个最小的值
            int min = prices[0];
            int result = 0;
            //[7, 1, 5, 3, 6, 4]
            for (int i = 1; i < len; i++) {
                dp[i + 1] = Math.max(dp[i], prices[i] - min);
                if (dp[i + 1] > result) {
                    result = dp[i + 1];
                }
                min = Math.min(prices[i], min);
            }
            if (result <= 0) {
                return 0;
            }
            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}