package leetcode.algorithms;

/**
 * Description: 2486. Append Characters to String to Make Subsequence
 *
 * @author Baltan
 * @date 2022/11/29 16:57
 */
public class AppendCharacters {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("z", "abcde"));
    }

    public static int appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();

        while (tIndex < tLength) {
            char c = t.charAt(tIndex);
            /**
             * 字符串s.substring(sIndex)子串中是否匹配到字符t[tIndex]
             */
            boolean find = false;
            /**
             * 从s[sIndex]开始匹配字符t[tIndex]，直到匹配到为止
             */
            while (sIndex < sLength) {
                if (s.charAt(sIndex) == c) {
                    find = true;
                    sIndex++;
                    tIndex++;
                    break;
                } else {
                    sIndex++;
                }
            }
            /**
             * 字符t[tIndex]没有被匹配到，结束匹配，t.substring(tIndex)子串中的字符都是需要被追加到字符串s最后的
             */
            if (!find) {
                break;
            }
        }
        return tLength - tIndex;
    }
}
