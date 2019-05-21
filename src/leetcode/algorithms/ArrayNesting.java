package leetcode.algorithms;

/**
 * Description: 565. Array Nesting
 *
 * @author Baltan
 * @date 2018/8/21 12:51
 */
public class ArrayNesting {
    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(arrayNesting(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    public static int arrayNesting(int[] nums) {
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            int temp = i;
            while (nums[temp] >= 0) {
                size++;
                int nextTemp = nums[temp];
                nums[temp] = -1;
                temp = nextTemp;
            }
            maxSize = Math.max(size, maxSize);
        }
        return maxSize;
    }
}
