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


package leetcode.editor.cn.round3;

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
            if (len < 2) {
                return 0;
            }
            int max = 0;
            //状态转移方程：dp=
            int[] dp = new int[len];
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                    } else {

                    }
                }
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}