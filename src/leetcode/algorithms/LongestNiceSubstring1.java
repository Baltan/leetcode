package leetcode.algorithms;

/**
 * Description: 1763. Longest Nice Substring
 *
 * @author Baltan
 * @date 2022/7/21 09:35
 */
public class LongestNiceSubstring1 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring("c"));
    }

    public static String longestNiceSubstring(String s) {
        String result = "";
        int length = s.length();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < length; i++) {
            StringBuilder builder = new StringBuilder();
            /**
             * lowerCases[0]-lowerCases[25]依次表示子串中是否包括小写字母a-z
             */
            boolean[] lowerCases = new boolean[26];
            /**
             * upperCases[0]-upperCases[25]依次表示子串中是否包括大写字母A-Z
             */
            boolean[] upperCases = new boolean[26];
            /**
             * 当前子串中大小写未匹配成对的字符个数
             */
            int unmatchedCharCount = 0;

            for (int j = i; j < length; j++) {
                char c = charArray[j];
                builder.append(c);

                if (Character.isUpperCase(c)) {
                    char lowerCase = Character.toLowerCase(c);
                    /**
                     * 子串追加字符c之前，如果本来就包含字符c和字符lowerCase，则字符c对unmatchedCharCount不构成影响；如果
                     * 本来包含字符lowerCase但是不包含字符c，则字符c可以使得unmatchedCharCount减1；如果本来包含字符c但是
                     * 不包含字符lowerCase，则字符c对unmatchedCharCount不构成影响；如果本来字符c和字符lowerCase都不包含，
                     * 则字符c可以使得unmatchedCharCount加1
                     */
                    if (!upperCases[c - 'A']) {
                        if (lowerCases[lowerCase - 'a']) {
                            unmatchedCharCount--;
                        } else {
                            unmatchedCharCount++;
                        }
                        upperCases[c - 'A'] = true;
                    }

                    if (unmatchedCharCount == 0 && builder.length() > result.length()) {
                        result = builder.toString();
                    }
                } else {
                    char upperCase = Character.toUpperCase(c);
                    /**
                     * 子串追加字符c之前，如果本来就包含字符c和字符upperCase，则字符c对unmatchedCharCount不构成影响；如果
                     * 本来包含字符upperCase但是不包含字符c，则字符c可以使得unmatchedCharCount减1；如果本来包含字符c但是
                     * 不包含字符upperCase，则字符c对unmatchedCharCount不构成影响；如果本来字符c和字符upperCase都不包含，
                     * 则字符c可以使得unmatchedCharCount加1
                     */
                    if (!lowerCases[c - 'a']) {
                        if (upperCases[upperCase - 'A']) {
                            unmatchedCharCount--;
                        } else {
                            unmatchedCharCount++;
                        }
                        lowerCases[c - 'a'] = true;
                    }

                    if (unmatchedCharCount == 0 && builder.length() > result.length()) {
                        result = builder.toString();
                    }
                }
            }
        }
        return result;
    }
}
