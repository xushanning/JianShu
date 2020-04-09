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


package leetcode.editor.cn;

//Java：最大子序和
public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
        solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //判异常
            if (nums.length == 0) {
                return 0;
            }

            //动态转移方程推导：以i结尾的所有子数组最大和的和为max{第i项，以i结尾的所有子数组最大和+i项}
            //dp[i]:以i结尾的所有子数组的最大值
            //所以动态转移方程为：dp[i]=max{nums[i],dp[i-1]+nums[i]}
            int n = nums.length;
            int[] dp = new int[n];
            //初始化边界值
            dp[0] = nums[0];
            int max = nums[0];
            //其实这里可以不够用dp数组，因为前面的dp[i]只使用了一次，可以类似爬楼梯，用一个变量就可以
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}