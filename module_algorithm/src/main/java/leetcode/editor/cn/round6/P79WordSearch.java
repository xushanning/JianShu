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
// 👍 663 👎 0


package leetcode.editor.cn.round6;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[][] board;
        private String word;
        private int m;
        private int n;
        private boolean[][] searched;
        private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0 || board[0].length == 0) {
                return false;
            }
            n = board[0].length;
            this.word = word;
            searched = new boolean[m][n];
            this.board = board;
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
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }
            if (board[i][j] == word.charAt(start)) {
                searched[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    //又忘了i+  j+
                    int newI = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (inArea(newI, newY) && !searched[newI][newY]) {
                        if (dfs(newI, newY, start + 1)) {
                            return true;
                        }
                    }
                }
            }
            searched[i][j] = false;
            return false;
        }

        private boolean inArea(int i, int j) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }

        //[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
    }
//leetcode submit region end(Prohibit modification and deletion)

}