package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * [2,3,8,9,12] 1
 */
public class E35 {
    @Test
    public void test() {
        //int[] array = new int[]{1, 3, 5, 6};
        //int[] array = new int[]{2,3,8,9,12};
        //int[] array = new int[]{2,3,8,9,12};
        int[] array = new int[]{1, 3, 5, 6};
        PrintUtil.print(getInsertPosition(array, 6));
    }

    private int getInsertPosition(int[] array, int targetNum) {
        //两种情况：
        //①[2,3,8,9,12] 1
        //②[2,3,8,9,12] 2
        if (array[0] >= targetNum) {
            return 0;
        }
        //[2,3,8,9,12] 4
        for (int i = 1; i < array.length; i++) {
            if (array[i] == targetNum) {
                return i;
            }
            if (array[i] > targetNum && array[i - 1] < targetNum) {
                return i;
            }
        }
        return array.length;
    }
}
