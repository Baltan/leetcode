package leetcode.algorithms;

/**
 * Description: 1880. Check if Word Equals Summation of Two Words
 *
 * @author Baltan
 * @date 2022/5/15 12:34
 */
public class IsSumEqual {
    public static void main(String[] args) {
        System.out.println(isSumEqual("acb", "cba", "cdb"));
        System.out.println(isSumEqual("aaa", "a", "aab"));
        System.out.println(isSumEqual("aaa", "a", "aaaa"));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return convert(firstWord) + convert(secondWord) == convert(targetWord);
    }

    /**
     * 将字符串转化为对应的数字
     *
     * @param word
     * @return
     */
    public static int convert(String word) {
        int result = 0;
        /**
         * 数位的权重，从个位往上依次为1、10、100……
         */
        int weight = 1;

        for (int i = word.length() - 1; i >= 0; i--) {
            result += (word.charAt(i) - 'a') * weight;
            weight *= 10;
        }
        return result;
    }
}
