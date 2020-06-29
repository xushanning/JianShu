//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针


package leetcode.editor.cn.round2;

import leetcode.editor.cn.ListNode;

//Java：分隔链表
public class P86PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {

            ListNode big = new ListNode(0);
            ListNode curBig = big;
            ListNode small = new ListNode(0);
            ListNode curSmall = small;
            while (head != null) {
                int curVal = head.val;
                if (curVal < x) {
                    curSmall.next = head;
                    curSmall = curSmall.next;
                } else {
                    curBig.next = head;
                    curBig = curBig.next;
                }
                head = head.next;
            }
            curSmall.next = big.next;
            //这行有点蒙
            curBig.next = null;
            return small.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}