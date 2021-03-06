//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划


package leetcode.editor.cn.round1;

//Java：不同路径 II
public class P63UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //判断异常
            if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return 0;
            }
            //如果左上角的点，就有障碍，那么所有的路径都是0
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            //临界点
            dp[0][0] = 1;
            for (int i = 1; i < m; i++) {
                //如果这个节点有障碍，那么整个路径就废了，如果没有，就是上个点的
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}