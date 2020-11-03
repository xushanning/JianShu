//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学 
// 👍 121 👎 0


package leetcode.editor.cn.round6;

//Java：最大交换
public class P670MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new P670MaximumSwap().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] A = Integer.toString(num).toCharArray();
            //last[d] = i，最后一次出现的数字d（如果存在）的索引   i
            int[] last = new int[10];
            for (int i = 0; i < A.length; i++) {
                last[A[i] - '0'] = i;
            }

            for (int i = 0; i < A.length; i++) {
                for (int d = 9; d > A[i] - '0'; d--) {
                    if (last[d] > i) {
                        char tmp = A[i];
                        A[i] = A[last[d]];
                        A[last[d]] = tmp;
                        return Integer.valueOf(new String(A));
                    }
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}