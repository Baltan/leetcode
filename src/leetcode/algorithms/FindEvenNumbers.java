package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 2094. Finding 3-Digit Even Numbers
 *
 * @author Baltan
 * @date 2021/12/7 22:30
 */
public class FindEvenNumbers {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(findEvenNumbers(new int[]{2, 1, 3, 0}));
        OutputUtils.print1DIntegerArray(findEvenNumbers(new int[]{2, 2, 8, 8, 2}));
        OutputUtils.print1DIntegerArray(findEvenNumbers(new int[]{3, 7, 5}));
        OutputUtils.print1DIntegerArray(findEvenNumbers(new int[]{0, 2, 0, 0}));
        OutputUtils.print1DIntegerArray(findEvenNumbers(new int[]{0, 0, 0}));
    }

    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> numbers = new ArrayList<>();
        /**
         * count[i]表示digits中i出现的次数
         */
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }
        /**
         * 依次查找以i结尾的符合条件的三位数
         */
        for (int i = 0; i < 10; i++) {
            /**
             * i为奇数或者i在digits中不存在，则以i结尾的符合条件的三位数不存在
             */
            if (i % 2 != 0 || count[i] == 0) {
                continue;
            }
            count[i]--;
            endWith(i, count, numbers);
            count[i]++;
        }

        int[] result = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }
        /**
         * 将结果排序
         */
        Arrays.sort(result);
        return result;
    }

    /**
     * 查找以end结尾的符合条件的三位数
     *
     * @param end
     * @param count
     * @param numbers
     */
    public static void endWith(int end, int[] count, List<Integer> numbers) {
        /**
         * 三位数十位和百位不含0的情况
         */
        for (int i = 1; i < 10; i++) {
            if (count[i] == 0) {
                continue;
            }
            count[i]--;

            for (int j = i; j < 10; j++) {
                if (count[j] == 0) {
                    continue;
                }
                numbers.add(i * 100 + j * 10 + end);

                if (i != j) {
                    numbers.add(j * 100 + i * 10 + end);
                }
            }
            count[i]++;
        }
        /**
         * 十位为0的情况
         */
        if (count[0] > 0) {
            for (int i = 1; i < 10; i++) {
                if (count[i] == 0) {
                    continue;
                }
                numbers.add(i * 100 + end);
            }
        }
    }
}
