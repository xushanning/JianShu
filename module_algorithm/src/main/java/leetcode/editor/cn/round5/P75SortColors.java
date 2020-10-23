//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 683 👎 0


package leetcode.editor.cn.round5;

//Java：颜色分类
public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
        solution.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
            int len = nums.length;
            if (len == 0) {
                return;
            }
            int left = 0, right = len - 1, cur = 0;
            //三指针，往两边分发：遇到2，往右边交换，遇到0，往左边交换
            while (right >= cur) {
                if (nums[cur] == 2) {
                    nums[cur] = nums[right];
                    nums[right] = 2;
                    right--;
                } else if (nums[cur] == 0) {
                    nums[cur] = nums[left];
                    nums[left] = 0;
                    left++;
                    cur++;
                } else {
                    cur++;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}