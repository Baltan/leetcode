package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3766. Minimum Operations to Make Binary Palindrome
 *
 * @author baltan
 * @date 2026/1/28 16:53
 */
public class MinOperations32 {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(minOperations(new int[]{3664}));
        OutputUtils.print1DIntegerArray(minOperations(new int[]{1, 2, 4}));
        OutputUtils.print1DIntegerArray(minOperations(new int[]{6, 7, 12}));
    }

    public static int[] minOperations(int[] nums) {
        int[] result = new int[nums.length];
        /**
         * 数组nums中的最大值
         */
        int max = Arrays.stream(nums).max().getAsInt();
        /**
         * 升序保存[0,max]中的所有回文数
         */
        List<Integer> palindromes = new ArrayList<>();
        palindromes.add(0);
        /**
         * 计算[1,max]中的所有回文数
         */
        for (int i = 1; i <= max; i++) {
            if (isPalindrome(Integer.toBinaryString(i))) {
                palindromes.add(i);
            }
        }
        /**
         * 将大于max的最小的回文数加入数组
         */
        palindromes.add(getGreaterPalindrome(max));

        for (int i = 0; i < nums.length; i++) {
            int prevPalindrome = getPrevPalindrome(nums[i], palindromes);
            int nextPalindrome = getNextPalindrome(nums[i], palindromes);
            result[i] = Math.min(nums[i] - prevPalindrome, nextPalindrome - nums[i]);
        }
        return result;
    }

    /**
     * 判断字符串s表示的数字是否是回文数
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;

        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    /**
     * 计算大于max的最小的回文数
     *
     * @param max
     * @return
     */
    public static int getGreaterPalindrome(int max) {
        for (int i = max + 1; ; i++) {
            if (isPalindrome(Integer.toBinaryString(i))) {
                return i;
            }
        }
    }

    /**
     * 二分查找数组palindromes中不大于num的最大的回文数
     *
     * @param num
     * @param palindromes
     * @return
     */
    public static int getPrevPalindrome(int num, List<Integer> palindromes) {
        int lo = 0;
        int hi = palindromes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (palindromes.get(mid) > num) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return palindromes.get(lo);
    }

    /**
     * 二分查找数组palindromes中不小于num的最小的回文数
     *
     * @param num
     * @param palindromes
     * @return
     */
    public static int getNextPalindrome(int num, List<Integer> palindromes) {
        int lo = 0;
        int hi = palindromes.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (palindromes.get(mid) < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return palindromes.get(lo);
    }
}
