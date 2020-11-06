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
// 👍 504 👎 0


package leetcode.editor.cn;

//Java：字符串相乘
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //这个题画个图就能做出来，需要注意的是i j res的起始位置，都是从左往右
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int len1 = num1.length();
            int len2 = num2.length();
            int[] res = new int[len1 + len2];
            for (int i = len1 - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    int n2 = num2.charAt(j) - '0';
                    //不用考虑进位的问题
                    //i+j+1是个位数
                    int sum = n1 * n2 + res[i + j + 1];
                    res[i + j + 1] = sum % 10;
                    res[i + j] += sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                //res的第一个数可能是0，后面的绝对不可能是0
                if (i == 0 && res[i] == 0) {
                    continue;
                }
                sb.append(res[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}