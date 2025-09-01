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
        int max = Arrays.stream(nums).max().getAsInt();
        List<Integer>[] indexes = new List[max + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[length];
        Arrays.setAll(indexes, i -> new ArrayList<>());
        queue.offer(0);
        isVisited[0] = true;

        for (int i = 0; i < length; i++) {
            indexes[nums[i]].add(i);
        }

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr - 1 >= 0 && !isVisited[curr - 1]) {
                    queue.offer(curr - 1);
                    isVisited[curr - 1] = true;
                }

                if (curr + 1 < length && !isVisited[curr + 1]) {
                    if (curr + 1 == length - 1) {
                        return result;
                    }
                    queue.offer(curr + 1);
                    isVisited[curr + 1] = true;
                }

                if (isPrime(nums[curr])) {
                    if (nums[length - 1] % nums[curr] == 0) {
                        return result;
                    }

                    for (int j = nums[curr]; j <= max; j += nums[curr]) {
                        for (int index : indexes[j]) {
                            if (index == curr || isVisited[index]) {
                                continue;
                            }
                            queue.offer(index);
                            isVisited[index] = true;
                        }
                    }
                }
            }
        }
        return result;
    }

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
