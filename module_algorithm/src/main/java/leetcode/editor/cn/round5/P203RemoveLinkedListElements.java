//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 463 👎 0


package leetcode.editor.cn.round5;

import leetcode.editor.cn.ListNode;

//Java：移除链表元素
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5

            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode cur = newHead.next;
            ListNode pre = newHead;

            while (cur != null) {
                if (cur.val == val) {
                    pre.next=cur.next;
                }else{
                    pre=cur;
                }
                cur = cur.next;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}