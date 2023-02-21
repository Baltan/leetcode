package leetcode.algorithms;

/**
 * Description: 2303. Calculate Amount Paid in Taxes
 *
 * @author Baltan
 * @date 2023/2/16 09:52
 */
public class CalculateTax {
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
        System.out.println(calculateTax(new int[][]{{1, 0}, {4, 25}, {5, 50}}, 2));
        System.out.println(calculateTax(new int[][]{{2, 50}}, 0));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double result = 0d;
        /**
         * 前一个税级的上限
         */
        int prevLevel = 0;

        for (int[] bracket : brackets) {
            if (income > bracket[0]) {
                result += 0.01 * (bracket[0] - prevLevel) * bracket[1];
            } else {
                /**
                 * 剩余部分的收入都在当前税级范围内
                 */
                result += 0.01 * (income - prevLevel) * bracket[1];
                break;
            }
            prevLevel = bracket[0];
        }
        return result;
    }
}
