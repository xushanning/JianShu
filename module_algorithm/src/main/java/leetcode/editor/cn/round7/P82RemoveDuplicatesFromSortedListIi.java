//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 396 👎 0


package leetcode.editor.cn.round7;

import leetcode.editor.cn.ListNode;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
// 输入: 0->1->1->1->2->3
//输出: 2->3
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur.next != null) {
                int curVal = cur.val;
                if (curVal == cur.next.val) {
                    while (cur.next != null) {
                        if (cur.next.val == curVal) {
                            cur = cur.next;
                        } else {
                            break;
                        }
                    }
                    cur = cur.next;
                    pre.next = cur;
                    if (cur == null) {
                        break;
                    }
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}