package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 2895. Minimum Processing Time
 *
 * @author baltan
 * @date 2023/10/9 10:54
 */
public class MinProcessingTime {
    public static void main(String[] args) {
        System.out.println(minProcessingTime(Arrays.asList(8, 10), Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5)));
        System.out.println(minProcessingTime(Arrays.asList(10, 20), Arrays.asList(2, 3, 1, 2, 5, 8, 4, 3)));
    }

    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int result = 0;
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        /**
         * 将耗时越短的任务分配给最早空闲时间越晚的处理器
         */
        for (int i = 0; i < processorTime.size(); i++) {
            result = Math.max(result, processorTime.get(i) + tasks.get(i * 4));
        }
        return result;
    }
}
