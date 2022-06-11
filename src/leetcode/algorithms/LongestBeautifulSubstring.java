package leetcode.algorithms;

/**
 * Description: 1839. Longest Substring Of All Vowels in Order
 *
 * @author Baltan
 * @date 2022/6/7 09:25
 */
public class LongestBeautifulSubstring {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(longestBeautifulSubstring("a"));
        System.out.println(longestBeautifulSubstring(
                "aeiuoiueioeuiouoeaueoeuoeauieuueiuaioueiauioeuoauoeuoauaiueioauieuiaeueiuaieuaioaueiuaeeaauiaouaouiaueioauieuaiouioaueouaioaiueioeauieuoueieuouiuiaoueouaoieuouaoueauaeoueoiueoaueiueoaeuoieauaouaeoiuaeoueiaueuaiue"));
    }

    public static int longestBeautifulSubstring(String word) {
        int result = 0;
        /**
         * 当前子串的长度
         */
        int length = 0;
        /**
         * 当前子串中不同元音的个数
         */
        int vowels = 0;
        char[] charArray = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                /**
                 * 如果前一个字符不存在或者不为'a'，则重新开始计算子串长度和子串中不同元音的个数；否则就将子串的长度加1
                 */
                if (i == 0 || charArray[i - 1] != 'a') {
                    length = 1;
                    vowels = 1;
                } else {
                    length++;
                }
            } else if (charArray[i] == 'e') {
                if (i > 0) {
                    /**
                     * 如果前一个字符为'a'，就将子串的长度和子串中不同元音的个数加1；如果前一个字符为'e'，就将子串的长度加1；
                     * 否则重新开始计算子串长度和子串中不同元音的个数
                     */
                    if (charArray[i - 1] == 'a') {
                        length++;
                        vowels++;
                    } else if (charArray[i - 1] == 'e') {
                        length++;
                    } else {
                        length = 0;
                        vowels = 0;
                    }
                }
            } else if (charArray[i] == 'i') {
                if (i > 0) {
                    /**
                     * 如果前一个字符为'e'，就将子串的长度和子串中不同元音的个数加1；如果前一个字符为'i'，就将子串的长度加1；
                     * 否则重新开始计算子串长度和子串中不同元音的个数
                     */
                    if (charArray[i - 1] == 'e') {
                        length++;
                        vowels++;
                    } else if (charArray[i - 1] == 'i') {
                        length++;
                    } else {
                        length = 0;
                        vowels = 0;
                    }
                }
            } else if (charArray[i] == 'o') {
                if (i > 0) {
                    /**
                     * 如果前一个字符为'i'，就将子串的长度和子串中不同元音的个数加1；如果前一个字符为'o'，就将子串的长度加1；
                     * 否则重新开始计算子串长度和子串中不同元音的个数
                     */
                    if (charArray[i - 1] == 'i') {
                        length++;
                        vowels++;
                    } else if (charArray[i - 1] == 'o') {
                        length++;
                    } else {
                        length = 0;
                        vowels = 0;
                    }
                }
            } else if (charArray[i] == 'u') {
                if (i > 0) {
                    /**
                     * 如果前一个字符为'o'，就将子串的长度和子串中不同元音的个数加1；如果前一个字符为'u'，就将子串的长度加1；
                     * 否则重新开始计算子串长度和子串中不同元音的个数
                     */
                    if (charArray[i - 1] == 'o') {
                        length++;
                        vowels++;
                    } else if (charArray[i - 1] == 'u') {
                        length++;
                    } else {
                        length = 0;
                        vowels = 0;
                    }
                    /**
                     * 如果当前子串中不同元音的个数达到了5个，则子串符合题目要求，更新最长子串的长度
                     */
                    if (vowels == 5) {
                        result = Math.max(result, length);
                    }
                }
            }
        }
        return result;
    }
}
