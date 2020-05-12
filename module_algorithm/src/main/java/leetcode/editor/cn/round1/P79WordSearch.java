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


package leetcode.editor.cn.round1;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 用来存储是否这个点已经标记过了
         */
        private boolean[][] marked;
        private int m;
        private int n;
        private String word;
        private char[][] board;
        //四个方向
        private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        /**
         * 有点晕
         *
         * @param board
         * @param word
         * @return
         */
        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0) {
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
            //条件:最后一个字母了，如果最后一个字母，能和i j对上，return true
            if (start == word.length() - 1) {
                return board[i][j] == word.charAt(start);
            }

            if (board[i][j] == word.charAt(start)) {
                marked[i][j] = true;
                //做判断
                //下钻
                //考虑四个方向上
                for (int k = 0; k < 4; k++) {
                    //{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    if (isInArea(newX, newY) && !marked[newX][newY]) {
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                //回溯 把这个位置置成未标记过，表示，后续的可以从别的方向再来这个里
                marked[i][j] = false;
            }
            //两种情况
            // ①如果字母直接不合work相同，那么直接返回false，不匹配
            //②匹配，但是下钻不匹配，那么也返回false
            return false;

        }

        private boolean isInArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}