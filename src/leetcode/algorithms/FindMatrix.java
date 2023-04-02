package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2610. Convert an Array Into a 2D Array With Conditions
 *
 * @author Baltan
 * @date 2023/4/2 18:25
 */
public class FindMatrix {
    public static void main(String[] args) {
        System.out.println(findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(findMatrix(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /**
         * counts[i]表示遍历数组nums的过程中已经得到的元素i的个数
         */
        int[] counts = new int[201];
        /**
         * 将遍历数组nums的过程中第x个（1-based）得到的元素num放在result的第x-1个元素的列表中
         */
        for (int num : nums) {
            /**
             * result中已有的元素的列表中都包含了元素num，在result中新加入一个列表元素
             */
            if (counts[num] >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(counts[num]).add(num);
            /**
             * 记录元素num在数组nums中已出现的次数
             */
            counts[num]++;
        }
        return result;
    }
}
