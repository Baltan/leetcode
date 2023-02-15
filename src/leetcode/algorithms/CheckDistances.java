package leetcode.algorithms;

/**
 * Description: 2399. Check Distances Between Same Letters
 *
 * @author Baltan
 * @date 2023/2/11 19:53
 */
public class CheckDistances {
    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public static boolean checkDistances(String s, int[] distance) {
        /**
         * isVisited[0]-isVisited[25]依次表示字符a-z已判断过
         */
        boolean[] isVisited = new boolean[26];
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            int index = c - 'a';

            if (isVisited[index]) {
                continue;
            }
            /**
             * 如果字符串s是一个匀整字符串，则索引j处的字符应该和索引i处的字符相同
             */
            int j = i + distance[index] + 1;

            if (j >= length || charArray[j] != c) {
                return false;
            }
            isVisited[index] = true;
        }
        return true;
    }
}
