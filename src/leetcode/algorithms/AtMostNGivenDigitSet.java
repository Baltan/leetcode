package leetcode.algorithms;

/**
 * Description: 902. Numbers At Most N Given Digit Set
 *
 * @author Baltan
 * @date 2019-08-08 08:39
 */
public class AtMostNGivenDigitSet {
    public static void main(String[] args) {
        String[] D1 = {"1", "3", "5", "7"};
        System.out.println(atMostNGivenDigitSet(D1, 100));

        String[] D2 = {"1", "4", "9"};
        System.out.println(atMostNGivenDigitSet(D2, 1000000000));

        String[] D3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        System.out.println(atMostNGivenDigitSet(D3, 111));

        String[] D4 = {"1", "2", "5", "6", "7", "8", "9"};
        System.out.println(atMostNGivenDigitSet(D4, 983715655));

        String[] D5 = {"1", "2", "3", "4"};
        System.out.println(atMostNGivenDigitSet(D5, 543));

        String[] D6 = {"1", "5", "7", "8"};
        System.out.println(atMostNGivenDigitSet(D6, 10212));
    }

    public static int atMostNGivenDigitSet(String[] D, int N) {
        int result = 0;
        String nString = String.valueOf(N);
        int length = nString.length();
        int numCount = D.length;
        /**
         * 如果N为一位数，直接判断D中的每个数字是否不大于N即可
         */
        if (length == 1) {
            for (String s : D) {
                if (s.compareTo(nString) <= 0) {
                    result++;
                }
            }
            return result;
        } else {
            /**
             * 计算所有用D中的数字可以组成的长度小于N的数字
             */
            for (int i = 1; i < length; i++) {
                result += Math.pow(numCount, i);
            }
            /**
             * 计算所有用D中的数字可以组成的长度等于N的数字
             */
            result += help(D, N);
            return result;
        }
    }

    /**
     * 查找用D中的数字可以组成的和N长度一样但是不大于N的数字的个数
     *
     * @param D
     * @param N
     * @return
     */
    public static int help(String[] D, int N) {
        int result = 0;
        String nString = String.valueOf(N);
        int length = nString.length();
        int numCount = D.length;
        /**
         * 如果N为一位数，直接判断D中的每个数字是否不大于N即可
         */
        if (length == 1) {
            for (String s : D) {
                if (s.compareTo(nString) <= 0) {
                    result++;
                }
            }
            return result;
        } else {
            /**
             * 获得N的最高位数字
             */
            char firstNum = nString.charAt(0);

            for (String s : D) {
                char c = s.charAt(0);

                if (c < firstNum) {
                    /**
                     * 如果组成的数字最高位小于N的最高位，剩余N-1位数字任意组合都符合要求
                     */
                    result += Math.pow(numCount, length - 1);
                } else if (c == firstNum) {
                    /**
                     * 如果组成的数字最高位和N的最高位一样，符合要求的数字个数即为所有用D中的数字可以组成的长度比N小1的数字，
                     * 但是如果后N-1位数字如果以"0"开头，则没有符合条件的情况，因为D中的数字不含"0"，例如：
                     * N=10212，D=["1", "5", "7", "8"]，当确定首位为"1"后，需要查找小于"0212"的四位数，显然不存在
                     */
                    String s1 = nString.substring(1);
                    if (!s1.startsWith("0")) {
                        int N1 = Integer.valueOf(nString.substring(1));
                        result += help(D, N1);
                    }
                }
            }
            return result;
        }
    }
}
