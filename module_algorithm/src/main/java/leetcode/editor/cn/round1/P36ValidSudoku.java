//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表


package leetcode.editor.cn.round1;

import java.util.HashMap;
import java.util.Map;

//Java：有效的数独
public class P36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //挺好理解的，记住思路就ok
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Integer>[] rows = new HashMap[9];
            Map<Integer, Integer>[] columns = new HashMap[9];
            Map<Integer, Integer>[] boxes = new HashMap[9];
            //一共27个哈希表，共存储9行、9列、9小3x3情况
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashMap<>();
                columns[i] = new HashMap<>();
                boxes[i] = new HashMap<>();
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char s = board[i][j];
                    if (s != '.') {
                        //核心(反正我自己没推导出来)
                        int boxIndex = (i / 3) * 3 + j / 3;
                        int n = (int) s;
                        //把n的位置上加1
                        rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                        columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                        boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                        //检查 前面加了后，至少为1
                        if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                            return false;
                        }
                    }

                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}