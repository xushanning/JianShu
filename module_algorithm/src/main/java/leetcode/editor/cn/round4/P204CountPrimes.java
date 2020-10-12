//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学 
// 👍 382 👎 0


package leetcode.editor.cn.round4;

import java.util.Arrays;

//Java：计数质数
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            if (n < 2) {
                return 0;
            }
            //第i个是否是质数
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);


            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    //从i的2倍开始，三倍，四倍。。。都不可能是质数
                    for (int j = 2 * i; j < n; j = j + i) {
                        isPrim[j] = false;
                    }
                }
            }
            int res = 0;
            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    res++;
                }
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}