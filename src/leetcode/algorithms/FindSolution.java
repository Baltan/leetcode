package leetcode.algorithms;

import leetcode.entity.CustomFunction;
import leetcode.entity.CustomFunctionImpl1;
import leetcode.entity.CustomFunctionImpl2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 1237. Find Positive Integer Solution for a Given Equation
 *
 * @author Baltan
 * @date 2019-10-28 09:13
 */
public class FindSolution {
    public static void main(String[] args) {
        CustomFunctionImpl1 f1 = new CustomFunctionImpl1();
        System.out.println(findSolution(f1, 5));

        CustomFunctionImpl2 f2 = new CustomFunctionImpl2();
        System.out.println(findSolution(f2, 5));
    }

    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new LinkedList<>();
        /**
         * 对于给定范围中的每一个x∈[1,1000]，二分查找是否存在y，使得f(x,y)==z
         */
        for (int i = 1; i <= 1000; i++) {
            int lo = 1;
            int hi = 1000;

            while (lo <= hi) {
                int mid = (lo + hi) >> 1;

                if (customfunction.f(i, mid) == z) {
                    result.add(Arrays.asList(i, mid));
                    break;
                } else if (customfunction.f(i, mid) < z) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return result;
    }
}
