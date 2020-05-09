//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组


package leetcode.editor.cn.round1;

//Java：加一
public class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int length = digits.length;
            if (length == 0) {
                return null;
            }
            //进位
            int n = 0;
            for (int i = length - 1; i >= 0; i--) {
                //[4,3,2,1]
                //先自增一
                digits[i]++;
                //如果自增1取余数，赋值给自身，如果以前是9，那么现在
                //肯定是0，那么继续循环上一位，如果是以前不是9，那么现在加一后不满足进位
                //那么直接返回就行，太TMD妙了
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            //如果上面有返回，那么说明最高位进位了，只需要新建一个数组，把最高位置为1就ok
            digits = new int[length + 1];
            digits[0] = 1;
            return digits;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
