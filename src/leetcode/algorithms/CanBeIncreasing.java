package leetcode.algorithms;

/**
 * Description: 1909. Remove One Element to Make the Array Strictly Increasing
 *
 * @author Baltan
 * @date 2022/3/6 12:09
 */
public class CanBeIncreasing {
    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));
    }

    public static boolean canBeIncreasing(int[] nums) {
        int length = nums.length;
        /**
         * 数组中第一个非严格逆序对的第一个数字的索引
         */
        int index = -1;
        /**
         * 查找数组中的第一个非严格逆序对
         */
        for (int i = 1; i < length; i++) {
            if (nums[i] <= nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        /**
         * 如果数组中没有非严格逆序对，说明所有元素都是严格递增的，直接返回true
         */
        if (index == -1) {
            return true;
        }
        /**
         * 根据题意，数组nums中元素的范围为[1,1000]，假设数组第一个元素的前面还有一个元素为0，可以保证第一个元素也是严格递增的
         */
        int prev = 0;
        /**
         * 数组删除元素nums[index]后剩下的元素是否是严格递增的
         */
        boolean flag = true;
        /**
         * 判断数组删除元素nums[index]后剩下的元素是否是严格递增的
         */
        for (int i = 0; i < length; i++) {
            if (i == index) {
                continue;
            }

            if (nums[i] <= prev) {
                flag = false;
                break;
            } else {
                prev = nums[i];
            }
        }
        /**
         * 如果数组删除元素nums[index]后剩下的元素是严格递增的，返回true
         */
        if (flag) {
            return true;
        }

        prev = 0;
        /**
         * 判断数组删除元素nums[index+1]后剩下的元素是否是严格递增的
         */
        for (int i = 0; i < length; i++) {
            if (i == index + 1) {
                continue;
            }

            if (nums[i] <= prev) {
                return false;
            } else {
                prev = nums[i];
            }
        }
        return true;
    }
}
