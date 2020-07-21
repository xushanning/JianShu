//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找 
// 👍 375 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：有序矩阵中第K小的元素
public class P378KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            if (m == 0 || matrix[0].length == 0 || k < 1) {
                return 0;
            }
            int n = matrix[0].length;
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    //大顶堆
                    return o2 - o1;
                }
            });
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = matrix[i][j];
                    if (count < k) {
                        queue.offer(cur);
                    } else if (cur < queue.peek()) {
                        queue.poll();
                        queue.offer(cur);
                    }
                    count++;
                }
            }
            return queue.peek();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}