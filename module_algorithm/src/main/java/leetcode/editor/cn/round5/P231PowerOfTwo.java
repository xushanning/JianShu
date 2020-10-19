//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 254 👎 0


package leetcode.editor.cn.round5;

//Java：2的幂
public class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //由于int一共只有32位，去掉一位符号位。事实上满足条件的场景只有31种，遍历就完了
        public boolean isPowerOfTwo(int n) {
            int temp = 1;
            for (int i = 0; i < 31; i++) {
                if (temp == n) {
                    return true;
                }
                temp <<= 1;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}