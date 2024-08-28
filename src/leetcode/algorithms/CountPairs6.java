package leetcode.algorithms;

/**
 * Description: 3265. Count Almost Equal Pairs I
 *
 * @author baltan
 * @date 2024/8/28 08:47
 */
public class CountPairs6 {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{226726, 387862, 880512, 611522, 343461, 420841, 334461, 10813, 226726, 334461, 80113, 314364, 10813, 163067, 134364, 332548, 413463, 343416, 236429, 164332, 566432, 226726, 334164, 343461, 143463, 163229, 667555, 667555, 343461, 657565, 343461, 770521, 285866, 930657, 236429, 502387, 313446, 334461, 12219, 163760, 144363, 227626}));
        System.out.println(countPairs(new int[]{3, 12, 30, 17, 21}));
        System.out.println(countPairs(new int[]{1, 1, 1, 1, 1}));
        System.out.println(countPairs(new int[]{123, 231}));
    }

    public static int countPairs(int[] nums) {
        int result = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            outer:
            for (int j = i + 1; j < length; j++) {
                int x = nums[i];
                int y = nums[j];
                /**
                 * nums[i]和nums[j]同一数位上数字不同的数位个数
                 */
                int diffs = 0;
                /**
                 * 如果nums[i]和nums[j]同一数位上数字不同，则这个数位上nums[i]的数字为diffX，nums[j]的数字为diffY
                 */
                int diffX = -1;
                int diffY = -1;

                while (x > 0 || y > 0) {
                    int bitX = x % 10;
                    int bitY = y % 10;
                    x /= 10;
                    y /= 10;

                    if (bitX == bitY) {
                        continue;
                    }

                    if (diffs == 0) {
                        diffs++;
                        diffX = bitX;
                        diffY = bitY;
                    } else if (diffs == 1 && bitX == diffY && bitY == diffX) {
                        /**
                         * 可以交换nums[i]中两个数位上的数字使得当前已遍历的nums[i]的后缀和nums[j]的后缀相等（nums[j]同理）
                         */
                        diffs++;
                    } else {
                        /**
                         * 不能通过交换nums[i]中两个数位上的数字使得当前已遍历的nums[i]的后缀和nums[j]的后缀相等（nums[j]同理），或者
                         * nums[i]和nums[j]在三个数位上的数字不同，不需要再继续判断前面的数位
                         */
                        continue outer;
                    }
                }
                /**
                 * 当diffs为0时，说明nums[i]和nums[j]本身就相等； 当diffs为0时，说明nums[i]和nums[j]可以通过一次交换操作后相等
                 */
                if (diffs == 0 || diffs == 2) {
                    result++;
                }
            }
        }
        return result;
    }
}
