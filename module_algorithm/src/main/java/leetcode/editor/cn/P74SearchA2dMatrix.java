//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 271 👎 0


package leetcode.editor.cn;

//Java：搜索二维矩阵
public class P74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
            int m = matrix.length;
            if (m == 0 || matrix[0].length == 0) {
                return false;
            }
            int n = matrix[0].length;
            int len = m * n;
            int left = 0;
            int right = len - 1;
            //因为要判断的是否存在，不一定存在，所以要小于等于，这样会在循环体内，把所有的数都进行判断
            //如果只是小于，那么跳出循环的条件是left==right，那么在循环体外还要判断一次这个位置的数是不是target
            while (left <= right) {
                int mid = left + (right - left) / 2;
                //第几行,这里有个坑，行和列都要除n，当时这里除m了。。。
                int row = mid / n;
                //第几列
                int column = mid % n;
                int num = matrix[row][column];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    //缩小有边界
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}