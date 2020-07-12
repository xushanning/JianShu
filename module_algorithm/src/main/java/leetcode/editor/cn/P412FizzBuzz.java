//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 65 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Fizz Buzz
public class P412FizzBuzz {
    public static void main(String[] args) {
        Solution solution = new P412FizzBuzz().new Solution();
        // TO TEST
        solution.fizzBuzz(15);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            for (int i = 1; i <= n; i++) {
                int flag3 = i % 3;
                int flag5 = i % 5;
                if (flag3 == 0 && flag5 == 0) {
                    res.add("FizzBuzz");
                } else if (flag5 == 0) {
                    res.add("Buzz");
                } else if (flag3 == 0) {
                    res.add("Fizz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}