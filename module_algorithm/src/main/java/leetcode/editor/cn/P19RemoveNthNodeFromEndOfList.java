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


package leetcode.editor.cn;

//Java：删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode listNode5 = new P19RemoveNthNodeFromEndOfList().new ListNode(5);
        ListNode listNode4 = new P19RemoveNthNodeFromEndOfList().new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode3 = new P19RemoveNthNodeFromEndOfList().new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode2 = new P19RemoveNthNodeFromEndOfList().new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode1 = new P19RemoveNthNodeFromEndOfList().new ListNode(1);
        listNode1.next = listNode2;
        solution.removeNthFromEnd(listNode1, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //基本思路，双指针，一个指针指到0，另一个指到n，然后往后移动，直到第二个指针
            //到了最后，那么把前一个指针的节点删掉

            ListNode right = head;
            for (int i = 0; i < n; i++) {
                right = right.next;
            }

            if (right == null) {
                return head.next;
            }
            ListNode left = head;
            while (right.next != null) {
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
            return head;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}