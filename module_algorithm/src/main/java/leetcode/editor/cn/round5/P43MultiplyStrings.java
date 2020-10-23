//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 498 👎 0


package leetcode.editor.cn.round5;

//Java：字符串相乘
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            if (len1 == 0 || len2 == 0) {
                return "";
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
// 输入: num1 = "123", num2 = "456"
//输出: "56088"

            //1 2 3
            //4 5 6
            String res = "0";
            for (int i = 0; i < len2; i++) {
                int carry = 0;
                int n2 = num2.charAt(i) - '0';
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len2 - 1 - i; j++) {
                    sb.append(0);
                }
                for (int j = len1 - 1; j >= 0; j--) {
                    int n1 = num1.charAt(j) - '0';
                    int sum = n1 * n2 + carry;
                    sb.append(sum % 10);
                    carry = sum / 10;
                }
                if (carry != 0) {
                    sb.append(carry);
                }
                res = merge(res, sb.reverse().toString());
            }


            return res;
        }

        //360 + 2700
        private String merge(String nums1, String nums2) {
            int len1 = nums1.length();
            int len2 = nums2.length();
            //保证小的在前面
            if (len1 > len2) {
                return merge(nums2, nums1);
            }
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len1; i++) {
                int x = nums1.charAt(i);
                int y = nums2.charAt(i);
                int sum = x + y + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }
            for (int i = len1; i < len2; i++) {
                int x = nums2.charAt(i);
                int sum = x + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}