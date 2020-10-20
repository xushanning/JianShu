//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2815 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len == 0) {
                return "";
            }
            // 输入: "babad"
            //输出: "bab"
            //定义dp为第j到i个字符，是否为回文字符串，那么状态转移方程为：
            boolean[][] dp = new boolean[len][len];
            int l = 0, r = 0, max = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    //aba第二个条件
                    if (s.charAt(i) == s.charAt(j) && (dp[j + 1][i - 1] || i - j <= 2)) {
                        dp[j][i] = true;
                        if (i - j > max) {
                            max = i - j;
                            l = j;
                            r = i;
                        }
                    }
                }
            }
            return s.substring(l, r+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}