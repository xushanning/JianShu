//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1488 👎 0


package leetcode.editor.cn.round10;

import leetcode.editor.cn.ListNode;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode n1 = l1;
            ListNode n2 = l2;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (n1 != null && n2 != null) {
                if (n1.val > n2.val) {
                    cur.next = n2;
                    n2 = n2.next;
                } else {
                    cur.next = n1;
                    n1 = n1.next;
                }
                cur = cur.next;
            }
            if (n1 != null) {
                cur.next = n1;
            }
            if (n2 != null) {
                cur.next = n2;
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}