package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 1007. Minimum Domino Rotations For Equal Row
 *
 * @author Baltan
 * @date 2019-04-28 11:27
 */
public class MinDominoRotations {
    public static void main(String[] args) {
        int[] A1 = {2, 1, 2, 4, 2, 2};
        int[] B1 = {5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(A1, B1));

        int[] A2 = {3, 5, 1, 2, 3};
        int[] B2 = {3, 6, 3, 3, 4};
        System.out.println(minDominoRotations(A2, B2));
    }

    public static int minDominoRotations(int[] A, int[] B) {
        int length = A.length;
        Set<Integer>[] upArray = new Set[7];
        Set<Integer>[] downArray = new Set[7];
        Set<Integer>[] mergeArray = new Set[7];
        int result = length;
        boolean flag = false;

        for (int i = 1; i <= 6; i++) {
            upArray[i] = new HashSet<>();
            downArray[i] = new HashSet<>();
            mergeArray[i] = new HashSet<>();
        }

        for (int i = 0; i < length; i++) {
            int a = A[i];
            int b = B[i];
            upArray[a].add(i);
            mergeArray[a].add(i);
            downArray[b].add(i);
            mergeArray[b].add(i);
        }

        for (int i = 1; i <= 6; i++) {
            if (mergeArray[i].size() == length) {
                result = Math.min(result, length - Math.max(upArray[i].size(), downArray[i].size()));
                flag = true;
            }
        }
        return flag ? result : -1;
    }
}
