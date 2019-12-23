package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/22.
 */
public class E27 {
    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
     * <p>
     * 第一次写的算法很烂
     */
    @Test
    public void test() {
        int nums[] = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        remove(nums, 2);
    }

    private int remove(int[] nums, int tag) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //感觉还是双指针
            if (nums[j] != tag) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int num : nums) {
            PrintUtil.print(num);
        }

        return i;
    }
}
