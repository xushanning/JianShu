//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
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
        //https://www.bilibili.com/video/BV1VC4y1s75E?from=search&seid=14993378031525039042
        public ListNode swapPairs(ListNode head) {
            //1->2->3->4, 你应该返回 2->1->4->3
            //异常判断
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;
            pre.next = head;
            while (pre.next != null && pre.next.next != null) {
                ListNode current = pre.next;
                ListNode future = pre.next.next;
                pre.next = future;
                current.next = future.next;
                future.next = current;
                pre = pre.next.next;
            }
            return dummy.next;

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}