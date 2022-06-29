package leetcode.algorithms;

/**
 * Description: 1802. Maximum Value at a Given Index in a Bounded Array
 *
 * @author Baltan
 * @date 2022/6/28 16:08
 */
public class MaxValue1 {
    public static void main(String[] args) {
        System.out.println(maxValue(1, 0, 24));
        System.out.println(maxValue(4, 2, 6));
        System.out.println(maxValue(6, 1, 10));
        System.out.println(maxValue(500000000, 300000000, 1000000000));
    }

    public static int maxValue(int n, int index, int maxSum) {
        int result = 1;
        int leftAdd = 0;
        int rightAdd = 0;
        int leftMost = index;
        int rightMost = n - 1 - index;
        maxSum -= n;

        while (true) {
            leftAdd = Math.min(leftAdd, leftMost);
            rightAdd = Math.min(rightAdd, rightMost);

            if (leftAdd + rightAdd + 1 <= maxSum) {
                result++;
                maxSum -= (1 + leftAdd + rightAdd);
                leftAdd++;
                rightAdd++;
            } else {
                break;
            }
        }
        return result;
    }
}
