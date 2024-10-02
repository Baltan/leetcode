package leetcode.algorithms;

/**
 * Description: 3305. Count of Substrings Containing Every Vowel and K Consonants I
 *
 * @author Baltan
 * @date 2024/10/2 14:57
 */
public class CountOfSubstrings {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq", 1));
        System.out.println(countOfSubstrings("aeiou", 0));
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public static int countOfSubstrings(String word, int k) {
        int result = 0;
        int length = word.length();
        /**
         * 符合条件的字符串至少包含5个元音字母和k个辅音字母，所以长度至少为k+5。遍历所有以word[i]开头的子串，判断是否符合条件
         */
        for (int i = 0; i <= length - k - 5; i++) {
            /**
             * vowelBits的二进制值由低到高五位为1时，依次代表子串中存在元音字母a、e、i、o、u，当子串中五种元音字母都存在时，vowelBits的
             * 值为0b11111
             */
            int vowelBits = 0;
            /**
             * 子串中辅音字母的个数
             */
            int consonantCount = 0;

            for (int j = i; j < length && consonantCount <= k; j++) {
                char c = word.charAt(j);
                switch (c) {
                    case 'a':
                        vowelBits |= 1;
                        break;
                    case 'e':
                        vowelBits |= 1 << 1;
                        break;
                    case 'i':
                        vowelBits |= 1 << 2;
                        break;
                    case 'o':
                        vowelBits |= 1 << 3;
                        break;
                    case 'u':
                        vowelBits |= 1 << 4;
                        break;
                    default:
                        consonantCount++;
                }

                if (vowelBits == 0b11111 && consonantCount == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
