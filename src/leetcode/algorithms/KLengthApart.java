package leetcode.algorithms;

/**
 * Description: 1437. Check If All 1's Are at Least Length K Places Away
 *
 * @author Baltan
 * @date 2020-05-11 08:15
 */
public class KLengthApart {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(kLengthApart(new int[]{0, 1, 0, 1}, 1));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        /**
         * 前一个1的位置
         */
        int prevIndex = 0;
        /**
         * 数组nums中第一个1的位置
         */
        int firstIndex = 0;
        int length = nums.length;
        /**
         * 查询数组nums中第一个1的位置
         */
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                prevIndex = i;
                firstIndex = i;
                break;
            }
        }

        for (int i = firstIndex + 1; i < length; i++) {
            if (nums[i] == 1) {
                /**
                 * 如果数组nums当前索引位置上为1，且和前一个1之间相隔不足k个元素，直接返回false
                 */
                if (i - prevIndex <= k) {
                    return false;
                } else {
                    prevIndex = i;
                }
            }
        }
        return true;
    }
}
