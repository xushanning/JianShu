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
// 👍 361 👎 0


package leetcode.editor.cn.round7;

import leetcode.editor.cn.ListNode;

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
            if (head == null || k <= 0) {
                return head;
            }
            int count = 1;
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
            ListNode cur = head;
            while (cur.next != null) {
                count++;
                cur = cur.next;
            }

            //成环
            cur.next = head;
            k = k % count;
            ListNode node = head;
            for (int i = 0; i < count - k - 1; i++) {
                node = node.next;
            }
            ListNode newHead = node.next;
            node.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}