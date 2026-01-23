package leetcode.algorithms;

/**
 * Description: 3747. Count Distinct Integers After Removing Zeros
 *
 * @author baltan
 * @date 2026/1/22 14:30
 */
public class CountDistinct1 {
    public static void main(String[] args) {
        System.out.println(countDistinct(305));
        System.out.println(countDistinct(10));
        System.out.println(countDistinct(3));
    }

    public static long countDistinct(long n) {
        long result = 0L;
        String s = String.valueOf(n);
        int length = s.length();
        /**
         * counts[i]表示各个数位都不为0的i位数的情况数
         */
        long[] counts = new long[length];
        counts[0] = 1L;

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i - 1] * 9;
        }
        /**
         * 所有数位个数在[i,s.length())，且各个数位都不为0的数字都不大于n
         */
        for (int i = 1; i < s.length(); i++) {
            result += counts[i];
        }
        /**
         * result再累加不大于s，数位个数和s相同，且各个数位都不为0的数字的情况数
         */
        return result + getMaxLessEqual(s, counts);
    }

    /**
     * 计算不大于s，数位个数和s相同，且各个数位都不为0的数字的情况数
     *
     * @param s
     * @param counts
     * @return
     */
    public static long getMaxLessEqual(String s, long[] counts) {
        /**
         * 满足要求的数字范围为[1,s]
         */
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }
        int first = s.charAt(0) - '0';
        /**
         * 如果s的最高位first为0，则不存在不大于数字s，数位个数和s相同，且各个数位都不为0的数字。否则，最高位数字范围为[1,first-1]，数位个
         * 数和s相同，且各个数位都不为0的数字都满足要求，这部分数字个数为(first-1)*counts[s.length()-1]。再递归计算最高位数字为first，
         * 数位个数和s相同，且各个数位都不为0的数字，这部分数字的个数等于不大于s.substring(1)的数字的个数
         */
        return first == 0 ? 0 : (first - 1) * counts[s.length() - 1] + getMaxLessEqual(s.substring(1), counts);
    }
}
