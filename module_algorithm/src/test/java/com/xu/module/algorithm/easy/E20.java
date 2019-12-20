package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        PrintUtil.print(isValid("()[]{}"));
    }

    private boolean isValid(String data) {
        char[] cData = data.toCharArray();
        if (data.length() % 2 == 1) {
            return false;
        }

        int half = data.length() / 2;
        for (int i = 0; i < half; i++) {
            char a = cData[i];
            char b = cData[data.length() - i - 1];
            switch (a) {
                case '(':
                    if (b != ')') {
                        return false;
                    }
                    break;
                case '[':
                    if (b != ']') {
                        return false;
                    }
                    break;
                case '{':
                    if (b != '}') {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        return true;
    }

}
