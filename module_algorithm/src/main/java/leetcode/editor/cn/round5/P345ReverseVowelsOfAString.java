//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 120 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.List;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {

            //元音字母:a e i o u
            int len = s.length();
            if (len <= 1) {
                return s;
            }
            List<Character> list = new ArrayList<>();
            list.add('a');
            list.add('e');
            list.add('i');
            list.add('o');
            list.add('u');
            list.add('A');
            list.add('E');
            list.add('I');
            list.add('O');
            list.add('U');
            char[] chars = s.toCharArray();
            int l = 0, r = len - 1;
            while (r > l) {
                while (r > l && !list.contains(chars[l])) {
                    l++;
                }
                while (r > l && !list.contains(chars[r])) {
                    r--;
                }
                // 输入："hello"
                //输出："holle"
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}