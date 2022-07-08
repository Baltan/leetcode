package leetcode.algorithms;

/**
 * Description: 1785. Minimum Elements to Add to Form a Given Sum
 *
 * @author Baltan
 * @date 2022/7/5 09:17
 */
public class MinElements {
    public static void main(String[] args) {
        System.out.println(minElements(new int[]{1, -1, 1}, 3, -4));
        System.out.println(minElements(new int[]{1, -10, 9, 1}, 100, 0));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;

        for (int num : nums) {
            sum += num;
        }
        long diff = goal - sum;
        /**
         * 为了使得增加的数字尽可能少，增加的数字应该尽可能为±limit，除最后一个剩余的数字以外
         */
        return (int) Math.ceil(1.0 * Math.abs(diff) / limit);
    }
}
