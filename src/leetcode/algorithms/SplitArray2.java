package leetcode.algorithms;

/**
 * Description: 3618. Split Array by Prime Indices
 *
 * @author Baltan
 * @date 2025/8/17 17:54
 */
public class SplitArray2 {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{2, 3, 4}));
        System.out.println(splitArray(new int[]{-1, 5, 7, 0}));
    }

    /**
     * 根据题意，i∈[1,100000]
     */
    private static final int MAX = 100000;
    /**
     * NOT_PRIME[i]表示i是否不是质数
     */
    private static final boolean[] NOT_PRIME = new boolean[MAX + 1];

    /**
     * 初始化计算[1,100000]中的各个元素是否是质数
     */
    static {
        NOT_PRIME[0] = true;
        NOT_PRIME[1] = true;

        for (int i = 4; i <= MAX; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (!NOT_PRIME[j] && i % j == 0) {
                    NOT_PRIME[i] = true;
                    break;
                }
            }
        }
    }

    public static long splitArray(int[] nums) {
        long result = 0L;

        for (int i = 0; i < nums.length; i++) {
            if (NOT_PRIME[i]) {
                result += nums[i];
            } else {
                result -= nums[i];
            }
        }
        return Math.abs(result);
    }
}
