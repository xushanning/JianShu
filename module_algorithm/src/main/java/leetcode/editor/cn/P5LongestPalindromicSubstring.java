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
            if (len <= 1) {
                return s;
            }
            //dp 从i到j是否是回文串
            boolean[][] dp = new boolean[len][len];
            int left = 0;
            int right = 0;
            int max = 0;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (dp[j + 1][i - 1] || i - j <= 2)) {
                        dp[j][i] = true;
                        if (i - j + 1 > max) {
                            max = i - j + 1;
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