package leetcode.algorithms;

/**
 * Description: 754. Reach a Number
 *
 * @author Baltan
 * @date 2019-03-17 11:18
 */
public class ReachNumber {
    public static void main(String[] args) {
        System.out.println(reachNumber(3));
        System.out.println(reachNumber(2));
        System.out.println(reachNumber(15));
        System.out.println(reachNumber(17));
        System.out.println(reachNumber(0));
        System.out.println(reachNumber(1));
        System.out.println(reachNumber(4));
        System.out.println(reachNumber(-2));
    }

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int farthest = 0;

        while (true) {
            if (farthest >= target) {
                int difference = farthest - target;
                if ((difference & 1) == 1) {
                    step++;
                    farthest += step;
                } else {
                    difference /= 2;
                    for (int i = step; i >= 0; i--) {
                        if (difference >= i) {
                            difference -= i;
                            if (difference == 0) {
                                return step;
                            }
                        }
                    }
                }
            } else {
                step++;
                farthest += step;
            }
        }
    }
}
