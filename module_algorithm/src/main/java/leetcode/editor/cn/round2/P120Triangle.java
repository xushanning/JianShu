//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//  [2],
//  [3,4],
//  [6,5,7],
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


package leetcode.editor.cn.round2;

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
            //自下而上解决此问题
            //定义状态转移方程dp[i][j]为到达第i，j最小路径
            //那么dp[i][j]=max{dp[i+1][j],dp[i+1][j+1]}
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int dp[][] = new int[m][m];
            //边界条件，最底下的一行
            for (int i = 0; i < n; i++) {
                dp[m - 1][i] = triangle.get(m - 1).get(i);
            }
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