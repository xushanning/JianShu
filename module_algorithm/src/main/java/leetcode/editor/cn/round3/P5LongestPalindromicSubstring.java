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


package leetcode.editor.cn.round3;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        solution.longestPalindrome("babad");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            //babad
            int len = s.length();
            if (len == 0) {
                return "";
            }
            //状态转移方程dp[i][j]从i到j是否是回文串
            //dp[i][j]=dp[i-1][j+1] && s[i]==s[j]
            boolean[][] dp = new boolean[len][len];
            //  dp[0][0] = true;
            int maxLen = 0;
            int left = 0;
            int right = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        if (i - j + 1 > maxLen) {
                            maxLen = i - j + 1;
                            left = j;
                            right = i;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}