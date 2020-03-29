package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 */
public class E38 {
    @Test
    public void test() {
        PrintUtil.print(handle(5));

    }

    private String handle(int num) {
        if (num == 1) {
            return "1";
        }
        String last = handle(num - 1);

        return getNextString(last);
    }

    //双重递归
    private String getNextString(String last) {
        if (last.length() == 0) {
            return "";
        }
        int count = getRepeatCount(last);
        return count + "" + last.charAt(0) + getNextString(last.substring(count));
    }

    private int getRepeatCount(String preString) {

        char first = preString.charAt(0);
        int count = 1;
        for (int i = 1; i < preString.length(); i++) {
            if (preString.charAt(i) != first) {
                break;
            }
            count++;
        }
        return count;
    }
}
