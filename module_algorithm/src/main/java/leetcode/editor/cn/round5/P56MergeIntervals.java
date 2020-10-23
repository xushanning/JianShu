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
// 👍 657 👎 0


package leetcode.editor.cn.round5;

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
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
            int len = intervals.length;
            if (len == 0) {
                return intervals;
            }
            //排序前：[[2,6],[1,3],[15,18],[8,10]]
            //排序后：[[1,3],[2,6],[8,10],[15,18]]
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            int[] cur = intervals[0];
            //因为不知道最后的数组大小，所以不用数组，用list
            List<int[]> data = new ArrayList<>();
            for (int i = 1; i < len; i++) {
                //不连续
                if (intervals[i][0] > cur[1]) {
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