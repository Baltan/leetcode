package leetcode.algorithms;

/**
 * Description: 2063. Vowels of All Substrings
 *
 * @author Baltan
 * @date 2021/11/17 09:59
 */
public class CountVowels {
    public static void main(String[] args) {
        System.out.println(countVowels("aba"));
        System.out.println(countVowels("abc"));
        System.out.println(countVowels("ltcd"));
        System.out.println(countVowels("noosabasboosa"));
    }

    public static long countVowels(String word) {
        long result = 0L;
        char[] charArray = word.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' ||
                    charArray[i] == 'o' || charArray[i] == 'u') {
                /**
                 * 字符charArray[i]前面部分字符串的长度
                 */
                int prevLength = i;
                /**
                 * 字符charArray[i]后面部分字符串的长度
                 */
                int nextLength = length - 1 - i;
                /**
                 * 字符charArray[i]前后可能拼接的字符串两两组合，即为包含字符charArray[i]的所有可能的
                 * 字符串，也就可以得到字符charArray[i]在所有子字符串中出现的总次数
                 */
                result += 1L * (prevLength + 1) * (nextLength + 1);
            }
        }
        return result;
    }
}
