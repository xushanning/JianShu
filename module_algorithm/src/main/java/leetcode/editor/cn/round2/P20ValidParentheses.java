//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package leetcode.editor.cn.round2;

import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        solution.isValid("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            int len = s.length();


            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    //防止这种 ))因为前面的if不走，所以stack为空，那么下面的肯定报异常
                    if (stack.empty()) {
                        return false;
                    }
                    if (c == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (c == '}' && stack.pop() != '{') {
                        return false;
                    }
                    if (c == ']' && stack.pop() != '[') {
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}