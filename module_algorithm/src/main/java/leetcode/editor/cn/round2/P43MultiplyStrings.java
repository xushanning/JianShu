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


package leetcode.editor.cn.round2;

//Java：字符串相乘
public class P43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        // TO TEST
        solution.multiply("9133", "0");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 不好理解
         * https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
         *
         * @param num1
         * @param num2
         * @return
         */
        public String multiply(String num1, String num2) {
            if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
                return null;
            }
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int len1 = num1.length();
            int len2 = num2.length();
            if (len1 >= 110 || len2 >= 110) {
                return null;
            }
            int[] data = new int[len1 + len2];
            for (int i = len1 - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                for (int j = len2 - 1; j >= 0; j--) {
                    int n2 = num2.charAt(j) - '0';
                    int sum = data[i + j + 1] + n1 * n2;
                    data[i + j] = data[i + j] + sum / 10;
                    data[i + j + 1] = sum % 10;
                }
            }
            StringBuilder sb = new StringBuilder();
           // PrintUtil.print(Arrays.toString(data));
            for (int i = 0; i < data.length; i++) {
                if (i == 0 && data[i] == 0) {
                    continue;
                }
                sb.append(data[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}