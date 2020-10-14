//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 186 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
public class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

// 输入: 3
//输出: [1,3,3,1]

        //[
//[1],
//[1,1],
//[1,2,1],
//[1,3,3,1],
//[1,4,6,4,1]
//]
        public List<Integer> getRow(int rowIndex) {
            //第n行共n+1个值
            //numVal = (n - i) / i * res.get(i - 1)
            List<Integer> res = new ArrayList<>(rowIndex + 1);
            long cur = 1;
            for (int i = 0; i <= rowIndex; i++) {
                res.add((int) cur);
                cur = cur * (rowIndex - i) / (i + 1);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}