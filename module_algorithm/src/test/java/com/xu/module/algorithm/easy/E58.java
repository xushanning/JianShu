package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class E58 {

    @Test
    public void test() {
        PrintUtil.print(getWordLength("Hello World"));

    }

    private int getWordLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        //从后往前遍历。。。。。
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            } else if (s.charAt(i) == ' ' && result != 0) {
                return result;
            }
        }
        return result;

    }
}
