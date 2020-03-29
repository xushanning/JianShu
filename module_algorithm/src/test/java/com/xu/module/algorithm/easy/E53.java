package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class E53 {
    @Test
    public void test() {
        int[] data = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        PrintUtil.print(getMax(data));
    }

    private int getMax(int[] data) {
        if (data.length == 1) {
            return data[0];
        }
        int max = data[0];
        int current = 0;

        for (int i = 0; i <= data.length; i++) {
            current = 0;
            for (int j = i; j < data.length; j++) {
                current += data[j];
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
