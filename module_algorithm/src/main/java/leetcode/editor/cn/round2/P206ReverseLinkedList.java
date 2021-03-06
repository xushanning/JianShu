//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package leetcode.editor.cn.round2;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            //异常判断
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                //当前的指向前一个
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
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