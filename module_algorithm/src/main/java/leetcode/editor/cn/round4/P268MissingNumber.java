//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学 
// 👍 283 👎 0


package leetcode.editor.cn.round4;

//Java：缺失数字
public class P268MissingNumber {
    public static void main(String[] args) {
        Solution solution = new P268MissingNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            //因为a^b^b=a
            //[0,1,3]  3^0^0^1^1^2^3

            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                res = res ^ i ^ nums[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}