package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class E69 {
    @Test
    public void test() {
        PrintUtil.print(getResult(8));
    }

    private int getResult(int data) {
        if (data <= 1) {
            return data;
        }
        boolean flag = false;
        int current = 1;
        for (int i = 1; i < data; i++) {

            if (i * i <= data && (i + 1) * (i + 1) > data) {
                current = i;
                break;
            }
        }
        return current;
    }
}
