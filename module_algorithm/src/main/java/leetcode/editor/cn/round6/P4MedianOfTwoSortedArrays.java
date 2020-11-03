//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3360 👎 0


package leetcode.editor.cn.round6;

//Java：寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                //保证nums1为size小
                return findMedianSortedArrays(nums2, nums1);
            }
            //左边元素需要满足的个数
            int totalLeft = (m + n + 1) / 2;
            int left = 0;
            int right = m;

            while (left < right) {
                //第一个数组元素的中间值
                int mid = (left + right + 1) / 2;
                //第二个数组在左边的元素的个数
                int j = totalLeft - mid;
                //第一个数组分割线左边的元素大于第二个数组分割线右边的数值，说明第一个数组分割线太靠右了
                if (nums1[mid - 1] > nums2[j]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            int i = left;
            int j = totalLeft - i;
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
            if ((m + n) % 2 == 1) {
                //奇数
                return Math.max(nums1LeftMax, nums2LeftMax);
            } else {
                //偶数
                return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}