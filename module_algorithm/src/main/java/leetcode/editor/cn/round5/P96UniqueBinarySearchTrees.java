//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 862 👎 0


package leetcode.editor.cn.round5;

//Java：不同的二叉搜索树
public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            //n个节点的二叉树个数是G(n) f(i)是以i为根的二叉树的个数，那么
            //G(n)=f(1)+f(2)+....+f(n)
            //f(i)=G(i-1)*G(n-i)
            //综合上述两个公式得出：G(n)=G(0)*G(n-1)+G(1)*G(n-2)+......+G(n-1)*G(0)
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            //dp[5]=dp[0]*dp[4]+dp[1]*dp[3]+dp[2]*dp[2]+dp[3]*dp[2]+dp[4]*dp[0]
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    //计算出dp[i]
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}