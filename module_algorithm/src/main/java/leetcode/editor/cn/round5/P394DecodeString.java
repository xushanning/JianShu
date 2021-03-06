//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 546 👎 0


package leetcode.editor.cn.round5;

import java.util.Stack;

//Java：字符串解码
public class P394DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
// 输入：s = "3[a2[c]]"
            //3[a]2[bc]
//输出："accaccacc"
            int multi = 0;
            Stack<Integer> multiStack = new Stack<>();
            Stack<StringBuilder> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    multi = multi * 10 + c - '0';
                } else if (c == '[') {
                    multiStack.add(multi);
                    stack.add(sb);
                    //重置
                    multi = 0;
                    sb = new StringBuilder();
                } else if (Character.isLetter(c)) {
                    sb.append(c);
                } else {
                    //碰到]
                    StringBuilder temp = stack.pop();
                    int count = multiStack.pop();
                    for (int i = 0; i < count; i++) {
                        temp.append(sb);
                    }
                    sb = temp;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}