package leetcode.algorithms;

import leetcode.entity.DoublyLinkedNode;
import leetcode.util.OutputUtils;

/**
 * Description: 430. Flatten a Multilevel Doubly Linked List
 *
 * @author Baltan
 * @date 2019-10-30 21:47
 */
public class Solution9 {
    public static void main(String[] args) {
        /**
         * <pre>
         *     1---2---3---4---5---6--NULL
         *          |
         *          7---8---9---10--NULL
         *              |
         *              11--12--NULL
         * </pre>
         */
        DoublyLinkedNode node11 = new DoublyLinkedNode();
        DoublyLinkedNode node12 = new DoublyLinkedNode();
        DoublyLinkedNode node13 = new DoublyLinkedNode();
        DoublyLinkedNode node14 = new DoublyLinkedNode();
        DoublyLinkedNode node15 = new DoublyLinkedNode();
        DoublyLinkedNode node16 = new DoublyLinkedNode();
        DoublyLinkedNode node17 = new DoublyLinkedNode();
        DoublyLinkedNode node18 = new DoublyLinkedNode();
        DoublyLinkedNode node19 = new DoublyLinkedNode();
        DoublyLinkedNode node110 = new DoublyLinkedNode();
        DoublyLinkedNode node111 = new DoublyLinkedNode();
        DoublyLinkedNode node112 = new DoublyLinkedNode();

        node11.val = 1;
        node11.next = node12;

        node12.val = 2;
        node12.prev = node11;
        node12.next = node13;

        node13.val = 3;
        node13.prev = node12;
        node13.next = node14;
        node13.child = node17;

        node14.val = 4;
        node14.prev = node13;
        node14.next = node15;

        node15.val = 5;
        node15.prev = node14;
        node15.next = node16;

        node16.val = 6;
        node16.prev = node15;

        node17.val = 7;
        node17.next = node18;

        node18.val = 8;
        node18.prev = node17;
        node18.next = node19;
        node18.child = node111;

        node19.val = 9;
        node19.prev = node18;
        node19.next = node110;

        node110.val = 10;
        node110.prev = node19;

        node111.val = 11;
        node111.next = node112;

        node112.val = 12;
        node112.prev = node111;

        OutputUtils.printDoublyLinkedNode(node11);
        OutputUtils.printDoublyLinkedNode(flatten(node11));
    }

    public static DoublyLinkedNode flatten(DoublyLinkedNode head) {
        if (head == null) {
            return null;
        }

        DoublyLinkedNode newHead = head;
        /**
         * 当前节点的下一个节点
         */
        DoublyLinkedNode currentNext = head.next;
        /**
         * 当前节点的子节点
         */
        DoublyLinkedNode currentChild = head.child;
        /**
         * 当前节点的子节点作为头节点的双向链表扁平化后得到的新的双向链表
         */
        DoublyLinkedNode newChild = flatten(currentChild);
        /**
         * 当前节点的下一个节点作为头节点的双向链表扁平化后得到的新的双向链表
         */
        DoublyLinkedNode newNext = flatten(currentNext);

        if (newChild == null && newNext == null) {
            /**
             * 如果当前节点没有下一个节点也没有子节点，则当前节点作为头节点的双向链表扁平化后不变
             */
            return newHead;
        } else if (newChild == null) {
            /**
             * 如果当前节点没有子节点，则当前节点作为头节点的双向链表扁平化后仍然以该节点作为头节点，并且该节点
             * 的下一个节点指向newNext，newNext的头节点的前一个节点指向该节点
             */
            newHead.next = newNext;
            newNext.prev = newHead;
            return newHead;
        } else if (newNext == null) {
            /**
             * 如果当前节点没有下一个节点，则当前节点作为头节点的双向链表扁平化后仍然以该节点作为头节点，并且该
             * 节点的下一个节点指向newChild，newChild的头节点的前一个节点指向该节点，并且该节点不再有子节点
             */
            newHead.next = newChild;
            newChild.prev = newHead;
            newHead.child = null;
        } else {
            /**
             * 如果当前节点既有下一个节点又有子节点，则当前节点作为头节点的双向链表扁平化后仍然以该节点作为头节
             * 点，并且该节点的下一个节点指向newChild，newChild的头节点的前一个节点指向该节点，并且该节点不再
             * 有子节点。然后要遍历找到该节点接上newChild后的双向链表的最后一个节点，最后一个节点的下一个节点
             * 指向newNext，newNext的头节点的前一个节点指向最后一个节点
             */
            newHead.next = newChild;
            newChild.prev = newHead;
            newHead.child = null;

            DoublyLinkedNode currentNode = newHead;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNext;
            newNext.prev = currentNode;
        }
        return newHead;
    }
}
