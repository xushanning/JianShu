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
// 👍 1393 👎 0


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

        // 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(new StringBuilder(), n, res, 0, 0);
            return res;
        }

        private void dfs(StringBuilder sb, int n, List<String> res, int open, int close) {
            if (sb.length() == 2 * n) {
                res.add(sb.toString());
                return;
            }
            if (open < n) {
                sb.append("(");
                dfs(sb, n, res, open + 1, close);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (open > close) {
                sb.append(")");
                dfs(sb, n, res, open, close + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}