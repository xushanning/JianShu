//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 172 👎 0


package leetcode.editor.cn.round5;

//Java：有效的完全平方数
public class P367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            long left = 0, right = num;
            while (right >= left) {
                long mid = (left + right) / 2;
                long square = mid * mid;
                if (square == num) {
                    return true;
                } else if (square > num) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}