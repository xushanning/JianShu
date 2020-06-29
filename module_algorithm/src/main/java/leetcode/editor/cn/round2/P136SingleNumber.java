//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表


package leetcode.editor.cn.round2;

//Java：只出现一次的数字
public class P136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
        solution.singleNumber(new int[]{4, 1, 2, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            //异或，相同为0，不同为1，优秀的解法
            //所有4^1^2^1^2就等于1^1^2^2^4等于0^4=4
            int num = nums[0];
            if (nums.length > 1) {
                for (int i = 1; i < nums.length; i++) {
                    num = num ^ nums[i];
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}