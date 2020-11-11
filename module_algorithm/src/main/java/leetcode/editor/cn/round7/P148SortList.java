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
// 👍 808 👎 0


package leetcode.editor.cn.round7;

import leetcode.editor.cn.ListNode;

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
            //这里很重要，因为要递归，所以要判断head.next==null的情况，保证只有一个数的情况下直接返回，一个数
            //不用进行排序
            if (head == null || head.next == null) {
                return head;
            }
            //输入：head = [-1,5,3,4,0]
            //输出：[-1,0,3,4,5]
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
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            if (left == null) {
                cur.next = right;
            } else {
                cur.next = left;
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}