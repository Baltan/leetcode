package leetcode.algorithms;

/**
 * Description: 788. Rotated Digits
 *
 * @author Baltan
 * @date 2018/8/1 14:59
 */
public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

    public static int rotatedDigits(int N) {
        int num = 0;
        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            if (str.contains("3") || str.contains("4") || str.contains("7")) {
                continue;
            } else if (!str.contains("2") && !str.contains("5") && !str.contains("6") && !str.contains("9")) {
                continue;
            } else {
                num++;
            }
        }
        return num;
    }
}
