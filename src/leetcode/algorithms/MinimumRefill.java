package leetcode.algorithms;

/**
 * Description: 2105. Watering Plants II
 *
 * @author Baltan
 * @date 2021/12/13 10:46
 */
public class MinimumRefill {
    public static void main(String[] args) {
        System.out.println(minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
        System.out.println(minimumRefill(new int[]{2, 2, 3, 3}, 3, 4));
        System.out.println(minimumRefill(new int[]{5}, 10, 8));
        System.out.println(minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5));
        System.out.println(minimumRefill(new int[]{2, 2, 5, 2, 2}, 5, 5));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int result = 0;
        /**
         * Alice当前所在的位置
         */
        int indexA = 0;
        /**
         * Bob当前所在的位置
         */
        int indexB = plants.length - 1;
        /**
         * Alice当前剩余的水量
         */
        int currentA = capacityA;
        /**
         * Bob当前剩余的水量
         */
        int currentB = capacityB;

        while (indexA <= indexB) {
            if (indexA < indexB) {
                /**
                 * 判断Alice是否需要加水
                 */
                if (currentA < plants[indexA]) {
                    result++;
                    currentA = capacityA - plants[indexA];
                } else {
                    currentA -= plants[indexA];
                }
                /**
                 * 判断Bob是否需要加水
                 */
                if (currentB < plants[indexB]) {
                    result++;
                    currentB = capacityB - plants[indexB];
                } else {
                    currentB -= plants[indexB];
                }
                indexA++;
                indexB--;
            } else {
                /**
                 * 判断是由Alice完成最后一次浇水还是Bob完成，并且是否需要加水
                 */
                if (currentA >= currentB) {
                    if (currentA < plants[indexA]) {
                        result++;
                    }
                    indexA++;
                } else {
                    if (currentB < plants[indexB]) {
                        result++;
                    }
                    indexB--;
                }
            }
        }
        return result;
    }
}
