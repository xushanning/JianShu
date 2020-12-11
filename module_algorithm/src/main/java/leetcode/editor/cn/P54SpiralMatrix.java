//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 560 👎 0


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
            int m = matrix.length;
            List<Integer> res = new ArrayList<>();
            if (m == 0 || matrix[0].length == 0) {
                return res;
            }
            int n = matrix[0].length;
            int x = 0;
            int y = 0;
            int index = 0;

            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] used = new boolean[m][n];
            int total = m * n;
            for (int i = 0; i < total; i++) {
                res.add(matrix[x][y]);
                used[x][y] = true;
                int newX = x + direction[index][0];
                int newY = y + direction[index][1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || used[newX][newY]) {
                    index = (index + 1) % 4;
                }
                x = x + direction[index][0];
                y = y + direction[index][1];
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}