//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 248 👎 0


package leetcode.editor.cn.round5;

//Java：反转字符串中的单词 III
public class P557ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
            int len = s.length();
            if (len == 0) {
                return s;
            }
            String[] ss = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ss.length; i++) {
                sb.append(reverse(ss[i]));
                if (i != ss.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        private String reverse(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                stringBuilder.append(c);
            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}