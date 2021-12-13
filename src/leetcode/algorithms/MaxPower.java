package leetcode.algorithms;

/**
 * Description: 1446. Consecutive Characters
 *
 * @author Baltan
 * @date 2021/12/13 18:13
 */
public class MaxPower {
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));
        System.out.println(maxPower("aaabbbbb"));
    }

    public static int maxPower(String s) {
        int result = 0;
        /**
         * 随机定义一个非小写字母的字符用于开始s的第一个字符的比较
         */
        char prevChar = ' ';
        /**
         * 当前只包含一种字符的子串长度
         */
        int count = 0;

        for (char currChar : s.toCharArray()) {
            if (currChar == prevChar) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
            prevChar = currChar;
        }
        return result;
    }
}
