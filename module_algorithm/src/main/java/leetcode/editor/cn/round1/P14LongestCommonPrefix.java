//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn.round1;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        solution.longestCommonPrefix(new String[]{"dog","racecar","car"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            //判断异常
            if (strs.length == 0) {
                return "";
            }
            //["flower","flow","flight"]
            String result = strs[0];
            for (String s : strs) {
                //indexOf方法：返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
                while (s.indexOf(result) != 0) {
                    result = result.substring(0, result.length() - 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}