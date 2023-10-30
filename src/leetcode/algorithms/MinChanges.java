package leetcode.algorithms;

/**
 * Description: 2914. Minimum Number of Changes to Make Binary String Beautiful
 *
 * @author baltan
 * @date 2023/10/30 11:44
 */
public class MinChanges {
    public static void main(String[] args) {
        System.out.println(minChanges("1001"));
        System.out.println(minChanges("10"));
        System.out.println(minChanges("0000"));
    }

    public static int minChanges(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        /**
         * 因为每个子串的长度都为偶数，所以字符串s中索引为2k和2k+1的两个字符最终一定在同一个子串中，统计这样相邻的两个字符不一样的情况即可
         */
        for (int i = 0; i < charArray.length; i += 2) {
            if (charArray[i] != charArray[i + 1]) {
                result++;
            }
        }
        return result;
    }
}
