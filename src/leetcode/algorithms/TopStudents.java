package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: 2512. Reward Top K Students
 *
 * @author Baltan
 * @date 2022/12/29 11:00
 */
public class TopStudents {
    public static void main(String[] args) {
        String[] positive_feedback1 = {"smart", "brilliant", "studious"};
        String[] negative_feedback1 = {"not"};
        String[] report1 = {"this student is studious", "the student is smart"};
        int[] student_id1 = {1, 2};
        int k1 = 2;
        System.out.println(topStudents(positive_feedback1, negative_feedback1, report1, student_id1, k1));

        String[] positive_feedback2 = {"smart", "brilliant", "studious"};
        String[] negative_feedback2 = {"not"};
        String[] report2 = {"this student is not studious", "the student is smart"};
        int[] student_id2 = {1, 2};
        int k2 = 2;
        System.out.println(topStudents(positive_feedback2, negative_feedback2, report2, student_id2, k2));
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveWords = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> negativeWords = Arrays.stream(negative_feedback).collect(Collectors.toSet());
        Integer[] indexes = IntStream.range(0, student_id.length).boxed().toArray(Integer[]::new);
        /**
         * 计算每个学生的得分
         */
        Integer[] scores = Arrays.stream(indexes).map(x -> getScore(positiveWords, negativeWords, report[x].split(" "))).toArray(Integer[]::new);
        /**
         * 将所有学生的索引值先按照评语得分降序排列，如果得分相同则按照id升序排列
         */
        Arrays.sort(indexes, (x, y) -> Objects.equals(scores[x], scores[y]) ? student_id[x] - student_id[y] : scores[y] - scores[x]);
        /**
         * 取排在最前面的k个学生的id
         */
        return Arrays.stream(indexes).map(x -> student_id[x]).limit(k).collect(Collectors.toList());
    }

    /**
     * 计算评语单词数组reportWords的总得分
     *
     * @param positiveWords
     * @param negativeWords
     * @param reportWords
     * @return
     */
    public static int getScore(Set<String> positiveWords, Set<String> negativeWords, String[] reportWords) {
        int score = 0;

        for (String word : reportWords) {
            if (positiveWords.contains(word)) {
                score += 3;
            } else if (negativeWords.contains(word)) {
                score -= 1;
            }
        }
        return score;
    }
}
