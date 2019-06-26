package leetcode.algorithms;

import java.util.*;

/**
 * Description: 354. Russian Doll Envelopes
 *
 * @author Baltan
 * @date 2019-06-26 10:08
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelops1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelops1));

        int[][] envelops2 =
                {{5, 4}, {6, 4}, {6, 7}, {2, 3}, {4, 5}, {5, 6}, {3, 2}, {8, 9}, {6, 3}, {7, 2},
                        {1, 1}, {9, 9}, {8, 6}};
        System.out.println(maxEnvelopes(envelops2));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int result = 0;
        Map<Integer, Queue<int[]>> map = new TreeMap<>((m, n) -> n - m);

        Arrays.sort(envelopes, (m, n) -> {
            if (m[0] == n[0]) {
                return m[1] - n[1];
            } else {
                return m[0] - n[0];
            }
        });

        for (int[] envelope : envelopes) {
            if (map.isEmpty()) {
                Queue<int[]> queue = new PriorityQueue<>((m, n) -> {
                    if (m[0] == n[0]) {
                        return m[1] - n[1];
                    } else {
                        return m[0] - n[0];
                    }
                });
                queue.offer(envelope);
                map.put(1, queue);
                result = 1;
            } else {
                boolean flag = false;

                outer:
                for (int num : map.keySet()) {
                    Queue<int[]> queue = map.get(num);

                    for (int[] element : queue) {
                        if (element[0] < envelope[0] && element[1] < envelope[1]) {
                            flag = true;

                            if (map.get(num + 1) == null) {
                                Queue<int[]> q = new PriorityQueue<>((m, n) -> {
                                    if (m[0] == n[0]) {
                                        return m[1] - n[1];
                                    } else {
                                        return m[0] - n[0];
                                    }
                                });
                                q.offer(envelope);
                                map.put(num + 1, q);
                                result = Math.max(result, num + 1);
                                break outer;
                            } else {
                                map.get(num + 1).offer(envelope);
                                result = Math.max(result, num);
                                break outer;
                            }
                        }
                    }
                }

                if (!flag) {
                    map.get(1).offer(envelope);
                }
            }
        }
        return result;
    }
}
