//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
// Related Topics 排序 数组 双指针 
// 👍 716 👎 0


package leetcode.editor.cn.round9;

//Java：颜色分类
public class P75SortColors {
    public static void main(String[] args) {
        Solution solution = new P75SortColors().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
            int len = nums.length;
            if (len == 0) {
                return;
            }
            //三色用三指针，遇0往左边丢，遇2往右边丢
            int left = 0, right = len - 1, cur = 0;
            while (cur <= right) {
                if (nums[cur] == 0) {
                    int temp = nums[cur];
                    nums[cur] = nums[left];
                    nums[left] = temp;
                    left++;
                    cur++;
                } else if (nums[cur] == 2) {
                    int temp = nums[cur];
                    nums[cur] = nums[right];
                    nums[right] = temp;
                    right--;
                } else {
                    cur++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}