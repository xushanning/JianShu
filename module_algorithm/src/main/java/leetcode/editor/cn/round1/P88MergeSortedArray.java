//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package leetcode.editor.cn.round1;

//Java：合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://www.bilibili.com/video/BV1eE411y7WC?from=search&seid=14198379694628421192
        //双指针
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1 = m - 1;
            int i2 = n - 1;
            int i = m + n - 1;
            while (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i] = nums1[i1];
                    i1--;
                    i--;
                } else {
                    nums1[i] = nums2[i2];
                    i2--;
                    i--;
                }
            }
            while (i2 >= 0) {
                nums1[i] = nums2[i2];
                i2--;
                i--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}