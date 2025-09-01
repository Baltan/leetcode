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
        System.out.println(minJumps(new int[]{1, 2, 4, 6}));
        System.out.println(minJumps(new int[]{2, 3, 4, 7, 9}));
        System.out.println(minJumps(new int[]{4, 6, 5, 8}));
    }

    /**
     * 根据题意，nums[i]∈[1,1000000]
     */
    private static final int MAX = 1000000;
    /**
     * NOT_PRIME[i]表示i是否不是质数
     */
    private static final boolean[] NOT_PRIME = new boolean[MAX + 1];

    /**
     * 初始化计算[1,1000000]中的各个元素是否是质数
     */
    static {
        NOT_PRIME[0] = true;
        NOT_PRIME[1] = true;

        for (int i = 4; i <= MAX; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (!NOT_PRIME[j] && i % j == 0) {
                    NOT_PRIME[i] = true;
                    break;
                }
            }
        }
    }

    public static int minJumps(int[] nums) {
        int result = 0;
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        List<Integer>[] indexes = new List[MAX + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[length];
        Arrays.setAll(indexes, i -> new ArrayList<>());
        queue.offer(0);
        isVisited[0] = true;

        for (int i = 0; i < length; i++) {
            indexes[nums[i]].add(i);
            max = Math.max(max, nums[i]);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == length - 1) {
                    return result;
                }

                if (curr - 1 >= 0 && !isVisited[curr - 1]) {
                    queue.offer(curr - 1);
                    isVisited[curr - 1] = true;
                }

                if (curr + 1 < length && !isVisited[curr + 1]) {
                    queue.offer(curr + 1);
                    isVisited[curr + 1] = true;
                }

                if (!NOT_PRIME[nums[curr]]) {
                    for (int j = nums[curr]; j <= max; j += nums[curr]) {
                        for (int index : indexes[j]) {
                            if (index == curr) {
                                continue;
                            }
                            queue.offer(index);
                            isVisited[index] = true;
                        }
                    }
                }
            }
            result++;
        }
        return result;
    }
}
