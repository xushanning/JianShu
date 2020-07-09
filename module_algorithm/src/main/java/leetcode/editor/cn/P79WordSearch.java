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
// 👍 470 👎 0


package leetcode.editor.cn;

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
        private int m, n;
        private int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        private boolean marked[][];

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0 || board[0].length == 0 || word.length() == 0) {
                return false;
            }
            this.n = board[0].length;
            this.board = board;
            this.word = word;
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
            if (start == word.length() - 1) {
                //说明是已经匹配到最后一个char了
                return flag;
            }
            //只有匹配到才能往下走
            if (flag) {
                marked[i][j] = true;
                //往四个方向分别寻找，并且不能往已经用到的
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (isInArea(newX, newY) && !marked[newX][newY]) {
                        //说明可以下钻
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                marked[i][j] = false;
            }
            return false;
        }

        private boolean isInArea(int i, int j) {
            return i < m && j < n && i >= 0 && j >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}