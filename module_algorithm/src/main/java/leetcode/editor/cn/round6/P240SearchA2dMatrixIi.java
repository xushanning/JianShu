//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 二分查找 分治算法 
// 👍 461 👎 0


package leetcode.editor.cn.round6;

//Java：搜索二维矩阵 II
public class P240SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P240SearchA2dMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
            int m = matrix.length;

            if (m == 0 || matrix[0].length == 0) {
                return false;
            }
            int row = m - 1;
            int n = matrix[0].length;
            int column = 0;
            while (row >= 0 && column < n ) {
                int sum = matrix[row][column];
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    row--;
                } else {
                    column++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}