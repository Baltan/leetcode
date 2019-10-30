package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-10-30 21:44
 */
public class DoublyLinkedNode {
    public int val;
    public DoublyLinkedNode prev;
    public DoublyLinkedNode next;
    public DoublyLinkedNode child;

    public DoublyLinkedNode() {
    }

    public DoublyLinkedNode(int val, DoublyLinkedNode prev, DoublyLinkedNode next, DoublyLinkedNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
