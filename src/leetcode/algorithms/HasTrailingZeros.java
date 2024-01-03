package leetcode.algorithms;

/**
 * Description: 2980. Check if Bitwise OR Has Trailing Zeros
 *
 * @author Baltan
 * @date 2023/12/31 21:27
 */
public class HasTrailingZeros {
    public static void main(String[] args) {
        System.out.println(hasTrailingZeros(new int[]{1, 2, 3, 4, 5}));
        System.out.println(hasTrailingZeros(new int[]{2, 4, 8, 16}));
        System.out.println(hasTrailingZeros(new int[]{1, 3, 5, 7, 9}));
    }

    public static boolean hasTrailingZeros(int[] nums) {
        boolean findOne = false;

        for (int num : nums) {
            /**
             * 只有偶数和偶数按位或的二进制值末尾都为0，所以只需要数组nums中至少有两个偶数即可
             */
            if ((num & 1) == 0) {
                if (findOne) {
                    return true;
                }
                findOne = true;
            }
        }
        return false;
    }
}
