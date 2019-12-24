package com.xu.module.algorithm.medium;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class M2 {
    @Test
    public void test() {
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        node2.next = node3;
        node1.next = node2;

        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(4);

        node5.next = node6;
        node4.next = node5;
        PrintUtil.print(handle(node1)+handle(node4));
    }

    private int handle(Node node) {
        int i = 1;
        int result = node.data * i;
        Node nodeLocal = node;
        while (nodeLocal.next != null) {
            i = i * 10;
            nodeLocal = nodeLocal.next;
            result = result + nodeLocal.data * i;
        }
        return result;
    }


    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
