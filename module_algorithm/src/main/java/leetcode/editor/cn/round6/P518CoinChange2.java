//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 262 👎 0


package leetcode.editor.cn.round6;

//Java：零钱兑换 II
public class P518CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new P518CoinChange2().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int res = 0;

        public int change(int amount, int[] coins) {
//            int len = coins.length;
//            if (len == 0) {
//                if (amount == 0) {
//                    res++;
//                }
//                return res;
//            }
//            Arrays.sort(coins);
//            help(coins, len - 1, amount);
//            return res;
            //状态方程是 对于第k个硬币能凑出的组合数
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i < amount + 1; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];

        }

        //这种方法虽然理论上是对的，但是有一些example会超时
//        private void help(int[] coins, int maxIndex, int lack) {
//            if (lack == 0) {
//                res++;
//                return;
//            }
//            if (maxIndex < 0) {
//                return;
//            }
//            int maxCount = lack / coins[maxIndex];
//            for (int i = maxCount; i >= 0; i--) {
//                help(coins, maxIndex - 1, lack - i * coins[maxIndex]);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}