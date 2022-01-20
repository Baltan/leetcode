package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1985. Find the Kth Largest Integer in the Array
 *
 * @author Baltan
 * @date 2022/1/20 16:20
 */
public class KthLargestNumber {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"3", "6", "7", "10"}, 4));
        System.out.println(kthLargestNumber(new String[]{"2", "21", "12", "1"}, 3));
        System.out.println(kthLargestNumber(new String[]{"0", "0"}, 2));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        /**
         * 将nums中的字符串降序排列，如果两个字符串长度相等，就按照字典顺序降序排列，否则长度大的字符串排在前面
         */
        Arrays.sort(nums, (x, y) -> x.length() == y.length() ? y.compareTo(x) : y.length() - x.length());
        return nums[k - 1];
    }
}
