//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1251 👎 0


package leetcode.editor.cn;

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