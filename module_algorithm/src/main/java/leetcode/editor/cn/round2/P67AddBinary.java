//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


package leetcode.editor.cn.round2;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int m = a.length() - 1;
            int n = b.length() - 1;
            //保证m为大的
            if (m < n) {
                return addBinary(b, a);
            }
            StringBuilder sb = new StringBuilder();
            int carry = 0;

            while (n >= 0) {
                int sum = a.charAt(m) - '0' + b.charAt(n) - '0' + carry;
                carry = sum / 2;
                sum = sum % 2;
                sb.append(sum);
                n--;
                m--;
            }
            while (m >= 0) {
                int sum = a.charAt(m) - '0' + carry;
                carry = sum / 2;
                sum = sum % 2;
                sb.append(sum);
                m--;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}