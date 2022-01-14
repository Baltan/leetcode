package leetcode.algorithms;

/**
 * Description: LCP 17. 速算机器人
 *
 * @author Baltan
 * @date 2022/1/14 13:47
 */
public class Calculate2 {
    public static void main(String[] args) {
        System.out.println(calculate("AB"));
    }

    public static int calculate(String s) {
        int x = 1;
        int y = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }
}
