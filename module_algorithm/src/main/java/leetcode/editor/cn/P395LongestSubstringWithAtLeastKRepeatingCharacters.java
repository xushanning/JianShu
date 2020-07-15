//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
// 👍 180 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：至少有K个重复字符的最长子串
public class P395LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P395LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        // TO TEST
        solution.longestSubstring("aaabb",3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int len = s.length();
            if (len == 0 || k < 1) {
                return 0;
            }
            //s = "ababbc", k = 2
            Map<Character, Integer> map = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            int res = 0;
            for (Integer item : map.values()) {
                if (item >= k) {
                    res += item;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}