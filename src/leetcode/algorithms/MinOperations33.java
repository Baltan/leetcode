package leetcode.algorithms;

/**
 * Description: 3779. Minimum Number of Operations to Have Distinct Elements
 *
 * @author baltan
 * @date 2026/2/8 15:41
 */
public class MinOperations33 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 8, 3, 6, 5, 8}));
        System.out.println(minOperations(new int[]{2, 2}));
        System.out.println(minOperations(new int[]{4, 3, 5, 1, 2}));
    }

    public static int minOperations(int[] nums) {
        /**
         * 清空数组nums最多需要执行操作的次数
         */
        int result = (nums.length - 1) / 3 + 1;
        int length = nums.length;
        /**
         * 除去所有每次都移除3个元素的操作外，最后一次移除元素的个数
         */
        int remainder = length % 3;
        /**
         * counts[i]表示数组nums中元素i的个数，根据题意，nums[i]∈[1,100000]
         */
        int[] counts = new int[100001];
        /**
         * 判断数组nums是否可以只剩最后remainder个元素，如果可以，说明可以少执行一次删除操作
         */
        if (remainder > 0) {
            for (int i = 1; i <= remainder; i++) {
                counts[nums[length - i]]++;

                if (counts[nums[length - i]] > 1) {
                    return result;
                }
            }
            result--;
        }
        /**
         * 除去最后remainder个元素外，从后向前3个元素一组依次将元素加入到数组nums中，判断是否会产生重复的元素，如果不包含重复元素，说明可以
         * 少执行一次删除操作
         */
        for (int i = nums.length - remainder - 1; i >= 0; i -= 3) {
            for (int j = 0; j < 3; j++) {
                counts[nums[i - j]]++;

                if (counts[nums[i - j]] > 1) {
                    return result;
                }
            }
            result--;
        }
        return result;
    }
}
