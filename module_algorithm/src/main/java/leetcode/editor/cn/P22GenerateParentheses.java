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
        private List<String> res = new ArrayList<>();
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            backtrack(new StringBuilder(), 0, 0);
            return res;
        }

        //todo 这个递归调用是真的晕，需要再次加强，在纸上画画，会比较清楚
        private void backtrack(StringBuilder sb, int open, int close) {
            //结束循环:括号的数量等于2n
            if (sb.length() == n * 2) {
                res.add(sb.toString());
                return;
            }
            //核心思想：
            //如果左括号数量不大于 nn，我们可以放一个左括号。
            //如果右括号数量小于左括号的数量，我们可以放一个右括号。
            if (open < n) {
                //做判断
                sb.append('(');
                //递归
                backtrack(sb, open + 1, close);
                //回溯
                sb.deleteCharAt(sb.length() - 1);
            }

            if (close < open) {
                //做判断
                sb.append(')');
                //递归
                backtrack(sb, open, close + 1);
                //回溯
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}