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


package leetcode.editor.cn.round3;

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
        private List<String> res = new ArrayList<>();

        //"23"
        public List<String> letterCombinations(String digits) {
            int len = digits.length();
            if (len == 0) {
                return res;
            }

            dfs(new StringBuilder(), digits);

            return res;
        }

        private void dfs(StringBuilder sb, String next) {
            if (next.length() == 0) {
                res.add(sb.toString());
                return;
            }
            String digit = next.substring(0, 1);
            //abc
            String letters = getValue(digit);
            for (int i = 0; i < letters.length(); i++) {
                //做选择
                sb.append(letters.charAt(i));
                //下钻从第一个开始到最后截取
                dfs(sb, next.substring(1));
                //回溯
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private String getValue(String digit) {
            switch (digit) {
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