package leetcode.algorithms;

/**
 * Description: 2957. Remove Adjacent Almost-Equal Characters
 *
 * @author Baltan
 * @date 2023/12/10 16:06
 */
public class RemoveAlmostEqualCharacters {
    public static void main(String[] args) {
        System.out.println(removeAlmostEqualCharacters("aaaaa"));
        System.out.println(removeAlmostEqualCharacters("abddez"));
        System.out.println(removeAlmostEqualCharacters("zyxyxyz"));
    }

    public static int removeAlmostEqualCharacters(String word) {
        int result = 0;
        int length = word.length();
        /**
         * 相邻的两个字母都几乎相等的子串的长度
         */
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                count++;
            } else {
                /**
                 * 对于之前已得到的长度为count的子串，因为子串中相邻字母都是几乎相等的，只需要将子串中每隔一个的字母都替换成其他字母即可
                 */
                result += count / 2;
                count = 1;
            }
        }
        /**
         * 累加字符串word中最后一个子串的操作次数
         */
        return result + count / 2;
    }
}
