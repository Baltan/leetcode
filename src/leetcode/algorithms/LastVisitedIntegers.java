package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description: 2899. Last Visited Integers
 *
 * @author Baltan
 * @date 2023/10/16 23:51
 */
public class LastVisitedIntegers {
    public static void main(String[] args) {
        System.out.println(lastVisitedIntegers(Arrays.asList("1", "2", "prev", "prev", "prev")));
        System.out.println(lastVisitedIntegers(Arrays.asList("1", "prev", "2", "prev", "prev")));
    }

    public static List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> result = new ArrayList<>();
        /**
         * 保存目前为止遍历过的所有整数
         */
        List<Integer> nums = new ArrayList<>();
        /**
         * 到当前位置为止的连续字符串"prev"的数量
         */
        int k = 0;

        for (String word : words) {
            if (!Objects.equals(word, "prev")) {
                nums.add(Integer.valueOf(word));
                k = 0;
            } else {
                k++;
                /**
                 * nums从后往前数下标为k-1的元素，即从前往后数下标为nums.size()-k的元素
                 */
                result.add(k > nums.size() ? -1 : nums.get(nums.size() - k));
            }
        }
        return result;
    }
}
