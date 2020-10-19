//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 202 👎 0


package leetcode.editor.cn.round5;

import java.util.HashMap;
import java.util.Map;

//Java：单词规律
public class P290WordPattern {
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
        solution.wordPattern("aabb", "dog cat cat fish");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
            int len = pattern.length();
            String[] ss = s.split(" ");
            if (len == 0 || len != ss.length) {
                return false;
            }
            Map<Character, String> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char c = pattern.charAt(i);
                String value = map.get(c);
                if (value == null) {
                    //排除这种情况  pattern = "abba"
                    //str = "dog dog dog dog"
                    if (map.containsValue(ss[i])) {
                        return false;
                    }
                    map.put(c, ss[i]);
                } else if (!value.equals(ss[i])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}