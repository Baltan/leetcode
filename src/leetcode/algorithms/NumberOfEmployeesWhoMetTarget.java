package leetcode.algorithms;

/**
 * Description: 2798. Number of Employees Who Met the Target
 *
 * @author Baltan
 * @date 2023/7/30 15:06
 */
public class NumberOfEmployeesWhoMetTarget {
    public static void main(String[] args) {
        System.out.println(numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2));
        System.out.println(numberOfEmployeesWhoMetTarget(new int[]{5, 1, 4, 2, 2}, 6));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int result = 0;
        /**
         * 计算数组hours中大于等于target的元素的个数
         */
        for (int hour : hours) {
            if (hour >= target) {
                result++;
            }
        }
        return result;
    }
}
