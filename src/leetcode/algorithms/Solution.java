package leetcode.algorithms;

import leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: 382. Linked List Random Node
 *
 * @author Baltan
 * @date 2019-07-02 09:04
 */
public class Solution {
    private List<Integer> list;
    private Random rand;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        list = new ArrayList<>();
        rand = new Random();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}
