//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 626 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int row = matrix.length;
            if (row == 0 || matrix[0].length == 0) {
                return res;
            }
            int column = matrix[0].length;
            boolean[][] used = new boolean[row][column];
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int index = 0;
            int total = row * column;
            int m = 0, n = 0;
            for (int i = 0; i < total; i++) {
                res.add(matrix[m][n]);
                used[m][n] = true;
                int newM = m + direction[index][0];
                int newN = n + direction[index][1];
                if (newM < 0 || newM >= row || newN < 0 || newN >= column || used[newM][newN]) {
                    index = (index + 1) % 4;
                }
                m = m + direction[index][0];
                n = n + direction[index][1];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}