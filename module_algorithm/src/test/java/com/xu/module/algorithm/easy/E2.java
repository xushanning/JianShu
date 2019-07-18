package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;
import org.junit.Test;

/**
 * @author 言吾許
 */
public class E2 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 123  321
     * -123   -321
     * 120  21
     */
    @Test
    public void test() {
        PrintUtil.print(getInt(120));
    }


    private int getInt(int num) {
        int result = 0;
        while (num != 0) {
            int c = num % 10;
            //过大的话，会造成溢出，这里没有处理
            result = result * 10 + c;
            num /= 10;
        }
        return result;
    }
}
