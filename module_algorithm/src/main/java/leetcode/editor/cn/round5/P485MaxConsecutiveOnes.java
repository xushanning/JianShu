//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 131 👎 0


package leetcode.editor.cn.round5;

//Java：最大连续1的个数
public class P485MaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new P485MaxConsecutiveOnes().new Solution();
        // TO TEST
        solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
//输入: [1,1,0,1,1,1]
//输出: 3
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            int j = -1;
            int max = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    max = Math.max(max, i - j - 1);
                    j = i;
                }
            }
            return Math.max(max, len - j - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}