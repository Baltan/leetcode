package leetcode.algorithms;

/**
 * Description: 167. Two Sum II - Input array is sorted
 *
 * @author Baltan
 * @date 2017/11/7 16:29
 */
public class TwoSum1 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        int[] result = {index1 + 1, index2 + 1};
        return result;
    }
}
