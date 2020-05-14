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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return head;
            }
            ListNode left = head;
            ListNode right = head;
            ListNode cur = head;
            int index = 1;
            //1->2->3->4->5->NULL, m = 2, n = 4
            while (cur != null) {
                if (index == m - 1) {
                    left = cur;
                }
                if (index == n - 1) {
                    right = cur;
                }
                cur = cur.next;
                index++;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}