package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class E70 {
    @Test
    public void test() {
        PrintUtil.print(getCount(8));
        PrintUtil.print(getCount1(8));
    }

    private int getCount(int floor) {
        if (floor <= 2) {
            return 1;
        }
        return getCount(floor - 1) + getCount(floor - 2);
    }

    /**
     * 动态规划解法
     * dynamic programming
     * DP
     *
     * @param floor 楼梯层数
     * @return
     */
    private int getCount1(int floor) {
        if (floor == 0) {
            return 0;
        }
        if (floor == 1 || floor == 2) {
            return 1;
        }

        int[] array = new int[floor + 1];
        for (int i = 1; i <= floor; i++) {
            if (i == 1 || i == 2) {
                array[i] = 1;
            } else {
                array[i] = array[i - 1] + array[i - 2];
            }
        }
        return array[floor];
    }
}