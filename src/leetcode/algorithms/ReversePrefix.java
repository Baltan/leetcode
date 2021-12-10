package leetcode.algorithms;

/**
 * Description: 2000. Reverse Prefix of Word
 *
 * @author Baltan
 * @date 2021/12/10 09:21
 */
public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }

    public static String reversePrefix(String word, char ch) {
        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ch) {
                int half = i / 2;
                /**
                 * 将符合条件的前半部分字符串颠倒顺序
                 */
                for (int j = 0; j <= half; j++) {
                    char temp = charArray[j];
                    charArray[j] = charArray[i - j];
                    charArray[i - j] = temp;
                }
                return new String(charArray);
            }
        }
        return word;
    }
}
