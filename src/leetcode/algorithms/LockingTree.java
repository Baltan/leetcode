package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1993. Operations on Tree
 *
 * @author Baltan
 * @date 2022/1/19 13:41
 */
public class LockingTree {
    private int[] parent;
    /**
     * 节点i -> 节点i的子节点
     */
    private Map<Integer, List<Integer>> childrenMap;
    /**
     * locks[i]表示索引为i的节点是否被锁定
     */
    private boolean[] locks;
    /**
     * users[i]表示索引为i的节点被索引为users[i]的用户锁定
     */
    private int[] users;

    public LockingTree(int[] parent) {
        int length = parent.length;
        this.parent = parent;
        this.locks = new boolean[length];
        this.users = new int[length];
        this.childrenMap = new HashMap<>();
        /**
         * 查找每个节点的子节点
         */
        for (int i = 1; i < length; i++) {
            int value = parent[i];
            List<Integer> children = childrenMap.computeIfAbsent(value, x -> new ArrayList<>(2));
            children.add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (!locks[num]) {
            locks[num] = true;
            users[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (locks[num] && users[num] == user) {
            locks[num] = false;
            users[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (locks[num]) {
            return false;
        }

        if (!hasLockedDescendant(num)) {
            return false;
        }

        if (hasLockedAncestor(num)) {
            return false;
        }
        locks[num] = true;
        users[num] = user;
        unlockDescendants(num);
        return true;
    }

    /**
     * 查询索引为num的节点是否有上锁的子孙节点
     *
     * @param num
     * @return
     */
    private boolean hasLockedDescendant(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            List<Integer> children = childrenMap.getOrDefault(value, Collections.emptyList());

            for (int child : children) {
                if (locks[child]) {
                    return true;
                } else {
                    queue.offer(child);
                }
            }
        }
        return false;
    }

    /**
     * 查询索引为num的节点是否有上锁的祖先节点
     *
     * @param num
     * @return
     */
    private boolean hasLockedAncestor(int num) {
        while (parent[num] != -1) {
            num = parent[num];

            if (locks[num]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁索引为num的节点的所有子孙结点
     *
     * @param num
     */
    private void unlockDescendants(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);

        while (!queue.isEmpty()) {
            int value = queue.poll();
            List<Integer> children = childrenMap.getOrDefault(value, Collections.emptyList());

            for (int child : children) {
                locks[child] = false;
                users[child] = 0;
                queue.offer(child);
            }
        }
    }

    public static void main(String[] args) {
        LockingTree lockingTree1 = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(lockingTree1.lock(2, 2));
        System.out.println(lockingTree1.unlock(2, 3));
        System.out.println(lockingTree1.unlock(2, 2));
        System.out.println(lockingTree1.lock(4, 5));
        System.out.println(lockingTree1.upgrade(0, 1));
        System.out.println(lockingTree1.lock(0, 1));
    }
}


