package com.xu.module.algorithm.easy;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class E88 {
    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, 3);

    }

    private void merge(int[] num1, int m, int[] num2, int n) {
        int i = m - 1, j = n - 1;
        int idx = num1.length - 1;
        while (i >= 0 && j >= 0) {
            if (num1[i] > num2[j]) {
                num1[idx--] = num1[i--];
            } else {
                num1[idx--] = num2[j--];
            }
        }
        //todo 未完成
    }
}
