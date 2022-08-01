package leetcode.algorithms;

/**
 * Description: 1750. Minimum Length of String After Deleting Similar Ends
 *
 * @author Baltan
 * @date 2022/7/24 13:57
 */
public class MinimumLength {
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    public static int minimumLength(String s) {
        /**
         * 如果s的长度小于2，则不符合第3个条件，不能完成一次操作
         */
        while (s.length() > 1) {
            /**
             * 如果s的第一个字符和s的最后一个字符不同，则不符合第4个条件，不能完成一次操作，直接返回结果
             */
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                return s.length();
            }
            /**
             * 在s中可以找到的非空前缀的最大长度
             */
            int prefixLength = 1;
            /**
             * 在s中可以找到的非空后缀的最大长度
             */
            int suffixLength = 1;
            /**
             * 查找所有字符都相同的前缀
             */
            while (prefixLength < s.length() && s.charAt(prefixLength) == s.charAt(prefixLength - 1)) {
                prefixLength++;
            }
            /**
             * 说明s中剩余的字符全部相同，可以将s看做是由前缀和后缀拼接在一起的两部分，将s中的所有字符都删除
             */
            if (prefixLength == s.length()) {
                return 0;
            }
            /**
             * 查找所有字符都相同的后缀
             */
            while (suffixLength < s.length() &&
                    s.charAt(s.length() - suffixLength - 1) == s.charAt(s.length() - suffixLength)) {
                suffixLength++;
            }
            /**
             * 删除s的前缀和后缀中的所有字符，只保留中间剩余的部分
             */
            s = s.substring(prefixLength, s.length() - suffixLength);
        }
        return s.length();
    }
}
