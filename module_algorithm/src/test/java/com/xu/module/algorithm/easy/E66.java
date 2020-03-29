package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class E66 {
    @Test
    public void test() {
        int[] data = getNextArray(new int[]{9, 9, 9});
        for (int i = 0; i < data.length; i++) {
            PrintUtil.print(data[i]);
        }
    }

    //很巧妙的设计
    private int[] getNextArray(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == 9) {
                data[i] = 0;
            } else {
                data[i] += 1;
                return data;
            }

        }
        int[] newArray = new int[data.length + 1];
        newArray[0] = 1;
        return newArray;
    }
}
