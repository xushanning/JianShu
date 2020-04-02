package com.xu.module.algorithm.medium;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 每次只能向下或者向右移动一步。
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class M64 {
    @Test
    public void test() {
        int[][] data = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        PrintUtil.print(getMin(data));

    }

    //状态转移方程：dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+array[i][j]
    private int getMin(int[][] data) {
        //第一步还是异常处理
        if (data.length == 0) {
            return 0;
        }
        int row = data.length;
        int column = data[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = data[0][0];
        for (int i = 1; i < column; i++) {
            //第一行的dp值
            dp[0][i] = dp[0][i - 1] + data[0][i];
        }
        return 0;
    }
}
