package leetcode.algorithms;

/**
 * Description: 3233. Find the Count of Numbers Which Are Not Special
 *
 * @author baltan
 * @date 2024/7/29 09:16
 */
public class NonSpecialCount {
    public static void main(String[] args) {
        System.out.println(nonSpecialCount(1, 2));
        System.out.println(nonSpecialCount(5, 7));
        System.out.println(nonSpecialCount(4, 16));
        System.out.println(nonSpecialCount(1, 1000000000));
        System.out.println(nonSpecialCount(511518329, 717750954));
    }

    public static int nonSpecialCount(int l, int r) {
        int result = r - l + 1;
        outer:
        for (int i = 2; i * i <= r; i++) {
            if (i * i < l) {
                continue;
            }
            int num = i * i;

            for (int j = 2; j * j < num; j++) {
                if (num % j == 0) {
                    continue outer;
                }
            }
            result--;
        }
        return result;
    }
}
