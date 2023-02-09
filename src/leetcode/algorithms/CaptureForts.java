package leetcode.algorithms;

/**
 * Description: 2511. Maximum Enemy Forts That Can Be Captured
 *
 * @author Baltan
 * @date 2023/2/3 09:47
 */
public class CaptureForts {
    public static void main(String[] args) {
        System.out.println(captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
        System.out.println(captureForts(new int[]{0, 0, 1, -1}));
    }

    public static int captureForts(int[] forts) {
        int result = 0;
        int length = forts.length;

        for (int i = 0; i < length; i++) {
            if (forts[i] != 1) {
                continue;
            }
            /**
             * 向左移动可以摧毁的敌人城堡数
             */
            int leftCount = 0;
            /**
             * 向右移动可以摧毁的敌人城堡数
             */
            int rightCount = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (forts[j] == 1) {
                    break;
                } else if (forts[j] == 0) {
                    leftCount++;
                } else {
                    result = Math.max(result, leftCount);
                    break;
                }
            }

            for (int j = i + 1; j < length; j++) {
                if (forts[j] == 1) {
                    break;
                } else if (forts[j] == 0) {
                    rightCount++;
                } else {
                    result = Math.max(result, rightCount);
                    break;
                }
            }
        }
        return result;
    }
}
