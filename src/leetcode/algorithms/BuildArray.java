package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1441. Build an Array With Stack Operations
 *
 * @author Baltan
 * @date 2020-05-15 16:52
 */
public class BuildArray {
    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1, 3}, 3));
        System.out.println(buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(buildArray(new int[]{1, 2}, 4));
        System.out.println(buildArray(new int[]{2, 3, 4}, 4));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        int length = target.length;
        int currNum = 1;
        /**
         * 对target中的每个数字逐一判断，直到所有数字都完成操作
         */
        for (int i = 0; i < length; ) {
            int value = target[i];
            /**
             * 如果value>currNum，说明currNum不在target中，对currNum执行先Push再Pop的操作，否则对currNum执行
             * Push操作
             */
            if (value > currNum) {
                result.add("Push");
                result.add("Pop");
                currNum++;
            } else {
                result.add("Push");
                currNum++;
                i++;
            }
        }
        return result;
    }
}
