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


package leetcode.editor.cn.round3;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String word;
        private int m, n;
        private char[][] board;
        private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private boolean[][] marked;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            if (m == 0 || board[0].length == 0 || word.length() == 0) {
                return false;
            }
            n = board[0].length;
            marked = new boolean[m][n];
            this.word = word;
            this.board = board;
            //1、双重遍历，把每个字母都起点，看看能不能找到这个单词
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
            boolean flag = board[i][j] == word.charAt(start);
            if (start == word.length() - 1) {
                //如果是最后一个单词，要么是找到，要么是找不到，就看最后一个单词能不能匹配上
                return flag;
            }
            //如果当前能对应上，继续下钻
            if (flag) {
                marked[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + direction[k][0];
                    int newY = j + direction[k][1];
                    //在区域内，并且新的坐标没有用过
                    if (inArea(newX, newY) && !marked[newX][newY]) {
                        //这次将这里写成这种了：return dfs(newX, newY, start + 1);
                        //这样只尝试一次就确定是true还是false了
                        if (dfs(newX, newY, start + 1)) {
                            return true;
                        }
                    }
                }
                //用完后重新设置为没有用过
                marked[i][j] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}