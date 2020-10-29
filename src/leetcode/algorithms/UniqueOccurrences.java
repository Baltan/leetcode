package leetcode.algorithms;

/**
 * Description: 1207. Unique Number of Occurrences
 *
 * @author Baltan
 * @date 2019-09-30 09:16
 */
public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr1));

        int[] arr2 = {1, 2};
        System.out.println(uniqueOccurrences(arr2));

        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr3));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        /**
         * count[i]表示i-1000出现的次数，因为arr中的元素在[-1000,1000]范围内
         */
        int[] count = new int[2001];
        /**
         * frequencyCount[i]表示arr中出现i次的数字的个数
         */
        int[] frequencyCount = new int[1001];
        /**
         * 统计每个数字出现的频数
         */
        for (int num : arr) {
            count[num + 1000]++;
        }

        for (int frequency : count) {
            /**
             * 如果已经有数字出现frequency（frequency不为0）次了，则说明不是每个数出现的次数都不同，直接返回false
             */
            if (frequency != 0 && frequencyCount[frequency] == 1) {
                return false;
            }
            frequencyCount[frequency] = 1;
        }
        return true;
    }
}
