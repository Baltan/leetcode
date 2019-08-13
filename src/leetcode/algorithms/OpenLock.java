package leetcode.algorithms;

import java.util.*;

/**
 * Description: 752. Open the Lock
 *
 * @author Baltan
 * @date 2019-08-13 11:35
 */
public class OpenLock {
    public static void main(String[] args) {
        String[] deadends1 = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends1, "0202"));

        String[] deadends2 = {"8888"};
        System.out.println(openLock(deadends2, "0009"));

        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(openLock(deadends3, "8888"));

        String[] deadends4 = {"0000"};
        System.out.println(openLock(deadends4, "8888"));
    }

    public static int openLock(String[] deadends, String target) {
        int result = 0;
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String str = "0000";
        /**
         * 将deadends中的死亡数字都保存到set中
         */
        for (String deadend : deadends) {
            set.add(deadend);
        }
        /**
         * 如果"0000"在set中，无法解锁，直接返回-1
         */
        if (set.contains(str)) {
            return -1;
        }
        /**
         * 将"0000"的每一位向前或向后旋转一位，获得的数字如果不是死亡数字，就加入到queue中，并且将该数字加入到set中，
         * 保证以后的操作不会重复获得该数字
         */
        for (int i = 0; i < 4; i++) {
            char c = str.charAt(i);
            char c1 = c == '0' ? '9' : (char) (c - 1);
            char c2 = c == '9' ? '0' : (char) (c + 1);
            String str1 = str.substring(0, i) + c1 + str.substring(i + 1);
            String str2 = str.substring(0, i) + c2 + str.substring(i + 1);

            if (!set.contains(str1)) {
                queue.offer(str1);
                set.add(str1);
            }

            if (!set.contains(str2)) {
                queue.offer(str2);
                set.add(str2);
            }
        }

        while (!queue.isEmpty()) {
            /**
             * 将操作的次数加1
             */
            result++;
            int size = queue.size();
            /**
             * 处理所有result次操作后获得的数字
             */
            for (int i = 0; i < size; i++) {
                str = queue.poll();

                if (Objects.equals(target, str)) {
                    return result;
                } else {
                    /**
                     * 将当前数字的每一位向前或向后旋转一位，获得的数字如果不是死亡数字，就加入到queue中，
                     * 并且将该数字加入到set中，保证以后的操作不会重复获得该数字
                     */
                    for (int j = 0; j < 4; j++) {
                        char c = str.charAt(j);
                        char c1 = c == '0' ? '9' : (char) (c - 1);
                        char c2 = c == '9' ? '0' : (char) (c + 1);
                        String str1 = str.substring(0, j) + c1 + str.substring(j + 1);
                        String str2 = str.substring(0, j) + c2 + str.substring(j + 1);

                        if (!set.contains(str1)) {
                            queue.offer(str1);
                            set.add(str1);
                        }

                        if (!set.contains(str2)) {
                            queue.offer(str2);
                            set.add(str2);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
