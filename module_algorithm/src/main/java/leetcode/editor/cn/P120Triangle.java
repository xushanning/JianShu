//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


package leetcode.editor.cn;

import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            //判断异常
            if (triangle.size() == 0) {
                return 0;
            }
            int m = triangle.size();
            //本题要自下而上!!!!!!!!!重要
            //讲得好：https://www.bilibili.com/video/BV1V7411A7LK?from=search&seid=15891718507482217659
            int[][] dp = new int[m][m];
            //状态转移方程：dp[i][j]=min{dp[i+1][j],dp[i+1][j+1]}+triangle[i][j]
            //初始化，是最后一行
            List<Integer> last = triangle.get(m - 1);
            for (int i = 0; i < last.size(); i++) {
                dp[m - 1][i] = last.get(i);
            }
            //最后一行已经初始化了，从倒数第二行开始循环
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }

            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}