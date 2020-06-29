//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn.round2;

//Java：解码方法
public class P91DecodeWays {
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        solution.numDecodings("226");
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            //https://www.cnblogs.com/shayue/p/10294475.html
            //22 8
            //定义状态转移方程dp[i]为s前i个字符解码的总数量,那么
            //dp[i]=最后两位小于等于26?dp[i-1]+dp[i-1]:dp[i-1]
            int len = s.length();
            if (len == 0) {
                return 0;
            }
            char[] arr = s.toCharArray();
            if (arr[0] == '0') {
                return 0;
            }
            int[] dp = new int[len + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= len; i++) {
                int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
                //考虑的情况有点多，当时漏了两种。。。。
                if (arr[i - 1] == '0' && arr[i - 2] == '0') {
                    return 0;
                } else if (arr[i - 2] == '0') {
                    dp[i] = dp[i - 1];
                } else if (arr[i - 1] == '0') {
                    if (n > 26) {
                        return 0;
                    }
                    dp[i] = dp[i - 2];
                } else if (n > 26) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }

            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}