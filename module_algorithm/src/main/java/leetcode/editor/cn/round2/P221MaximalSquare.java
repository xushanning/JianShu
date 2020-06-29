//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


package leetcode.editor.cn.round2;

//Java：最大正方形
public class P221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            //判断异常情况
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
            int maxLength = 0;
            //本题的状态转移方程可以通过绘制一个二维图去推导， dp[i][j]=min{dp[i-1][j],min[i][j-1],min[i-1][j-1]}+1
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        }
                        //更新maxLength
                        maxLength = Math.max(maxLength, dp[i][j]);
                    }
                }
            }
            return maxLength * maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}