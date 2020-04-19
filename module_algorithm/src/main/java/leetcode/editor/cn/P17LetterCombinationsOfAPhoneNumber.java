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


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> res = new ArrayList<>();
        private Map<String, String> data;

        //todo 这种方法，我自己想不出来
        public List<String> letterCombinations(String digits) {
            data = new HashMap<>();
            data.put("2", "abc");
            data.put("3", "def");
            data.put("4", "ghi");
            data.put("5", "jkl");
            data.put("6", "mno");
            data.put("7", "pqrs");
            data.put("8", "tuv");
            data.put("9", "wxyz");
            //异常判断
            if (digits.length() != 0) {
                dfs("", digits);
            }
            return res;
        }

        //23
        private void dfs(String combination, String next) {
            if (next.length() == 0) {
                res.add(combination);
                return;
            }
            //next中的第一个数字
            String digit = next.substring(0, 1);
            // 把数字换算成字母
            String letters = data.get(digit);


            for (int i = 0; i < letters.length(); i++) {
                //做判断:a
                String letter = letters.substring(i, i + 1);
                //递归 a 23中除去当前2的剩下的，也就是3
                dfs(combination + letter, next.substring(1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}