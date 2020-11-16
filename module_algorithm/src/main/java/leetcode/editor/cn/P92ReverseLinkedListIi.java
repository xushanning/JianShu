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
// 👍 580 👎 0


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
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
        //输出: 1->4->3->2->5->NULL
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;

            for (int i = 1; i < m; i++) {
                pre = pre.next;
            }
            ListNode second = pre.next;
            ListNode start = second;
            ListNode end = second.next;
            for (int i = m; i < n; i++) {
                ListNode next = end.next;
                end.next = start;
                start = end;
                end = next;
            }
            pre.next = start;
            second.next = end;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}