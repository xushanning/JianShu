//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 455 👎 0


package leetcode.editor.cn.all;

//Java：岛屿的最大面积
public class P695MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695MaxAreaOfIsland().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int m;
        private int n;
        private int[][] grid;
        private int[][] direction;


        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            if (m == 0 || grid[0].length == 0) {
                return 0;
            }
            n = grid[0].length;
            this.grid = grid;
            direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, dfs(i, j));
                    }
                }
            }
            return max;
        }

        private int dfs(int i, int j) {
            int num = 1;
            //将已经遍历过的置成0
            grid[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                int newI = i + direction[k][0];
                int newJ = j + direction[k][1];
                if (inArea(newI, newJ) && grid[newI][newJ] == 1) {
                    num += dfs(newI, newJ);
                }
            }
            return num;
        }

        private boolean inArea(int i, int j) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}