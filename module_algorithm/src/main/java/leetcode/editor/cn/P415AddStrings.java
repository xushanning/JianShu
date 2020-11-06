//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 275 👎 0


package leetcode.editor.cn;

//Java：字符串相加
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            int n1 = len1 - 1;
            int n2 = len2 - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (n1 >= 0 || n2 >= 0) {
                int p1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
                int p2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
                int sum = p1 + p2 + carry;
                sb.append(sum % 10);
                carry = sum / 10;
                if (n1 >= 0) {
                    n1--;
                }
                if (n2 >= 0) {
                    n2--;
                }
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}