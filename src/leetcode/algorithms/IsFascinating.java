package leetcode.algorithms;

/**
 * Description: 2729. Check if The Number is Fascinating
 *
 * @author Baltan
 * @date 2023/6/14 23:02
 */
public class IsFascinating {
    public static void main(String[] args) {
        System.out.println(isFascinating(192));
        System.out.println(isFascinating(100));
        System.out.println(isFascinating(134));
    }

    public static boolean isFascinating(int n) {
        /**
         * isVisited[1]-isVisited[9]依次表示是否得到过数字1-9
         */
        boolean[] isVisited = new boolean[10];

        for (int i = 1; i <= 3; i++) {
            int num = n * i;

            while (num > 0) {
                int digit = num % 10;
                /**
                 * 出现了数字0或者出现了重复的数字，则数字n不是迷人的
                 */
                if (digit == 0 || isVisited[digit]) {
                    return false;
                }
                isVisited[digit] = true;
                num /= 10;
            }
        }
        return true;
    }
}
