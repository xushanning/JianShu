//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 
//
// 示例 1: 
//
// 输入: 16
//输出: true
// 
//
// 示例 2: 
//
// 输入: 5
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 位运算 
// 👍 141 👎 0


package leetcode.editor.cn.round5;

//Java：4的幂
public class P342PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new P342PowerOfFour().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int num) {
            if (num < 1) {
                return false;
            }
            while (num % 4 == 0) {
                num = num / 4;
            }
            return num == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}