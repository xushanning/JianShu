//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 820 👎 0


package leetcode.editor.cn.round5;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        solution.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //表示是否已经用过
        private boolean[][] search;
        private char[][] grid;
        private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private int m;
        private int n;

        public int numIslands(char[][] grid) {
            m = grid.length;
            if (m == 0 || grid[0].length == 0) {
                return 0;
            }
            n = grid[0].length;
            search = new boolean[m][n];
            this.grid = grid;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //没有使用过&&这个地方是个陆地，那么肯定存在一个岛屿
                    if (!search[i][j] && grid[i][j] == '1') {
                        res++;
                        dfs(i, j);
                    }
                }
            }
            return res;
        }

        private void dfs(int i, int j) {
            search[i][j] = true;
            for (int k = 0; k < 4; k++) {
                //{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
                int newI = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newI, newY) && !search[newI][newY] && grid[newI][newY] == '1') {
                    dfs(newI, newY);
                }
            }
        }

        private boolean inArea(int i, int j) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}