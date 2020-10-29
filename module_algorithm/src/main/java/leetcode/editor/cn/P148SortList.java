//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 803 👎 0


package leetcode.editor.cn;

//Java：排序链表
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            //忘了||head.next==null这个了，只有一个节点，也要返回
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode next = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(next);
            ListNode res = new ListNode(0);
            ListNode cur = res;
            while (left != null && right != null) {
                if (left.val > right.val) {
                    cur.next = right;
                    right = right.next;
                } else {
                    cur.next = left;
                    left = left.next;
                }
                cur = cur.next;
            }
            if (right == null) {
                cur.next = left;
            } else {
                cur.next = right;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}