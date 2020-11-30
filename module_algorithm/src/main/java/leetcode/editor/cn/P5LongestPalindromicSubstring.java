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
// 👍 2950 👎 0


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
// 输入: "babad"
//输出: "bab"
            int len = s.length();
            if (len == 0) {
                return "";
            }
            //定义dp为从j到i是否为回文串
            boolean[][] dp = new boolean[len][len];
            int max = 0, left = 0, right = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        if (i - j > max) {
                            left = j;
                            right = i;
                            max = i - j;
                        }
                    }
                }
            }
            return s.substring(left, right + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}