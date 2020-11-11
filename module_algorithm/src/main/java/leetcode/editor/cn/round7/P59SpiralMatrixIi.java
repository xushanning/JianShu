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
// 👍 257 👎 0


package leetcode.editor.cn.round7;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n < 1) {
                return null;
            }
            int[][] res = new int[n][n];
            int total = n * n;
            int row = 0, column = 0;
            boolean[][] visited = new boolean[n][n];
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int index = 0;
            // 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
            for (int i = 1; i <= total; i++) {
                res[row][column] = i;
                visited[row][column] = true;
                int newRow = row + direction[index][0];
                int newColumn = column + direction[index][1];
                if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= n || visited[newRow][newColumn]) {
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