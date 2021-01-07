//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 432 👎 0


package leetcode.editor.cn.round9;

import java.util.ArrayList;
import java.util.List;

//Java：分割回文串
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int len;
        private List<List<String>> res = new ArrayList<>();
        private String s;

        public List<List<String>> partition(String s) {
            len = s.length();
            if (len == 0) {
                return res;
            }
            this.s = s;
            dfs(new ArrayList<>(), 0);
            return res;
        }

        private void dfs(List<String> cur, int start) {
            if (start == len) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = start; i < len; i++) {
                if (!checkPalindrome(start, i)) {
                    continue;
                }
                cur.add(s.substring(start, i + 1));
                dfs(cur, i + 1);
                cur.remove(cur.size() - 1);
            }

        }

        private boolean checkPalindrome(int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}