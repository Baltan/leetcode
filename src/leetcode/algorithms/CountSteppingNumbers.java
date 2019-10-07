package leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1215. Stepping Numbers（5081. 步进数）
 *
 * @author Baltan
 * @date 2019-10-07 10:02
 */
public class CountSteppingNumbers {
    public static void main(String[] args) {
        System.out.println(countSteppingNumbers(0, 21));
        System.out.println(countSteppingNumbers(0, 2000000000));
        System.out.println(countSteppingNumbers(10, 15));
    }

    public static List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> result = new LinkedList<>();
        List<Long> allSteppingNumbers = new LinkedList<>();
        /**
         * 初始化list，从两位数步进数开始查找
         */
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        /**
         * 将[low,high]范围内的一位数加入到结果List中
         */
        for (int i = low; i <= Math.min(9, high); i++) {
            result.add(i);
        }

        getSteppingNumbers(high, list, allSteppingNumbers);

        for (long num : allSteppingNumbers) {
            if (num >= low && num <= high) {
                result.add((int) num);
            } else if (num > high) {
                break;
            }
        }
        return result;
    }

    /**
     * 查找所有[0,threshold]范围内的步进数
     *
     * @param threshold
     * @param list
     * @param allSteppingNumbers
     */
    public static void getSteppingNumbers(int threshold, List<Long> list,
                                          List<Long> allSteppingNumbers) {
        if (list.get(0) >= threshold) {
            return;
        }

        List<Long> result = new LinkedList<>();
        /**
         * 将list中的所有步进数最后追加一个数字，获得一个新的步进数，例如：
         * 1、步进数10最后追加一个数字可以获得步进数101；
         * 2、步进数56最后追加一个数字可以获得步进数565、567；
         * 3、步进数89最后追加一个数字可以获得步进数898
         */
        for (long num : list) {
            long unit = num % 10;

            if (unit == 0) {
                result.add(num * 10 + 1);
            } else if (unit > 0 && unit < 9) {
                result.add(num * 10 + unit - 1);
                result.add(num * 10 + unit + 1);
            } else if (unit == 9) {
                result.add(num * 10 + 8);
            }
        }
        allSteppingNumbers.addAll(result);
        getSteppingNumbers(threshold, result, allSteppingNumbers);
    }
}
