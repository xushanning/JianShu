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


package leetcode.editor.cn.round1;

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
        //https://www.bilibili.com/video/BV1mJ411x7RM?from=search&seid=663209764609762460
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //异常判断
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            //第一段的最后一个节点
            ListNode first = dummy;
            for (int i = 1; i < m; i++) {
                first = first.next;
            }
            //反转前的第二段的第一个节点，反转后的第二段的最后一个节点
            ListNode second = first.next;
            //双指针
            ListNode l = second;
            ListNode r = second.next;

            for (int i = m; i < n; i++) {
                ListNode next = r.next;
                r.next = l;
                //右移
                l = r;
                r = next;
            }
            first.next = l;
            second.next = r;
            return dummy.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}