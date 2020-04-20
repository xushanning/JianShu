//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

//Java：最长有效括号
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int len = s.length();
            //异常判断
            if (len < 2) {
                return 0;
            }
            int[] dp = new int[len];
            dp[0] = 0;

            // int maxLen = 0;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }

//                if (dp[i] > maxLen) {
//                    maxLen = dp[i];
//                }
            }
            return dp[len - 1] * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}