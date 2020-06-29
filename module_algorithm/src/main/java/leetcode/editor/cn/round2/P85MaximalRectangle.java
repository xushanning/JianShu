//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划


package leetcode.editor.cn.round2;

import java.util.Arrays;

import leetcode.editor.cn.PrintUtil;

//Java：最大矩形
public class P85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST

        char[][] data = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int res = solution.maximalRectangle(data);
        PrintUtil.print(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://zhuanlan.zhihu.com/p/102357584
        public int maximalRectangle(char[][] matrix) {
            int res = 0;
            int m = matrix.length;
            if (m == 0 || matrix[0].length == 0) {
                return res;
            }
            int n = matrix[0].length;
            //第 n个点往上走，1组成的最高的高度
            int[] height = new int[n];
            //右边界
            int[] right = new int[n];
            //左边界
            int[] left = new int[n];
            //右边界全部为n
            Arrays.fill(right, n);
            for (int i = 0; i < m; i++) {
                //两个指针
                int curLeft = 0, curRight = n;
                //更新最高值
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }

                //TODO 更新左边界需要加深理解，用的很巧妙
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        left[j] = Math.max(left[j], curLeft);
                    } else {
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }

                //TODO 更新右边界需要加深理解，用的很巧妙
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], curRight);
                    } else {
                        right[j] = n;
                        curRight = j;
                    }
                }
                //更新面积
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, (right[j] - left[j]) * height[j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}