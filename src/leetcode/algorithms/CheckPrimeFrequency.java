package leetcode.algorithms;

/**
 * Description: 3591. Check if Any Element Has Prime Frequency
 *
 * @author baltan
 * @date 2025/7/28 18:05
 */
public class CheckPrimeFrequency {
    public static void main(String[] args) {
        System.out.println(checkPrimeFrequency(new int[]{1, 2, 3, 4, 5, 4}));
        System.out.println(checkPrimeFrequency(new int[]{1, 2, 3, 4, 5}));
        System.out.println(checkPrimeFrequency(new int[]{2, 2, 2, 4, 4}));
    }

    /**
     * 根据题意，nums[i]∈[1,100]
     */
    private static final int MAX = 100;
    /**
     * IS_PRIME[i]表示数字i是否是质数
     */
    private static final boolean[] IS_PRIME = new boolean[MAX + 1];

    /**
     * 初始化计算[1,100]中的各个元素是否是质数
     */
    static {
        IS_PRIME[2] = true;
        IS_PRIME[3] = true;
        outer:
        for (int i = 4; i <= MAX; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (IS_PRIME[j] && i % j == 0) {
                    continue outer;
                }
            }
            IS_PRIME[i] = true;
        }
    }

    public static boolean checkPrimeFrequency(int[] nums) {
        /**
         * counts[i]表示数字i在数组nums中出现的次数
         */
        int[] counts = new int[MAX + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int count : counts) {
            /**
             * 判断某个数字在数组nums中出现的次数是否为质数
             */
            if (IS_PRIME[count]) {
                return true;
            }
        }
        return false;
    }
}
