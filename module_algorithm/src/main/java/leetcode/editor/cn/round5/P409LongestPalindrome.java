//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 240 👎 0


package leetcode.editor.cn.round5;

//Java：最长回文串
public class P409LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new P409LongestPalindrome().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            int[] chars = new int[58];
            for (char c : s.toCharArray()) {
                //因为区分大小写，所以减去'A',
                chars[c - 'A']++;
            }
            int res = 0;
            for (int x : chars) {
                //如果x为偶数，那么x&1=0，那么就全用，如果x为奇数，那么x&1=1,就用x-1次
                res = res + x - (x & 1);
            }
            //如果小于s长度，说明至少一个字符出现了奇数次，那么可以取一个奇数次的字符，放到中间去
            return res < s.length() ? res + 1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}