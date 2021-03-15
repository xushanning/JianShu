//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 534 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：重排链表
public class P143ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        // 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
        // Related Topics 链表
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int left = 0, right = list.size() - 1;
            while (left < right) {
                list.get(left).next = list.get(right);
                left++;
                if (left == right) {
                    break;
                }
                list.get(right).next = list.get(left);
                right--;
            }
            list.get(left).next = null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}