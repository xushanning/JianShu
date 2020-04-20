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


package leetcode.editor.cn;

//Java：解码方法
public class P91DecodeWays {
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
        // TO TEST
        solution.numDecodings("12");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if (len <= 1) {
                return len;
            }
            int[] dp = new int[len + 1];
            //状态转移方程  dp[i]=dp[i-1]+{s.subString(i-2,i-1)是否小于等于26}

            //边界
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= len; i++) {
                String ab = s.substring(i - 2, i);
                int abc = Integer.valueOf(ab);
                int index = 0;
                if (abc <= 26) {
                    index = 1;
                }
                dp[i] = dp[i - 1] + index;
            }
            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}