package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;
import org.junit.Test;

/**
 * @author 言吾許
 * 回文数
 */
public class E9 {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 如：121  true  -121 false
     */
    @Test
    public void test() {
        PrintUtil.print(check(12344321));
    }

    /**
     * 第一种方法，将数字转换为字符串
     *
     * @param input 输入
     * @return 是否是回文数
     */
    private boolean check(int input) {
        if (input < 0) {
            return false;
        }
        String data = String.valueOf(input);
        int middle = data.length() / 2;
        int position = 0;
        while (position != middle) {
            if (data.charAt(position) != data.charAt(data.length() - 1 - position)) {
                PrintUtil.print(position);
                return false;
            }
            position++;
        }
        return true;
    }

}
