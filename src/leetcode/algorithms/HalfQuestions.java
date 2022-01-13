package leetcode.algorithms;

import java.util.*;

/**
 * Description: LCS 02. 完成一半题目
 *
 * @author Baltan
 * @date 2022/1/13 20:02
 */
public class HalfQuestions {
    public static void main(String[] args) {
        System.out.println(halfQuestions(new int[]{2, 1, 6, 2}));
        System.out.println(halfQuestions(new int[]{1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6}));
    }

    public static int halfQuestions(int[] questions) {
        int result = 0;
        /**
         * 人数
         */
        int persons = questions.length / 2;
        /**
         * 知识点类型 -> 该种知识点类型题目的数量
         */
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int question : questions) {
            countMap.put(question, countMap.getOrDefault(question, 0) + 1);
        }
        /**
         * 将所有类型的知识点按照题目数量排序
         */
        List<Integer> list = new ArrayList<>(countMap.values());
        Collections.sort(list);
        int index = list.size() - 1;

        while (persons > 0) {
            result++;
            /**
             * 优先选择题目最多的知识点类型
             */
            persons -= list.get(index--);
        }
        return result;
    }
}
