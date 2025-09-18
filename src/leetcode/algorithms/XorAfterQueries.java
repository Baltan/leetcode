package leetcode.algorithms;

/**
 * Description: 3653. XOR After Range Multiplication Queries I
 *
 * @author baltan
 * @date 2025/9/17 15:12
 */
public class XorAfterQueries {
    public static void main(String[] args) {
        System.out.println(xorAfterQueries(new int[]{1, 1, 1}, new int[][]{{0, 2, 1, 4}}));
        System.out.println(xorAfterQueries(new int[]{2, 3, 1, 5, 4}, new int[][]{{1, 4, 2, 3}, {0, 2, 1, 2}}));
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int result = 0;
        int mod = 1000000007;
        /**
         * 模拟操作
         */
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i += query[2]) {
                /**
                 * 防止整型溢出
                 */
                nums[i] = (int) ((long) nums[i] * query[3] % mod);
            }
        }

        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
