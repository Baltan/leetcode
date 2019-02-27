package leetcode.entity;

/**
 * Description:
 *
 * @author Baltan
 * @date 2018/7/27 14:52
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}