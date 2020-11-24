//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1436 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(res, n, new StringBuilder(), 0, 0);
            return res;
        }

        private void dfs(List<String> cur, int n, StringBuilder sb, int left, int right) {
            if (sb.length() == n * 2) {
                cur.add(sb.toString());
                return;
            }
            if (left < n) {
                sb.append('(');
                dfs(cur, n, sb, left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left) {
                sb.append(')');
                dfs(cur, n, sb, left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}