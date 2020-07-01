//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> dp = new ArrayList<>();
            if (numRows <= 0) {
                return dp;
            }
            //动态规划
            //
            List<Integer> first = new ArrayList<>();
            first.add(1);
            dp.add(first);
            for (int i = 2; i < numRows+1; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> preRow = dp.get(i - 2);
                row.add(1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(preRow.get(j) + preRow.get(j - 1));
                }
                row.add(1);
                dp.add(row);
            }

            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}