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


package leetcode.editor.cn.round1;

import leetcode.editor.cn.PrintUtil;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
        ListNode listNode1 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(1);
        ListNode listNode2 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(2);
        ListNode listNode3 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(3);
        ListNode listNode4 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(3);
        ListNode listNode5 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(4);
        ListNode listNode6 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(4);
        ListNode listNode7 = new P82RemoveDuplicatesFromSortedListIi().new ListNode(5);
        listNode6.next = listNode7;
        listNode5.next = listNode6;
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        ListNode listNode = solution.deleteDuplicates(listNode1);
        while (listNode != null) {
            PrintUtil.print(listNode.val);
            listNode = listNode.next;
        }
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
            //异常判断
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            // 1->2->3->3->4->4->5
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = dummy.next;

            while (right.next != null) {
                int cur = right.val;
                if (right.next.val == cur) {
                    right = right.next;
                    while (right.next != null) {
                        if (right.next.val == cur) {
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
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}