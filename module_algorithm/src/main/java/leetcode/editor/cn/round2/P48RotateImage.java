//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组


package leetcode.editor.cn.round2;

//Java：旋转图像
public class P48RotateImage {
    public static void main(String[] args) {
        Solution solution = new P48RotateImage().new Solution();
        // TO TEST
        int[][] test1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(test1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int n = matrix.length;
            //推导公式：顺时针转换前->转换后：(i,j)->(j,n-i-1)
            //逆时针转换 [x][y] --> [n - 1 - y][x]
            //可以一组进行旋转
            //[0][0] --> [0][3]
            //[0][3] --> [3][3]
            //[3][3] --> [3][0]
            //[3][0] --> [0][0]


            //实现不是按照上面来的。。。只能死记硬背了
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}