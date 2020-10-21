//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4478 👎 0


package leetcode.editor.cn.round5;

import java.util.HashMap;
import java.util.Map;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int len = s.length();
            if (len < 2) {
                return len;
            }
            int max = 1;
// 输入: "abcabcbb"
//输出: 3
            int left = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    //left往右移动
                    left = Math.max(left, map.get(c) + 1);
                }
                //更新c的位置
                map.put(c, i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}