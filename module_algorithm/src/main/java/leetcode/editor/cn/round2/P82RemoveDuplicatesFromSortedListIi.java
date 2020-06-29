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


package leetcode.editor.cn.round2;

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
            if (head == null || head.next == null) {
                return head;
            }

            //1->2->3->3->4->4->5
            //1->2->5
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = dummy.next;
            while (right.next != null) {
                int curVal = right.val;
                if (curVal == right.next.val) {
                    //相同
                    right = right.next;
                    while (right.next != null) {
                        if (right.next.val == curVal) {
                            right = right.next;
                        } else {
                            break;
                        }
                    }
                    right = right.next;
                    left.next = right;
                    if (right == null) {
                        break;
                    }
                } else {
                    left = right;
                    right = right.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}