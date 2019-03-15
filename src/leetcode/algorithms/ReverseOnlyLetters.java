package leetcode.algorithms;

/**
 * Description: Reverse Only Letters
 *
 * @author Baltan
 * @date 2019-03-15 11:13
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public static String reverseOnlyLetters(String S) {
        int lo = 0;
        int hi = S.length() - 1;
        char[] charArray = S.toCharArray();

        while (lo <= hi) {
            char loChar = charArray[lo];

            if ((loChar >= 'a' && loChar <= 'z') || (loChar >= 'A' && loChar <= 'Z')) {
                char hiChar = charArray[hi];

                if ((hiChar >= 'a' && hiChar <= 'z') || (hiChar >= 'A' && hiChar <= 'Z')) {
                    char temp = loChar;
                    charArray[lo] = charArray[hi];
                    charArray[hi] = temp;
                    lo++;
                    hi--;
                } else {
                    hi--;
                    continue;
                }
            } else {
                lo++;
                continue;
            }
        }
        return new String(charArray);
    }
}
