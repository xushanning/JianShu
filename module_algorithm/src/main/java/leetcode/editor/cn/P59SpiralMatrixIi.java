//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 256 👎 0


package leetcode.editor.cn;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //这个题和54题可以用同样的解法
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int total = n * n;
            int row = 0, column = 0;
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] used = new boolean[n][n];
            int index = 0;
            for (int i = 1; i <= total; i++) {
                used[row][column] = true;
                res[row][column] = i;
                int newRow = row + direction[index][0];
                int newColumn = column + direction[index][1];
                if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= n || used[newRow][newColumn]) {
                    index = (index + 1) % 4;
                }
                row += direction[index][0];
                column += direction[index][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}