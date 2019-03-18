package leetcode.algorithms;

public class MyLinkedList {

    private int size;
    private Node head;

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new
     * node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        newTail.next = null;
        if (head == null) {
            head = newTail;
        } else {
            Node currentNode = head;
            for (int i = 0; i < size - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newTail;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length
     * of linked list, the node will be appended to the end of linked list. If index is greater than the
     * length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > 0 && index < size) {
            Node prevNode = head;
            Node nextNode;
            Node newNode = new Node(val);
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            size--;
        } else if (index == size - 1) {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            size--;
        } else if (index > 0 && index < size - 1) {
            Node prevNode = head;
            Node nextNode;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            nextNode = prevNode.next.next;
            prevNode.next = nextNode;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        l1.addAtHead(1);
        l1.addAtTail(3);
        l1.addAtIndex(1, 2);
        System.out.println(l1.get(1));
        l1.deleteAtIndex(1);
        System.out.println(l1.get(1));

        System.out.println("-------------------");

        MyLinkedList l2 = new MyLinkedList();
        System.out.println(l2.get(0));
        l2.addAtIndex(1, 2);
        System.out.println(l2.get(0));
        System.out.println(l2.get(1));
        l2.addAtIndex(0, 1);
        System.out.println(l2.get(0));
        System.out.println(l2.get(1));
    }
}