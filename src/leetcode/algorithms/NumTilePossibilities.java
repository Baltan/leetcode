package leetcode.algorithms;

/**
 * Description: 1079. Letter Tile Possibilities
 *
 * @author Baltan
 * @date 2019-07-11 11:20
 */
public class NumTilePossibilities {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
    }

    public static int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        int length = tiles.length();

        for (int i = 0; i < length; i++) {
            char c = tiles.charAt(i);
            arr[c - 'A']++;
        }
        return help(arr);
    }

    public static int help(int[] arr) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                /**
                 * 将长度为1的序列计入总数
                 */
                count++;
                arr[i]--;
                /**
                 * 计算剩余字母可以组成的序列的数量，和上面删除的字母可以组成对应的序列，计入总数
                 */
                count += help(arr);
                arr[i]++;
            }
        }
        return count;
    }
}
