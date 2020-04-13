//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Z 字形变换
public class P6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        // TO TEST
        solution.convert("LEETCODEISHIRING", 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            //异常判断
            int length = s.length();
            if (length == 0 || numRows <= 1) {
                return s;
            }
            List<StringBuilder> sbs = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                sbs.add(new StringBuilder());
            }
            int index = 0;
            int dir = 1;
            for (char c : s.toCharArray()) {
                sbs.get(index).append(c);
                index += dir;
                if (index == 0 || index == numRows - 1) {
                    dir = -dir;
                }
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder stringBuilder : sbs) {
                result.append(stringBuilder);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}