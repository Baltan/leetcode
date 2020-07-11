package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: 315. Count of Smaller Numbers After Self
 *
 * @author Baltan
 * @date 2020-07-11 21:40
 */
public class CountSmaller {
    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(countSmaller(new int[]{5, 5, 5, 5, 5}));
        System.out.println(countSmaller(
                new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81,
                        32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41}));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/cong-you-wang-zuo-cha-ru-pai-xu-by-utopiahiker/"></a>
     *
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        int length = nums.length;
        List<Integer> result = new ArrayList<>(length);
        result.add(0);
        /**
         * 对nums从后向前进行降序的插入排序
         */
        for (int i = length - 2; i >= 0; i--) {
            /**
             * 当前要插入的数字
             */
            int currNum = nums[i];
            int j;
            /**
             * 如果遍历到的数字不小于currNum，就将该数字向前移动一个位置
             */
            for (j = i + 1; j < length && nums[j] >= currNum; j++) {
                nums[j - 1] = nums[j];
            }
            /**
             * 因为nums[j]小于currNum，而nums[j-1]之前已经移动到nums[j-1]的位置上了，所以将curr放到currNum[j-1]
             * 位置上
             */
            nums[j - 1] = currNum;
            /**
             * nums[j]-nums[length-1]这部分数字是小于currNum，共计length-j个数字
             */
            result.add(0, length - j);
        }
        return result;
    }
}
