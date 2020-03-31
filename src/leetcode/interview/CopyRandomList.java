package leetcode.interview;

import leetcode.entity.RandomNode;
import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: 面试题35. 复杂链表的复制
 *
 * @author Baltan
 * @date 2020-03-31 17:12
 * @see leetcode.algorithms.CopyRandomList
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
        /**
         * map存储原节点和该节点克隆后得到的节点
         */
        Map<RandomNode, RandomNode> map = new HashMap<>();
        /**
         * set保存已经处理过的节点，用于判定是否出现环形链表
         */
        Set<RandomNode> set = new HashSet<>();
        /**
         * 创建头节点的克隆，并加入map中
         */
        RandomNode copyHead = new RandomNode(head.val, null, null);
        map.put(head, copyHead);
        /**
         * current保存当前处理到的节点的克隆节点
         */
        RandomNode current = copyHead;
        /**
         * 将头节点保存下来，因为有两轮循环分别从头节点开始处理next指针和random指针
         */
        RandomNode initHead = head;
        /**
         * 先处理每个节点的next指针
         */
        while (head.next != null) {
            /**
             * 如果map中已经包含了当前节点的next节点，说明该节点的next节点之前已经处理过，此处出现了环形链表，
             * 将当前节点的next节点的克隆添加给当前节点的克隆节点的next指针后可以退出循环
             */
            if (map.containsKey(head.next)) {
                current.next = map.get(head.next);
                break;
            }
            /**
             * 创建当前节点的next节点的克隆
             */
            RandomNode copyNext = new RandomNode(head.next.val, null, null);
            current.next = copyNext;
            head = head.next;
            current = copyNext;
            /**
             * 将当前处理到的节点和该节点的克隆加入map中
             */
            map.put(head, current);
        }
        /**
         * 处理完所有next指针后将current指向头节点的拷贝，继续处理random指针
         */
        current = copyHead;
        /**
         * 再处理每个节点的random指针
         */
        while (current != null) {
            current.random = map.get(initHead.random);
            /**
             * 将该处理过的节点添加到set中
             */
            set.add(initHead);
            current = current.next;
            initHead = initHead.next;
            /**
             * 如果set中已经包含要处理的下一个节点了，说明出现了环形链表，直接退出循环
             */
            if (set.contains(initHead)) {
                break;
            }
        }
        return copyHead;
    }
}
