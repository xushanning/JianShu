//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 264 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：有效的字母异位词
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int len1 = s.length();
            int len2 = t.length();
            if (len1 != len2) {
                return false;
            }
            char[] c1 = s.toCharArray();
            char[] c2 = t.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            for (int i = 0; i < len1; i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}