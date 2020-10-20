//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 321 👎 0


package leetcode.editor.cn.round5;

//Java：两整数之和
public class P371SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P371SumOfTwoIntegers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            //2+3=5 0010+0011=0101
            //2^3=0001 这是没有进位的
            //2&3=0010 找到进位，左移
            while (b != 0) {
                //异或，相同为0，不同为1，得到一个没有进位的结果,temp就是结果，只不过缺少进位，需要多次加进位
                int temp = a ^ b;
                //进位，左移一位，进位了当然需要加上这个进位
                b = a & b << 1;
                a = temp;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}