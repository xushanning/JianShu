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
// 👍 1077 👎 0


package leetcode.editor.cn.round5;

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
            ListNode quick = head;
            for (int i = 0; i < n; i++) {
                quick = quick.next;
            }
            //这种情况: 1->2  2 然后移除倒数第二个，就是把头去掉，因此返回head.next
            if (quick == null) {
                return head.next;
            }
            ListNode slow = head;
            while (quick.next != null) {
                quick = quick.next;
                slow = slow.next;
            }
            //   1->2->3->4->5, 和 n = 2.
            slow.next = slow.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}