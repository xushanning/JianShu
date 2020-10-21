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
// 👍 657 👎 0


package leetcode.editor.cn;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
        char[][] aa = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        solution.exist(aa, "ABCCED");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[][] board;
        private String word;
        private boolean[][] flag;
        private int m;
        private int n;
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        public boolean exist(char[][] board, String word) {
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
            if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
                return false;
            }
            this.board = board;
            this.word = word;
            m = board.length;
            n = board[0].length;

            //标记i j是否已经用过了
            flag = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (help(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean help(int i, int j, int start) {
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }

            if (word.charAt(start) == board[i][j]) {
                flag[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    //这里两个条件不能反过来，查了半天。。
                    if (inBound(newX, newY) && !flag[newX][newY]) {
                        if (help(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
            }
            flag[i][j] = false;

            return false;
        }

        //是否在范围内
        private boolean inBound(int i, int j) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}