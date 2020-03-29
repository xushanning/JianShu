package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 输入：a="101000" b="101"
 */
public class E67 {
    @Test
    public void test() {
        PrintUtil.print(getSum("11", "1"));

    }

    private String getSum(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();
        //保证a比b长
        if (aLength < bLength) {
            return getSum(b, a);
        }
        StringBuilder builder = new StringBuilder();
        int c = 0;
        int j = bLength - 1;
        int maxLength = Math.max(aLength, bLength);

        for (int i = maxLength - 1; i > -1; --i) {

        }
        return builder.toString();
    }
}
