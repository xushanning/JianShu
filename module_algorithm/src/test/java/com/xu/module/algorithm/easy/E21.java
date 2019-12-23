package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/22.
 */
public class E21 {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;

        Node result = handle(node1, node2);
        while (result != null) {
            PrintUtil.print(result.data);
            result = result.next;
        }
    }

    private Node handle(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node result;
        if (head1.data > head2.data) {
            //小的给头
            result = head2;
            //核心代码：把大的和小的的next再对比一次
            result.next = handle(head1, head2.next);
        } else {
            result = head1;
            result.next = handle(head1.next, head2);
        }
        return result;

    }

    /**
     * 节点
     */
    class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

    }
}
