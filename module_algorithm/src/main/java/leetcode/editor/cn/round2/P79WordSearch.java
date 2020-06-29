//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package leetcode.editor.cn.round2;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String word;
        private char[][] board;
        //四个方向
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        private boolean[][] marked;
        int m;
        int n;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0 || board[0].length == 0 || word.length() == 0) {
                return false;
            }
            n = board[0].length;
            this.word = word;
            this.board = board;
            marked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int start) {
            boolean flag = word.charAt(start) == board[i][j];
            //结束循环条件
            if (start == word.length() - 1) {
                return flag;
            }
            if (flag) {
                marked[i][j] = true;
                //四个方向
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (isInArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }

        private boolean isInArea(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}