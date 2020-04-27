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
            //其中第 i  个元素表示以下标为 i  的字符结尾的最长有效子字符串的长度
            int[] dp = new int[len];
            //状态转移方程想不到
            int maxLen = 0;
            for (int i = 1; i < len; i++) {
                //只考虑当前")"的情况，因为如果是"("，那么dp[i]=0
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        //()这种的
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        //(())这种的
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }

            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}