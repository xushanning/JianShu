package com.xu.module.algorithm.medium;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/23.
 * 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class M5 {
    @Test
    public void test() {
        PrintUtil.print(handle("cbbd"));

    }

    /**
     * 从两边扩散
     *
     * @param data
     * @return
     */
    private String handle(String data) {
        if (data.length() == 0) {
            return data;
        }
        int maxLength = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < data.length(); i++) {
            //奇数
            int ll = i - 1;
            int rr = i + 1;
            while (ll >= 0 && rr < data.length() && data.charAt(ll) == data.charAt(rr)) {
                int length = rr - ll + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = ll;
                    end = rr;
                }
                ll--;
                rr++;
            }
            //偶数
            ll = i;
            rr = i + 1;
            while (rr < data.length() && data.charAt(ll) == data.charAt(rr)) {
                int length = rr - ll + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = ll;
                    end = rr;
                }
                ll--;
                rr++;
            }

        }
        return data.substring(start, end + 1);
    }


}
