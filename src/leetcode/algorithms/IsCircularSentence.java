package leetcode.algorithms;

/**
 * Description: 2490. Circular Sentence
 *
 * @author Baltan
 * @date 2023/2/6 10:34
 */
public class IsCircularSentence {
    public static void main(String[] args) {
        System.out.println(isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(isCircularSentence("eetcode"));
        System.out.println(isCircularSentence("Leetcode is cool"));
    }

    public static boolean isCircularSentence(String sentence) {
        char[] charArray = sentence.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                /**
                 * 判断空格两边的字符是否相等
                 */
                if (charArray[i - 1] != charArray[i + 1]) {
                    return false;
                }
            }
        }
        /**
         * 判断句首和句尾的字符是否相等
         */
        return charArray[0] == charArray[length - 1];
    }
}
