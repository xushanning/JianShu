//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 695 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
            if (len <= 1) {
                return intervals;
            }
            //o1和o2是两个相邻的数组
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            // 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
            //输出: [[1,6],[8,10],[15,18]]
            List<int[]> data = new ArrayList<>();
            int[] pre = intervals[0];
            for (int i = 0; i < len; i++) {
                int[] cur = intervals[i];
                if (cur[0] > pre[1]) {
                    data.add(pre);
                    pre = cur;
                } else {
                    pre[1] = Math.max(pre[1], cur[1]);
                }
            }
            //老是忘。。
            data.add(pre);
            int[][] res = new int[data.size()][2];
            for (int i = 0; i < data.size(); i++) {
                res[i] = data.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}