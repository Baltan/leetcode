package leetcode.algorithms;

/**
 * Description: 2947. Count Beautiful Substrings I
 *
 * @author baltan
 * @date 2023/11/27 09:47
 */
public class BeautifulSubstrings {
    public static void main(String[] args) {
        System.out.println(beautifulSubstrings("baeyh", 2));
        System.out.println(beautifulSubstrings("abba", 1));
        System.out.println(beautifulSubstrings("bcdf", 1));
    }

    public static int beautifulSubstrings(String s, int k) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /**
         * vowelPrefixCounts[i]表示子串s.substring(0,i)中元音字母的个数
         */
        int[] vowelPrefixCounts = new int[length + 1];
        /**
         * consonantPrefixCounts[i]表示子串s.substring(0,i)中辅音字母的个数
         */
        int[] consonantPrefixCounts = new int[length + 1];

        for (int i = 0; i < length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                vowelPrefixCounts[i + 1] = vowelPrefixCounts[i] + 1;
                consonantPrefixCounts[i + 1] = consonantPrefixCounts[i];
            } else {
                vowelPrefixCounts[i + 1] = vowelPrefixCounts[i];
                consonantPrefixCounts[i + 1] = consonantPrefixCounts[i] + 1;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                /**
                 * 子串s.substring(i,j)中元音字母的个数
                 */
                int vowelCount = vowelPrefixCounts[j] - vowelPrefixCounts[i];
                /**
                 * 子串s.substring(i,j)中辅音字母的个数
                 */
                int consonantCount = consonantPrefixCounts[j] - consonantPrefixCounts[i];

                if (vowelCount == consonantCount && (vowelCount * consonantCount) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
