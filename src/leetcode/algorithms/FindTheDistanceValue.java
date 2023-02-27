package leetcode.algorithms;

/**
 * Description: 1385. Find the Distance Value Between Two Arrays
 *
 * @author Baltan
 * @date 2023/2/20 11:53
 */
public class FindTheDistanceValue {
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println(findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
        System.out.println(findTheDistanceValue(new int[]{-79, -199, -359, -184, -872, -869, 870, -351, 986, 231, 986, -67, -772, -488, -560, 607, 265, 593, 825, 111, 776, 409, -40, 355, -272, -470, -625, 109, -575, -371, -593, -496, -262, -834, 679, -425, -817, 542, -83, -815, 335, 176, 317, -306, 926, -535, -201, 979, -372, -916, -330, -618, -352, 623, 734, 185, 829, 886, -380, -497, -316, -794, 114, 252, 185, 653, 220, -812, -499, -550, -959, 655, -501, -178, -852, -452, 128, 776, -855, 493, -847, -956, 301, -980, -405, 537}, new int[]{622, -265, 10, -40, 766, 759, -685, -794, 26, 592, 628, -329, -843, 42, 944, 362, -646, -633, 589, -694, -711, 682, 772, -346, -375, -782, 452, 53, 709, 882, 232, -399, -742, 830, -577, -710, 117, 864, 479, -935, 596, -353, 681, 849, 276, 646, 376, 857, 132, 721}, 95));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result = 0;
        /**
         * counts[i]表示数组arr2中元素i-1000的个数，根据题意arr2[i]∈[-1000,1000]
         */
        int[] counts = new int[2001];
        /**
         * 数组counts的前缀和，prefixSums[i]表示数组arr2中元素[-1000,-1000+i)的总个数
         */
        int[] prefixSums = new int[2002];

        for (int num : arr2) {
            counts[num + 1000]++;
        }

        for (int i = 0; i < 2001; i++) {
            prefixSums[i + 1] = prefixSums[i] + counts[i];
        }
        /**
         * 因为|arr1[i]-arr2[j]|<=d，所以-d<=arr1[i]-arr2[j]<=d，所以arr1[i]-d<=arr2[j]<=arr1[i]+d
         */
        for (int num : arr1) {
            int lowerLimit = Math.max(-1000, num - d);
            int upperLimit = Math.min(1000, num + d);
            /**
             * 数组arr2中元素[-1000,lowerLimit)的总个数为prefixSums[lowerLimit+1000]，元素[-1000,upperLimit]的总个数为
             * prefixSums[upperLimit+1000+1]，则元素[lowerLimit,upperLimit]的总个数为prefixSums[upperLimit+1000+1]-
             * prefixSums[lowerLimit+1000]
             */
            int count = prefixSums[upperLimit + 1000 + 1] - prefixSums[lowerLimit + 1000];

            if (count == 0) {
                result++;
            }
        }
        return result;
    }
}
