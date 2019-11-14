package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 851. Loud and Rich
 *
 * @author Baltan
 * @date 2019-11-14 18:51
 */
public class LoudAndRich {
    public static void main(String[] args) {
        int[][] richer1 = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet1 = {3, 2, 5, 4, 6, 1, 7, 0};
        OutputUtils.print1DIntegerArray(loudAndRich(richer1, quiet1));

        int[][] richer2 = {{0, 1}, {1, 2}};
        int[] quiet2 = {0, 1, 2};
        OutputUtils.print1DIntegerArray(loudAndRich(richer2, quiet2));
    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int length = quiet.length;
        int[] result = new int[length];
        /**
         * 数组保存钱不比某一个人少的所有人的编号，例如：数组索引为0的位置的列表保存所有钱不比编号为0的人少的人的编号
         */
        List<Integer>[] richersArray = new LinkedList[length];
        /**
         * 每个人自己拥有的钱都不比自己少，先将自己的编号加入
         */
        for (int i = 0; i < length; i++) {
            richersArray[i] = new LinkedList<>();
            richersArray[i].add(i);
        }
        /**
         * 将其他钱不比自己少的人的编号加入
         */
        for (int[] pair : richer) {
            int x = pair[0];
            int y = pair[1];
            richersArray[y].add(x);
        }

        for (int i = 0; i < length; i++) {
            /**
             * 标记某个人是否已经和当前对象比较过钱的多少
             */
            boolean[] isVisited = new boolean[length];
            /**
             * 钱不比当前对象少的人中最安静的人的安静值，初始化为当前对象本人的安静值
             */
            int minQuietness = quiet[i];
            /**
             * 钱不比当前少的人中最安静的人的编号，初始化为当前对象本人的编号
             */
            int quietestCode = i;
            Queue<Integer> richers = new LinkedList<>(richersArray[i]);

            while (!richers.isEmpty()) {
                int richerCode = richers.poll();
                /**
                 * 如果当前比较的人更加安静，更新minQuietness和quietestCode
                 */
                if (quiet[richerCode] < minQuietness) {
                    minQuietness = quiet[richerCode];
                    quietestCode = richerCode;
                }
                /**
                 * 标记当前比较的人已经比较过，后续不会再做比较
                 */
                isVisited[richerCode] = true;
                /**
                 * 将比"那些比当前对象富裕（包含钱相等的情况）的人"还要富裕（包含钱相等的情况）的人的标号加入队列中
                 */
                for (int code : richersArray[richerCode]) {
                    if (!isVisited[code]) {
                        richers.offer(code);
                    }
                }
            }
            result[i] = quietestCode;
        }
        return result;
    }
}
