package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/22.
 */
public class E28 {
    /**
     * 实现 strStr()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 目前来说最简单的一道
     */
    @Test
    public void test() {
        PrintUtil.print(handle("hello", "elo"));
    }

    private int handle(String data, String needle) {
        int dataLength = data.length();
        int needLength = needle.length();
        int i = 0;
        while (needLength + i <= dataLength) {
            if (data.substring(i, i + needLength).equals(needle)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
