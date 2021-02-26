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
// 👍 649 👎 0


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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //1->2->3->4->5->NULL, m = 2, n = 4
            //1->4->3->2->5->NULL
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left = dummy;
            for (int i = 1; i < m; i++) {
                left = left.next;
            }
            ListNode right = left.next;
            ListNode start = right;
            ListNode cur = right.next;
            for (int i = m; i < n; i++) {
                ListNode next = cur.next;
                cur.next = start;
                start = cur;
                cur = next;
            }
            left.next = start;
            right.next = cur;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}