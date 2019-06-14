package leetcode.algorithms;

/**
 * Description: 275. H-Index II
 *
 * @author Baltan
 * @date 2019-06-14 10:44
 */
public class HIndex1 {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations1));

        int[] citations2 = {1, 1, 1, 1, 1};
        System.out.println(hIndex(citations2));

        int[] citations3 = {3};
        System.out.println(hIndex(citations3));

        int[] citations4 = {1, 4};
        System.out.println(hIndex(citations4));

        int[] citations5 = {1, 4, 5, 4, 0, 0, 5, 3, 1, 4, 7, 9, 5, 3, 2, 3, 5, 6, 8, 3, 2, 4, 5, 7, 5, 3, 2};
        System.out.println(hIndex(citations5));

        int[] citations6 = {};
        System.out.println(hIndex(citations6));

        int[] citations7 = {0};
        System.out.println(hIndex(citations7));
    }

    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int length = citations.length;

        if (citations[0] >= length) {
            return length;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (length - i < length && citations[length - i] >= i) {
                    return i;
                }
            }
            return citations[0];
        }
    }
}
