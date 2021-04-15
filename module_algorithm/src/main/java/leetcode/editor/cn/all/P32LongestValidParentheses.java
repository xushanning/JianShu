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
// 👍 1092 👎 0


package leetcode.editor.cn.all;

//Java：最长有效括号
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
// 输入: "(()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
            int len = s.length();
            if (len < 2) {
                return 0;
            }
            //定义dp为以i结尾的最长括号长度
            int[] dp = new int[len];
            int max = 0;
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    } else if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        //(()()) 比如这个例子，i - dp[i - 1] - 1 找的位置就是第一个
                        //()(()()) i - dp[i - 1] - 2 就是看前两个是否能组成
                        dp[i] = i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 : dp[i - 1] + 2;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}