package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Description: 433. Minimum Genetic Mutation
 *
 * @author Baltan
 * @date 2019-08-11 09:03
 */
public class MinMutation {
    public static void main(String[] args) {
        String[] bank1 = {"AACCGGTA"};
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank1));

        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", bank2));

        String[] bank3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", bank3));

        String[] bank4 = {};
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", bank4));
    }

    public static int minMutation(String start, String end, String[] bank) {
        int result = 0;
        int length = bank.length;
        Queue<String> queue = new LinkedList<>();
        /**
         * 标记已经变化过的基因
         */
        boolean[] isVisited = new boolean[length];
        /**
         * 查找所有起始基因变化一个字符可以获得的基因，加入队列
         */
        for (int i = 0; i < length; i++) {
            if (oneDifferentCharacter(bank[i], start)) {
                queue.offer(bank[i]);
                isVisited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            /**
             * 对所有变化了result次的基因进行进一步的变化筛选
             */
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                /**
                 * 如果当前基因已经和目标基因一致了，可以直接返回变化次数
                 */
                if (Objects.equals(currentGene, end)) {
                    return result;
                }
                /**
                 * 查找所有当前基因变化一个字符可以获得的基因，加入队列
                 */
                for (int j = 0; j < length; j++) {
                    if (!isVisited[j] && oneDifferentCharacter(bank[j], currentGene)) {
                        queue.offer(bank[j]);
                        isVisited[j] = true;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 判断两个字符串是否只有一个位置上的字符不一样
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean oneDifferentCharacter(String s1, String s2) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
