//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package leetcode.editor.cn.round3;

//Java：最大子序和
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //[-2,1,-3,4,-1,2,1,-5,4]   [4,-1,2,1] 的和最大，为 6
            //第一眼就是动态规划
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            //状态转移方程
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}