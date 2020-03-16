package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 46. Permutations
 *
 * @author Baltan
 * @date 2018/9/14 09:38
 * @see Permute1
 * @see PermuteUnique
 * @see PermuteUnique1
 * @see leetcode.interview.Permutation
 * @see leetcode.interview.Permutation1
 */
public class Permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Arrays.asList(Arrays.asList());
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        for (int num : nums) {
            numList.add(num);
        }

        if (numList.size() == 1) {
            result.add(numList);
            return result;
        } else {
            /**
             * 考虑以每个字符开头的所有排列
             */
            for (int i = 0; i < nums.length; i++) {
                int currNum = numList.get(i);
                /**
                 * 当前数字在递归查找其他数字的所有排列的过程中不会再出现，暂时从numList中移除
                 */
                numList.remove(new Integer(currNum));
                int[] array = new int[numList.size()];

                for (int j = 0; j < numList.size(); j++) {
                    array[j] = numList.get(j);
                }
                /**
                 * 递归获得剩余的其他数字的所有排列
                 */
                List<List<Integer>> list = permute(array);
                /**
                 * 将其他数字得到的所有排列开头加上当前开头的数字currNum
                 */
                for (List<Integer> ele : list) {
                    ele.add(0, currNum);
                    result.add(ele);
                }
                /**
                 * 还原numList到初始状态
                 */
                numList.add(i, currNum);
            }
        }
        return result;
    }
}
