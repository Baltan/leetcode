package leetcode.algorithms;

import java.util.*;

/**
 * Description: 3629. Minimum Jumps to Reach End via Prime Teleportation
 *
 * @author baltan
 * @date 2025/8/28 09:03
 */
public class MinJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{5, 7, 9, 5, 1}));
        System.out.println(minJumps(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}));
        System.out.println(minJumps(new int[]{1}));
        System.out.println(minJumps(new int[]{1, 1}));
        System.out.println(minJumps(new int[]{15, 2, 6, 3}));
        System.out.println(minJumps(new int[]{24, 20, 20, 15, 23}));
        System.out.println(minJumps(new int[]{1, 2, 4, 6}));
        System.out.println(minJumps(new int[]{2, 3, 4, 7, 9}));
        System.out.println(minJumps(new int[]{4, 6, 5, 8}));
    }

    public static int minJumps(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int result = 0;
        int length = nums.length;
        /**
         * 数组nums中的最大值
         */
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * indexes[i]保存数组nums中所有元素i的索引
         */
        List<Integer>[] indexes = new List[max + 1];
        /**
         * 保存已到达过的索引
         */
        Queue<Integer> queue = new LinkedList<>();
        /**
         * isVisited[i]表示元素nums[i]是否已被访问过
         */
        boolean[] isVisited = new boolean[length];
        /**
         * isTeleported[i]表示元素i是否已被质数传送到过
         */
        boolean[] isTeleported = new boolean[max + 1];
        Arrays.setAll(indexes, i -> new ArrayList<>());
        /**
         * 初始时位于nums[0]处
         */
        queue.offer(0);
        isVisited[0] = true;
        /**
         * 保存数组nums中不同元素值的索引集合
         */
        for (int i = 0; i < length; i++) {
            indexes[nums[i]].add(i);
        }

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                /**
                 * 移动到索引为curr-1的相邻格子
                 */
                if (curr - 1 >= 0 && !isVisited[curr - 1]) {
                    queue.offer(curr - 1);
                    isVisited[curr - 1] = true;
                }
                /**
                 * 移动到索引为curr+1的相邻格子
                 */
                if (curr + 1 < length && !isVisited[curr + 1]) {
                    /**
                     * 可到达终点nums[length-1]，直接返回
                     */
                    if (curr + 1 == length - 1) {
                        return result;
                    }
                    queue.offer(curr + 1);
                    isVisited[curr + 1] = true;
                }
                /**
                 * 质数传送到所有值为nums[curr]整数倍的元素所在的索引
                 */
                if (isPrime(nums[curr])) {
                    /**
                     * 可到达终点nums[length-1]，直接返回
                     */
                    if (nums[length - 1] % nums[curr] == 0) {
                        return result;
                    }

                    for (int j = nums[curr]; j <= max; j += nums[curr]) {
                        /**
                         * 元素j是否已被质数传送到过，不需要重复计算
                         */
                        if (isTeleported[j]) {
                            continue;
                        }

                        for (int index : indexes[j]) {
                            if (index == curr || isVisited[index]) {
                                continue;
                            }
                            queue.offer(index);
                            isVisited[index] = true;
                        }
                        isTeleported[j] = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断num是不是质数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
