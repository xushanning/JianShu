//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 395 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2].
            List<Integer> res = new ArrayList<>();
            int len = s.length();
            if (len == 0) {
                return res;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //存储滑动窗口中的存储
            Map<Character, Integer> window = new HashMap<>();
            int left = 0;
            int right = 0;
            int valid = p.length();
            while (right < len) {
                char cRight = s.charAt(right);
                if (map.containsKey(cRight)) {
                    window.put(cRight, window.getOrDefault(cRight, 0) + 1);
                    if (window.get(cRight) <= map.get(cRight)) {
                        valid--;
                    }
                }
                while (valid == 0) {
                    if (right - left + 1 == p.length()) {
                        res.add(left);
                    }
                    if (map.containsKey(s.charAt(left))) {
                        window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                        if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                            valid++;
                        }
                    }
                    left++;
                }
                right++;
            }


            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}