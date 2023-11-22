package leetcode.algorithms;

/**
 * Description: 2937. Make Three Strings Equal
 *
 * @author baltan
 * @date 2023/11/20 14:22
 */
public class FindMinimumOperations {
    public static void main(String[] args) {
        System.out.println(findMinimumOperations("abc", "abb", "ab"));
        System.out.println(findMinimumOperations("dac", "bac", "cac"));
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        int index = 0;
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        /**
         * 计算字符串s1、s2、s3的最长公共前缀
         */
        while (index < minLength && s1.charAt(index) == s2.charAt(index) && s2.charAt(index) == s3.charAt(index)) {
            index++;
        }
        /**
         * 如果字符串s1、s2、s3没有最长公共前缀，说明不能完成操作
         */
        if (index == 0) {
            return -1;
        }
        /**
         * 三个字符串各自除去最长公共前缀后的后缀就是需要被操作删除的部分
         */
        return s1.length() + s2.length() + s3.length() - index * 3;
    }
}
