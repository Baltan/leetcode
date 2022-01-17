package leetcode.algorithms;

/**
 * Description: 2139. Minimum Moves to Reach Target Score
 *
 * @author Baltan
 * @date 2022/1/17 09:05
 */
public class MinMoves1 {
    public static void main(String[] args) {
        System.out.println(minMoves(5, 0));
        System.out.println(minMoves(19, 2));
        System.out.println(minMoves(10, 4));
        System.out.println(minMoves(1000000000, 4));
        System.out.println(minMoves(1000000000, 10));
        System.out.println(minMoves(1000000000, 100));
    }

    public static int minMoves(int target, int maxDoubles) {
        int result = 0;
        /**
         * 总是应该把翻倍的机会留到后面用，因为可以使得数字靠近target的速度更快，于是可以从target开始倒推回1，如果target是偶
         * 数，将target除以2；如果target是奇数并且还有翻倍的机会，将target先减去1；如果target是奇数并且没有翻倍的机会，则只
         * 能逐步减1直到最后得到1，直接返回加上需要操作的总步数即可
         */
        while (target > 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;
                result++;
            } else if (maxDoubles > 0) {
                target -= 1;
                result++;
            } else {
                result += (target - 1);
                target = 1;
            }
        }
        return result;
    }
}
