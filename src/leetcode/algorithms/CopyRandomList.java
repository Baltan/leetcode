package leetcode.algorithms;

import leetcode.entity.RandomNode;
import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 138. Copy List with Random Pointer
 *
 * @author Baltan
 * @date 2019-05-31 09:21
 */
public class CopyRandomList {
    public static void main(String[] args) {
        RandomNode node11 = new RandomNode(1, null, null);
        RandomNode node12 = new RandomNode(2, null, null);
        node11.next = node12;
        node11.random = node12;
        node12.random = node12;
        OutputUtils.printRandomNode(node11);
        OutputUtils.printRandomNode(copyRandomList(node11));

        RandomNode node21 = new RandomNode(1, null, null);
        node21.random = node21;
        OutputUtils.printRandomNode(node21);
        OutputUtils.printRandomNode(copyRandomList(node21));

        RandomNode node31 = new RandomNode(1, null, null);
        RandomNode node32 = new RandomNode(2, null, null);
        RandomNode node33 = new RandomNode(3, null, null);
        RandomNode node34 = new RandomNode(4, null, null);
        node31.next = node32;
        node31.random = node34;
        node32.next = node33;
        node32.random = node31;
        node33.next = node34;
        node33.random = node32;
        node34.next = node31;
        node34.random = node33;
        OutputUtils.printRandomNode(node31);
        OutputUtils.printRandomNode(copyRandomList(node31));
    }

    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomNode, RandomNode> map = new HashMap<>();
        Set<RandomNode> set = new HashSet<>();
        RandomNode copyHead = new RandomNode(head.val, null, null);
        map.put(head, copyHead);
        RandomNode current = copyHead;
        RandomNode initHead = head;

        while (head.next != null) {
            if (map.containsKey(head.next)) {
                current.next = map.get(head.next);
                break;
            }

            RandomNode copyNext = new RandomNode(head.next.val, null, null);
            current.next = copyNext;
            head = head.next;
            current = copyNext;
            map.put(head, current);
        }
        current = copyHead;

        while (current != null) {
            current.random = map.get(initHead.random);
            set.add(initHead);
            current = current.next;
            initHead = initHead.next;

            if (set.contains(initHead)) {
                break;
            }
        }
        return copyHead;
    }
}
