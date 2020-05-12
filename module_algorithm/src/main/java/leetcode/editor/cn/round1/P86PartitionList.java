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


package leetcode.editor.cn.round1;

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
            //异常判断
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }

            ListNode small = new ListNode(0);
            ListNode s1 = small;
            ListNode big = new ListNode(0);
            ListNode b1 = big;
            while (head != null) {
                if (head.val < x) {
                    s1.next = head;
                    s1 = s1.next;
                } else {
                    b1.next = head;
                    b1 = b1.next;
                }
                head = head.next;
            }
            s1.next = big.next;
            //最后一个节点指向null
            b1.next = null;
            return small.next;
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