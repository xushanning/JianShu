//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 300 👎 0


package leetcode.editor.cn.round9;

//Java：验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            //"A man, a plan, a canal: Panama"
            int len = s.length();
            if (len == 0) {
                return true;
            }
            int left = 0, right = len - 1;
            while (left < right) {
                char cLeft = s.charAt(left);
                char cRight = s.charAt(right);
                if (!Character.isLetterOrDigit(cLeft)) {
                    left++;
                } else if (!Character.isLetterOrDigit(cRight)) {
                    right--;
                } else {
                    if (Character.toLowerCase(cLeft) == Character.toLowerCase(cRight)) {
                        left++;
                        right--;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}