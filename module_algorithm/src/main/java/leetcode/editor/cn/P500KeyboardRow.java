//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 109 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：键盘行
public class P500KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new P500KeyboardRow().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findWords(String[] words) {

            String[] res = new String[words.length];
            int index = 0;
            String s1 = "qwertyuiopQWERTYUIOP", s2 = "asdfghjklASDFGHJKL", s3 = "zxcvbnmZXCVBNM";

            for (String s : words) {
                int len1 = 0, len2 = 0, len3 = 0, len = s.length();
                for (int i = 0; i < len; i++) {
                    char c = s.charAt(i);
                    if (s1.indexOf(c) != -1) {
                        len1++;
                    }
                    if (s2.indexOf(c) != -1) {
                        len2++;
                    }
                    if (s3.indexOf(c) != -1) {
                        len3++;
                    }
                }
                if (len == len1 || len == len2 || len == len3) {
                    res[index++] = s;
                }
            }
            return Arrays.copyOfRange(res, 0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}