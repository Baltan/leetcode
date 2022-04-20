package leetcode.algorithms;

/**
 * Description: 2239. Find Closest Number to Zero
 *
 * @author Baltan
 * @date 2022/4/19 08:50
 */
public class FindClosestNumber {
    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));
        System.out.println(findClosestNumber(new int[]{-10000, -10000}));
    }

    public static int findClosestNumber(int[] nums) {
        int result = Integer.MIN_VALUE;
        /**
         * 已遍历的数字与0的最小差距
         */
        int diff = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num == 0) {
                return 0;
                /**
                 * 因为有多个答案时，返回较大值，即存在绝对值相同的正负两个数时返回正数，所以如果num为正数且num与0的差距为
                 * diff，即num本身等于diff时，也应该替换之前得到的最接近0的数字
                 */
            } else if (num > 0 && num <= diff) {
                result = num;
                diff = num;
            } else if (num < 0 && -num < diff) {
                result = num;
                diff = -num;
            }
        }
        return result;
    }
}
