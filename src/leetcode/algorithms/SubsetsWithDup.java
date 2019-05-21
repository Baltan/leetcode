package leetcode.algorithms;

import java.util.*;

/**
 * Description: 90. Subsets II
 *
 * @author Baltan
 * @date 2019-05-20 11:01
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 3, 4}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2, 3, 3, 3, 4, 4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        List<Integer> numList = new ArrayList<>(length);

        for (int num : nums) {
            numList.add(num);
        }

        for (int i = 1; i <= length; i++) {
            result.addAll(help(numList, i));
        }
        return result;
    }

    public static List<List<Integer>> help(List<Integer> numList, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = numList.size();

        if (k == 1) {
            for (int i = 0; i < length; i++) {
                if (i == 0 || !Objects.equals(numList.get(i), numList.get(i - 1))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numList.get(i));
                    result.add(list);
                }
            }
        } else {
            List<List<Integer>> list = help(numList, k - 1);

            for (List<Integer> ele : list) {
                List<Integer> copyNums = new ArrayList<>(length);

                for (int num : numList) {
                    copyNums.add(num);
                }

                for (int num : ele) {
                    copyNums.remove(new Integer(num));
                }

                int copyNumLength = copyNums.size();
                int lastNum = ele.get(ele.size() - 1);

                for (int i = 0; i < copyNumLength; i++) {
                    int num = copyNums.get(i);
                    if ((i == 0 || !Objects.equals(num, copyNums.get(i - 1))) && num >= lastNum) {
                        ArrayList<Integer> nums = new ArrayList<>(ele);
                        nums.add(num);
                        result.add(nums);
                    }
                }
            }
        }
        return result;
    }
}
