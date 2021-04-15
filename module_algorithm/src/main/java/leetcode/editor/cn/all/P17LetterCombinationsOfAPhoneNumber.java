//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 1019 👎 0


package leetcode.editor.cn.all;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int len;
        private List<String> res;

        public List<String> letterCombinations(String digits) {
            len = digits.length();
            res = new ArrayList<>();
            if (len == 0) {
                return res;
            }


            dfs(new StringBuilder(), digits);
            return res;
        }

        private void dfs(StringBuilder sb, String lack) {
            if (sb.length() == len) {
                res.add(sb.toString());
                return;
            }
            String digit = lack.substring(0, 1);
            String letters = getLetter(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                sb.append(letter);
                dfs(sb, lack.substring(1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private String getLetter(String c) {
            switch (c) {
                case "2":
                    return "abc";
                case "3":
                    return "def";
                case "4":
                    return "ghi";
                case "5":
                    return "jkl";
                case "6":
                    return "mno";
                case "7":
                    return "pqrs";
                case "8":
                    return "tuv";
                case "9":
                    return "wxyz";
                default:
                    return "";
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}