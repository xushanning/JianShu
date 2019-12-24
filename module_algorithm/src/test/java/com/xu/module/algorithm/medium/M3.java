package com.xu.module.algorithm.medium;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class M3 {
    @Test
    public void test() {
        PrintUtil.print(handle("pwwkew"));
    }

    private int handle(String data) {
        //不重复的数量
        int i = 1;
        //从第几个开始
        int j = 0;
        while (j < data.length()) {
            for (int k = j; k < data.length(); k++) {
                String current = data.substring(j, j + k);
                if (i < current.length()) {
                    i = current.length();
                }
                String next = data.substring(j + k, j + k + 1);
                if (current.contains(next)){
                    break;
                }
            }
            j++;
        }
        return i;
    }


}
