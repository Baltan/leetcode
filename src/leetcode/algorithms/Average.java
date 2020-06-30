package leetcode.algorithms;

/**
 * Description: 1491. Average Salary Excluding the Minimum and Maximum Salary
 *
 * @author Baltan
 * @date 2020-06-30 21:53
 */
public class Average {
    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println(average(new int[]{1000, 2000, 3000}));
        System.out.println(average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        System.out.println(average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }

    public static double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int value : salary) {
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return (sum - min - max) * 1.0 / (salary.length - 2);
    }
}
