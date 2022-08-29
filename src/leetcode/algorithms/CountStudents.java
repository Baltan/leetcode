package leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 1700. Number of Students Unable to Eat Lunch
 *
 * @author Baltan
 * @date 2022/8/24 09:10
 */
public class CountStudents {
    public static void main(String[] args) {
        int[] students1 = {1, 1, 0, 0};
        int[] sandwiches1 = {0, 1, 0, 1};
        System.out.println(countStudents(students1, sandwiches1));

        int[] students2 = {1, 1, 1, 0, 0, 1};
        int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students2, sandwiches2));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        int sandwichIndex = 0;

        for (int student : students) {
            studentQueue.offer(student);
        }
        /**
         * 当前学生队列中所有学生都完成一次三明治匹配作为一轮判断，上一轮判断中是否有学生拿走了三明治
         */
        boolean isMatch = true;

        while (isMatch && studentQueue.size() > 0) {
            isMatch = false;
            int size = studentQueue.size();

            for (int i = 0; i < size; i++) {
                int student = studentQueue.poll();
                int sandwich = sandwiches[sandwichIndex];
                /**
                 * 如果当前学生和栈顶的三明治匹配，则学生离开队伍，栈顶的三明治被拿走，并且标记本轮判断中有学生拿走了三明治；否
                 * 则当前学生排到队尾
                 */
                if (student == sandwich) {
                    sandwichIndex++;
                    isMatch = true;
                } else {
                    studentQueue.offer(student);
                }
            }
        }
        return studentQueue.size();
    }
}
