package leetcode.algorithms;


/**
 * Description: 1750. Minimum Length of String After Deleting Similar Ends
 *
 * @author Baltan
 * @date 2022/8/1 09:28
 */
public class MinimumLength1 {
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }

    public static int minimumLength(String s) {
        char[] charArray = s.toCharArray();
        int lo = 0;
        int hi = charArray.length - 1;
        /**
         * 如果lo大于等于hi，即s的长度小于2，则不符合第3个条件；如果s的第一个字符和s的最后一个字符不同，则不符合第4个条件
         */
        while (lo < hi && charArray[lo] == charArray[hi]) {
            char c = charArray[lo];
            /**
             * 查找s中符合条件的最长非空前缀
             */
            while (lo <= hi && charArray[lo] == c) {
                lo++;
            }
            /**
             * 查找s中符合条件的最长非空后缀
             */
            while (hi >= lo && charArray[hi] == c) {
                hi--;
            }
        }
        return hi - lo + 1;
    }
}
