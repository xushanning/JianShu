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
// 👍 496 👎 0


package leetcode.editor.cn;

//Java：二进制求和
public class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a == null && b == null) {
                return null;
            }
            // 输入: a = "1010", b = "1011"
            //输出: "10101"
            int carry = 0;
            int lenA = a.length() - 1;
            int lenB = b.length() - 1;
            if (lenA < lenB) {
                return addBinary(b, a);
            }
            StringBuilder sb = new StringBuilder();
            while (lenB >= 0) {
                int sum = a.charAt(lenA) - '0' + b.charAt(lenB) - '0' + carry;
                carry = sum / 2;
                sb.append(sum % 2);
                lenA--;
                lenB--;
            }
            while (lenA >= 0) {
                int sum = a.charAt(lenA) - '0' + carry;
                carry = sum / 2;
                sb.append(sum % 2);
                lenA--;
            }
            if (carry != 0) {
                sb.append(carry);
            }

            return sb.reverse().toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}