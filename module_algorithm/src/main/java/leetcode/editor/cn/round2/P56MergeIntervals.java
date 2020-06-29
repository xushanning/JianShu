//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
            int m = intervals.length;
            if (m == 0 || intervals[0].length == 0) {
                return new int[][]{};
            }
            int n = intervals[0].length;
            //排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            //排序前：[[2,6],[1,3],[15,18],[8,10]]
            //排序后：[[1,3],[2,6],[8,10],[15,18]]
            int[] cur = intervals[0];

            List<int[]> data = new ArrayList<>();
            for (int i = 1; i < m; i++) {
                if (intervals[i][0] > cur[1]) {
                    //不连续，那么加上
                    data.add(cur);
                    cur = intervals[i];
                } else {
                    cur[1] = Math.max(cur[1], intervals[i][1]);
                }
            }
            data.add(cur);

            int[][] res = new int[data.size()][2];
            for (int i = 0; i < data.size(); i++) {
                res[i] = data.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}