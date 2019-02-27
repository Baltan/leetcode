package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Permutations
 *
 * @author Baltan
 * @date 2018/9/14 09:38
 */
public class Permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        if (numList.size() == 1) {
            res.add(numList);
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
                int currNum = numList.get(i);
                numList.remove(new Integer(currNum));
                int[] array = new int[numList.size()];
                for (int j = 0; j < numList.size(); j++) {
                    array[j] = numList.get(j);
                }
                List<List<Integer>> list = permute(array);
                for (List<Integer> ele : list) {
                    ele.add(0, currNum);
                    res.add(ele);
                }
                numList.add(i, currNum);
            }
        }
        return res;
    }
}
