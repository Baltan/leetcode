package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2951. Find the Peaks
 *
 * @author Baltan
 * @date 2023/12/4 23:21
 */
public class FindPeaks {
    public static void main(String[] args) {
        System.out.println(findPeaks(new int[]{2, 4, 4}));
        System.out.println(findPeaks(new int[]{1, 4, 3, 8, 5}));
    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        /**
         * 遍历判断每个元素是否同时大于它左右相邻的元素
         */
        for (int i = mountain.length - 2; i >= 1; i--) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}
