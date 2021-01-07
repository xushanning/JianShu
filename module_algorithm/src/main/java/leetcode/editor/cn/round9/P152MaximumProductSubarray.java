//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 858 👎 0


package leetcode.editor.cn.round9;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int iMax = 1;
            int iMin = 1;
            for (int i = 0; i < len; i++) {
                if (nums[i] < 0) {
                    int temp = iMax;
                    iMax = iMin;
                    iMin = temp;
                }
                iMax = Math.max(iMax, nums[i] * iMax);
                iMin = Math.min(iMin, nums[i] * iMin);
                max = Math.max(iMax, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}