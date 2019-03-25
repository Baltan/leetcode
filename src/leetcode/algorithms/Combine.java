package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Description: Combinations
 *
 * @author Baltan
 * @date 2019-03-25 09:41
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(6, 3));
        System.out.println(combine(10, 4));
        System.out.println(combine(5, 5));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (k > n || n < 1 || k < 1) {
            return result;
        }

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        return help(arr, k);
    }

    public static List<List<Integer>> help(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;

        if (k == 1) {
            for (int i = 0; i < length; i++) {
                List<Integer> list = new ArrayList<>(1);
                list.add(arr[i]);
                result.add(list);
            }
        } else {
            for (int i = 0; i <= length - k; i++) {
                int[] arr1 = Arrays.copyOfRange(arr, i + 1, arr.length);

                List<List<Integer>> list1 = help(arr1, k - 1);

                for (List<Integer> ele : list1) {
                    List<Integer> list = new ArrayList<>(k);
                    list.add(arr[i]);
                    list.addAll(ele);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
