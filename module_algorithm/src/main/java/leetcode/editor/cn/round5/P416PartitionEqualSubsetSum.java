//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 571 👎 0


package leetcode.editor.cn.round5;

//Java：分割等和子集
public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return false;
            }
            //[1, 5, 5, 15] sum=26
            //是否能组成两组和一样的，其实就是是否能选取一些数组，和为整个sum的一半
            int sum = 0;
            int max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            //如果和是奇数，那么肯定组不成
            if (sum % 2 == 1) {
                return false;
            }
            //整个就是要组成的数
            int target = sum / 2;
            //最大值都大于一半了，那么肯定组不成
            if (max > target) {
                return false;
            }
            //dp[i][j]为数组[0,i]下标内选取若干个整数之和等于j
            //边界条件：
            //不选取任何数，那么dp[i][0]=true
            //如果只能选一个正整数，那么dp[0][nums[0]]=true
            boolean[][] dp = new boolean[len][target + 1];
            for (int i = 0; i < len; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;


            for (int i = 1; i < len; i++) {
                int num = nums[i];
                for (int j = 1; j <= target; j++) {
                    if (j >= num) {
                        //j>=num,那么nums[i]分为可选，也可不选两种情况，如果不选取，那么dp[i][j] = dp[i - 1][j]
                        //如果选取：那么就看j-nums[i]这个位置，有没有能成的
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                    } else {
                        //如果j<nums[i],则无法选取当前数字，因此dp[i][j]=dp[i-1][j]
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[len - 1][target];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}