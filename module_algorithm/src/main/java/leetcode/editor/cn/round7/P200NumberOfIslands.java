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
// 👍 843 👎 0


package leetcode.editor.cn.round7;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[][] grid;
        private int row;
        private int column;
        private boolean[][] visited;
        private int[][] direction;

        public int numIslands(char[][] grid) {
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
            row = grid.length;
            if (row == 0 || grid[0].length == 0) {
                return 0;
            }
            column = grid[0].length;
            this.grid = grid;
            visited = new boolean[row][column];
            direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(int i, int j) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newI = i + direction[k][0];
                int newJ = j + direction[k][1];
                if (isInArea(newI, newJ) && !visited[newI][newJ] && grid[newI][newJ] == '1') {
                    dfs(newI, newJ);
                }
            }
        }

        private boolean isInArea(int i, int j) {
            return i >= 0 && i < row && j >= 0 && j < column;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}