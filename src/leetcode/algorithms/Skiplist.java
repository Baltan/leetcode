package leetcode.algorithms;

import java.util.Random;

/**
 * Description: 1206. Design Skiplist
 *
 * @author Baltan
 * @date 2023/4/4 11:30
 * 参考：<a href="https://leetcode.cn/problems/design-skiplist/solutions/1698876/by-ac_oier-38rd/"></a>
 */
public class Skiplist {
    private Node head;
    private int level;
    private Random random;

    public Skiplist() {
        random = new Random();
        /**
         * 根据题意，操作次数∈[0,50000]，所以最多插入5000个节点，为了保证算法复杂度为O(logN)，跳表的层数为log50000向上取整值
         */
        level = (int) Math.ceil(Math.log(50000));
        /**
         * 根据题意，节点值∈[0,20000]，每一层操作的起始节点值假设为一个比0小的值即可
         */
        head = new Node(-1, new Node[level]);
    }

    public boolean search(int target) {
        /**
         * ceilingNodes[i]表示第i层小于target的最后一个节点
         */
        Node[] ceilingNodes = new Node[level];
        /**
         * 查找每一层中小于target的最后一个节点
         */
        findCeilingNodes(target, ceilingNodes);
        /**
         * 如果第0层查找到的节点ceilingNode的下一个节点值为target，则说明跳表中存在元素target
         */
        return ceilingNodes[0].next[0] != null && ceilingNodes[0].next[0].value == target;
    }

    public void add(int num) {
        /**
         * ceilingNodes[i]表示第i层小于num的最后一个节点
         */
        Node[] ceilingNodes = new Node[level];
        /**
         * 要插入的节点
         */
        Node node = new Node(num, new Node[level]);
        /**
         * 查找每一层中小于num的最后一个节点
         */
        findCeilingNodes(num, ceilingNodes);

        for (int i = 0; i < level; i++) {
            /**
             * 将node节点插入到节点ceilingNodes[i]和节点ceilingNodes[i].next[i]之间
             */
            node.next[i] = ceilingNodes[i].next[i];
            ceilingNodes[i].next[i] = node;
            /**
             * 有1/2的概率不用再继续在更高层插入节点node
             */
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int num) {
        /**
         * ceilingNodes[i]表示第i层小于num的最后一个节点
         */
        Node[] findCeilingNodes = new Node[level];
        /**
         * 查找每一层中小于num的最后一个节点
         */
        findCeilingNodes(num, findCeilingNodes);
        /**
         * 最底层中大于等于num的第一个节点
         */
        Node node = findCeilingNodes[0].next[0];
        /**
         * 最底层中不存在值为num的节点，说明跳表中也不存在值为num的节点，不需要进行删除操作
         */
        if (node == null || node.value != num) {
            return false;
        }
        /**
         * 从最底层逐层向上删除每层的第一个值为num的节点
         */
        for (int i = 0; i < level; i++) {
            /**
             * 第i层不存在值为num的节点，则更高层也不可能存在值为num的节点，结束删除操作
             */
            if (findCeilingNodes[i].next[i] == null || findCeilingNodes[i].next[i] != node) {
                break;
            }
            /**
             * 删除节点，将节点的前驱节点指向节点的后驱节点
             */
            findCeilingNodes[i].next[i] = findCeilingNodes[i].next[i].next[i];
        }
        return true;
    }

    /**
     * 查找每一层中小于target的最后一个节点
     *
     * @param target
     * @param ceilingNodes
     */
    private void findCeilingNodes(int target, Node[] ceilingNodes) {
        Node node = head;

        for (int i = level - 1; i >= 0; i--) {
            /**
             * 找到第i层小于target的最后一个节点
             */
            while (node.next[i] != null && node.next[i].value < target) {
                node = node.next[i];
            }
            ceilingNodes[i] = node;
        }
    }

    private static class Node {
        private int value;
        /**
         * next[i]表示当前节点在第i层的下一个节点
         */
        private Node[] next;

        public Node(int value, Node[] next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        System.out.println(skiplist.search(1));
        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));
        System.out.println(skiplist.search(1));
    }
}
