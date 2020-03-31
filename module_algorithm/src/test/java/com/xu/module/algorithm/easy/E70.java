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
 * <p>
 * <p>
 * 漫画讲得好
 * https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg
 */
public class E70 {
    @Test
    public void test() {
        PrintUtil.print(getCount(8));
        PrintUtil.print(getCount1(8));
        PrintUtil.print(getCount2(8));
    }

    private int getCount(int floor) {
        if (floor <= 2) {
            return 1;
        }
        return getCount(floor - 1) + getCount(floor - 2);
    }

    /**
     * 备忘录解法
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

    /**
     * 动态规划
     * 某一个数量只和前两个状态有关，不用像备忘录一样，保留所有的状态
     * 进一步降低时间复杂度
     * 这才是这正的动态规划
     *
     * @param floor 楼梯层数
     * @return
     */
    private int getCount2(int floor) {
        if (floor == 0) {
            return 0;
        }
        if (floor == 1 || floor == 2) {
            return 1;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i < floor; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}