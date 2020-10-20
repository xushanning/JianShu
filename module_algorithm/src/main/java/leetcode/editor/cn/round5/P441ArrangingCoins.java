//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 80 👎 0


package leetcode.editor.cn.round5;

//Java：排列硬币
public class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {

            //k(k+1) /2 = n
            int low = 1;
            int high = n;
            long mid, sum;//使用long类型是为了应对 输入：1804289383 时，计算sum值超出int的取值范围的情况
            while (low <= high) {
                mid = low + (high - low) / 2;
                sum = mid * (mid + 1) / 2;
                if (sum == n) {
                    return (int) mid;//强制类型转换，将long类型转换为int类型
                } else if (n > sum) {
                    low = (int) mid + 1;
                } else {
                    high = (int) mid - 1;
                }
            }
            //return low - 1;是同样的结果。因为最后high<low,而根据题意，k取较小值
            return high;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}