//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1134 👎 0


package leetcode.editor.cn.all;

import leetcode.editor.cn.ListNode;

//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            //1->2->3->4->5, 和 n = 2.
            //1->2->3->5.
            ListNode right = head;
            for (int i = 0; i < n; i++) {
                right = right.next;
            }
            if (right == null) {
                return head.next;
            }
            ListNode left = head;
            while (right.next != null) {
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}