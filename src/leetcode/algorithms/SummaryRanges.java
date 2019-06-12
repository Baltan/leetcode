package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 228. Summary Ranges
 *
 * @author Baltan
 * @date 2019-06-12 09:51
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(summaryRanges(new int[]{-3}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int length = nums.length;
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                end = nums[i];
            } else {
                if (end == start) {
                    String s = start + "";
                    result.add(s);
                } else {
                    String s = start + "->" + end;
                    result.add(s);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (end == start) {
            String s = start + "";
            result.add(s);
        } else {
            String s = start + "->" + end;
            result.add(s);
        }
        return result;
    }
}
