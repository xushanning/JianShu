//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序 
// 👍 324 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：最大数
public class P179LargestNumber {
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
        // TO TEST
        solution.largestNumber(new int[]{3, 30, 34, 5, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return "";
            }
            //[3,30,34,5,9]
            //9534330
            String[] strs = new String[len];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strs, new Comparator<String>() {
                //如果要按照升序排序,则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
                //如果要按照降序排序,则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
                @Override
                public int compare(String o1, String o2) {
                    //System.out.println(o1 + "==" + o2);
                    String order1 = o1 + o2;
                    String order2 = o2 + o1;
//                    如果参数字符串等于此字符串，则返回值 0；
//                    如果此字符串小于字符串参数，则返回一个小于 0 的值；
//                    如果此字符串大于字符串参数，则返回一个大于 0 的值。
                    int res = order2.compareTo(order1);
//                    System.out.println(res);
                    return res;
                }
            });
            if (strs[0].equals("0")) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}