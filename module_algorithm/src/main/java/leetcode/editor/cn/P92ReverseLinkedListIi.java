//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 709 👎 0


package leetcode.editor.cn;

//Java：反转链表 II
public class P92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
        // 输入: null->1->2->3->4->5->NULL, m = 2, n = 4
        //输出: 1->4->3->2->5->NULL
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next;
            ListNode end = start;
            //这里不是最优解，最优解是，直接开始反转
            for (int i = left; i < right; i++) {
                end = end.next;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;

            return dummy.next;
        }

        private ListNode reverse(ListNode node) {
            ListNode pre = null;
            ListNode cur = node;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}