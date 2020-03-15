package leetcode.interview;

/**
 * Description: 面试题 08.03. 魔术索引
 *
 * @author Baltan
 * @date 2020-03-15 21:00
 */
public class FindMagicIndex {
    public static int result;

    public static void main(String[] args) {
        System.out.println(findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println(findMagicIndex(new int[]{1, 1, 1}));
    }

    public static int findMagicIndex(int[] nums) {
        result = Integer.MAX_VALUE;
        findMagicIndex(nums, 0, nums.length - 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 二分查找魔术索引
     *
     * @param nums
     * @param lo
     * @param hi
     */
    public static void findMagicIndex(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int mid = (lo + hi) / 2;

        if (nums[mid] == mid) {
            /**
             * 更新魔术索引，并且在索引更小的半边查找是否有更小的魔术索引
             */
            result = Math.min(result, mid);
            findMagicIndex(nums, lo, mid - 1);
        } else {
            int prevResult = result;
            /**
             * 在索引较小的一半查找是否有魔术索引
             */
            findMagicIndex(nums, lo, mid - 1);
            /**
             * 如果result和之前的不一样了，说明找到了魔术索引，否则就到索引较大的一半查找是否有魔术索引
             */
            if (prevResult == result) {
                findMagicIndex(nums, mid + 1, hi);
            }
        }
    }
}
