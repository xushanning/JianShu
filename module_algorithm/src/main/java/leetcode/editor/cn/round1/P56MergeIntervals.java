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


package leetcode.editor.cn.round1;

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
            if (intervals.length == 0 || intervals[0].length == 0) {
                return intervals;
            }
            //按照第一个元素进行排序
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            //排序前：[[2,6],[1,3],[15,18],[8,10]]
            //排序后：[[1,3],[2,6],[8,10],[15,18]]

            List<int[]> data = new ArrayList<>();
            //异常判断
            int m = intervals.length;
            int[] cur = intervals[0];
            for (int i = 1; i < m; i++) {
                //当前的第一个大于上一个的第二个，说明不连续
                if (intervals[i][0] > cur[1]) {
                    data.add(cur);
                    cur = intervals[i];
                } else {
                    //当前和上一个产生了连续重叠
                    //max是为了防止这种情况：[1,4],[2,3]
                    cur[1] = Math.max(intervals[i][1], cur[1]);
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