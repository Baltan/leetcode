package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-05-24 21:56
 */
public class LinkedNode {
    public int val;
    public LinkedNode left;
    public LinkedNode right;
    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int _val, LinkedNode _left, LinkedNode _right, LinkedNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "val=" + val +
                '}';
    }
}
