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
// 👍 530 👎 0


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
            int rows = matrix.length;
            List<Integer> res = new ArrayList<>();
            if (matrix == null || rows == 0 || matrix[0].length == 0) {
                return res;
            }
            int columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                res.add(matrix[row][column]);
                visited[row][column] = true;
                int newRow = row + direction[directionIndex][0];
                int newColumn = column + direction[directionIndex][1];
                //判断新的坐标是否合法
                if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns || visited[newRow][newColumn]) {
                    //如果不合法重新计算坐标指向
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += direction[directionIndex][0];
                column += direction[directionIndex][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}