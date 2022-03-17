package leetcode.algorithms;

/**
 * Description: 1899. Merge Triplets to Form Target Triplet
 *
 * @author Baltan
 * @date 2022/3/16 19:46
 */
public class MergeTriplets {
    public static void main(String[] args) {
        int[][] triplets1 = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target1 = {2, 7, 5};
        System.out.println(mergeTriplets(triplets1, target1));

        int[][] triplets2 = {{3, 4, 5}, {4, 5, 6}};
        int[] target2 = {3, 2, 5};
        System.out.println(mergeTriplets(triplets2, target2));

        int[][] triplets3 = {{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}};
        int[] target3 = {5, 5, 5};
        System.out.println(mergeTriplets(triplets3, target3));
    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = 0;
        int y = 0;
        int z = 0;
        /**
         * 将三个元素都不大于target对应位置上三个元素的所有triplet合并到一起，判断最后能否得到target
         */
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                x = Math.max(x, triplet[0]);
                y = Math.max(y, triplet[1]);
                z = Math.max(z, triplet[2]);
            }
        }
        return x == target[0] && y == target[1] && z == target[2];
    }
}
