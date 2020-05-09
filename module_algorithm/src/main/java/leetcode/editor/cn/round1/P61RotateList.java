//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针


package leetcode.editor.cn.round1;

//Java：旋转链表
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            //异常判断
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            int n = 1;
            ListNode old = head;
            for (n = 1; old.next != null; n++) {
                old = old.next;
            }
            //将最后一个节点指向头，闭合链表
            old.next = head;
            ListNode newNode = head;
            //假如是1 2 3 4 5 ,k=2，那么要从3和4之间断开，那么循环完，newNode指向了3，
            //新的头，指向了3的next，也就是4，然后把3的next置为null
            for (int i = 0; i < n - k % n - 1; i++) {
                newNode = newNode.next;
            }

            ListNode newHead = newNode.next;
            newNode.next = null;
            return newHead;
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