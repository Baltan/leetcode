package leetcode.algorithms;

/**
 * Description: 2135. Count Words Obtained After Adding a Letter
 *
 * @author Baltan
 * @date 2022/1/10 09:16
 */
public class WordCount {
    public static void main(String[] args) {
        System.out.println(wordCount(
                new String[]{"ant", "act", "tack"},
                new String[]{"tack", "act", "acti"}
        ));
        System.out.println(wordCount(
                new String[]{"ab", "a"},
                new String[]{"abc", "abcd"}
        ));
    }

    public static int wordCount(String[] startWords, String[] targetWords) {
        int result = 0;
        int[][] countArrays = new int[startWords.length][26];

        for (int i = 0; i < startWords.length; i++) {
            int[] countArray = new int[26];
            countArrays[i] = countArray;

            for (char c : startWords[i].toCharArray()) {
                countArray[c - 'a']++;
            }
        }

        for (String targetWord : targetWords) {
            int[] countArray = new int[26];

            for (char c : targetWord.toCharArray()) {
                countArray[c - 'a']++;
            }

            mid:
            for (int[] array : countArrays) {
                int count = 0;

                for (int i = 0; i < 26; i++) {
                    if (countArray[i] < array[i] || countArray[i] - array[i] > 1) {
                        continue mid;
                    } else if (countArray[i] - array[i] == 1) {
                        count++;
                    }
                }

                if (count == 1) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
