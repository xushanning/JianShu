//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 308 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：两个数组的交集 II
public class P350IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
        solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m == 0 || n == 0) {
                return new int[0];
            }
            if (m > n) {
                //保证小的在前面
                return intersect(nums2, nums1);
            }


            // 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
            //输出: [4,9]
            Map<Integer, Integer> map = new HashMap<>(m);
            for (int item : nums1) {
                map.put(item, 0);
            }

            List<Integer> data = new ArrayList<>();
            for (int item : nums2) {
                if (map.containsKey(item)) {
                    int value = map.get(item);
                    if (value == 0) {
                        data.add(item);
                    }
                    value++;
                    map.put(item, value);
                }
            }
            int[] res = new int[data.size()];
            for (int i = 0; i < data.size(); i++) {
                res[i] = data.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}