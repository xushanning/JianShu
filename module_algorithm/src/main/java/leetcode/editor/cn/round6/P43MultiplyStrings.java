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
// 👍 503 👎 0


package leetcode.editor.cn.round6;

//Java：字符串相乘
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //123  456789
        public String multiply(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            if (len1 == 0 || len2 == 0) {
                return "";
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}