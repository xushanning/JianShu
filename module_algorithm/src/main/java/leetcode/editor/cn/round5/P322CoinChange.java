//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 879 👎 0


package leetcode.editor.cn.round5;

import java.util.Arrays;

//Java：零钱兑换
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
        solution.coinChange(new int[]{2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int res = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {

            int len = coins.length;
            if (len == 0) {
                return 0;
            }
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
            //先排个序
            Arrays.sort(coins);
            minCoin(coins, amount, 0, len - 1);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private void minCoin(int[] conis, int lack, int count, int maxIndex) {
            //说明正好能找到
            if (lack == 0) {
                res = Math.min(res, count);
                return;
            }
            if (maxIndex < 0) {
                return;
            }

            //从最大的开始取 1 2 5 ,然后取整，代表用最大的数，看看需要多少个，如果不需要那么跳出循环
            //a为最多maxindex相加不大于lack的数量
            int a = lack / conis[maxIndex];
            //每次减少1，看看有没有其他比这更优的方案
            //  i + count < res 如果i+count就已经大于res，那么不是最优解，没有必要进去
            for (int i = a; i >= 0 && i + count < res; i--) {
                minCoin(conis, lack - i * conis[maxIndex], count + i, maxIndex - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}