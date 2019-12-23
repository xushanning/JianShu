package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

import java.util.Stack;

public class E20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */
    @Test
    public void test() {
       // PrintUtil.print(isValid("()[]{}"));
       PrintUtil.print(isValid("{[]}"));
//        PrintUtil.print(isValid("()"));
    }

    /**
     * 这种算法太流批了~
     * @param data
     * @return
     */
    private boolean isValid(String data) {
        char[] cData = data.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (data.length() % 2 == 1) {
            return false;
        }
        for (char ch : cData) {
            if (ch == '(' || ch == '[' || ch == '{') {
                //压栈
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //pop():移除堆栈顶部的对象，并作为此函数的值返回该对象
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
