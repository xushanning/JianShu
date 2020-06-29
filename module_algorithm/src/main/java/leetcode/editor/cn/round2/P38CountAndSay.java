//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。 
//
// 注意：整数序列中的每一项将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。 
// Related Topics 字符串


package leetcode.editor.cn.round2;

import leetcode.editor.cn.PrintUtil;

//Java：外观数列
public class P38CountAndSay {
    public static void main(String[] args) {
        Solution solution = new P38CountAndSay().new Solution();
        // TO TEST
        String s = solution.countAndSay(5);
        PrintUtil.print(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //第二遍没有采用第一遍的递归
        public String countAndSay(int n) {
            if (n < 1) {
                return "";
            }
            String res = "1";

            for (int i = 1; i < n; i++) {
                int p = 0;
                int cur;
                StringBuilder sb = new StringBuilder();
                for (cur = 1; cur < res.length(); cur++) {
                    if (res.charAt(p) != res.charAt(cur)) {
                        int count = cur - p;
                        sb.append(count).append(res.charAt(p));
                        p = cur;
                    }
                }
                //为了处理这种情况:1、11
                if (p != cur) {
                    int count = cur - p;
                    sb.append(count).append(res.charAt(p));
                }
                res = sb.toString();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}