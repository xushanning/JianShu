//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 496 👎 0


package leetcode.editor.cn.round5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：字母异位词分组
public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int len = strs.length;
            if (len == 0) {
                return null;
            }

            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(s);
            }

            return new ArrayList<>(map.values());

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}