package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 3447. Assign Elements to Groups with Constraints
 *
 * @author baltan
 * @date 2025/2/10 16:04
 */
public class AssignElements {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(assignElements(new int[]{8, 4, 3, 2, 4}, new int[]{4, 2}));
        OutputUtils.print1DIntegerArray(assignElements(new int[]{2, 3, 5, 7}, new int[]{5, 3, 3}));
        OutputUtils.print1DIntegerArray(assignElements(new int[]{10, 21, 30, 41}, new int[]{2, 1}));
    }

    public static int[] assignElements(int[] groups, int[] elements) {
        int[] result = new int[groups.length];
        /**
         * 数组groups中还未从数组elements中找到因数的剩余元素的个数
         */
        int total = groups.length;
        /**
         * 数组groups中的最大值
         */
        int maxGroup = Arrays.stream(groups).max().getAsInt();
        /**
         * 数组elements中的最大值
         */
        int maxElement = Arrays.stream(elements).max().getAsInt();
        /**
         * elementIsVisited[i]表示数组elements中数字i此前是否已被计算过
         */
        boolean[] elementIsVisited = new boolean[maxElement + 1];
        Arrays.fill(result, -1);
        /**
         * groupIndexesArray[i]表示数组groups中所有数字i所在的索引集合
         */
        List<Integer>[] groupIndexesArray = new ArrayList[maxGroup + 1];
        /**
         * groupIsVisited[i]表示数组groups中数字i此前是否已被计算过
         */
        boolean[] groupIsVisited = new boolean[maxGroup + 1];
        Arrays.setAll(groupIndexesArray, x -> new ArrayList<>());

        for (int i = 0; i < groups.length; i++) {
            groupIndexesArray[groups[i]].add(i);
        }
        outer:
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            int ii = i;
            /**
             * 数字element作为因数已被计算过，不重复计算
             */
            if (elementIsVisited[element]) {
                continue;
            }
            elementIsVisited[element] = true;

            if (element == 1) {
                /**
                 * 1是可以整除所有整数，将数组groups中剩余未找到因数的全部元素批量更新即可完成所有计算
                 */
                for (int j = 0; j < result.length; j++) {
                    if (result[j] == -1) {
                        result[j] = i;
                    }
                }
                break;
            } else {
                /**
                 * 数组groups中可以被element整除的元素不超过upperLimit
                 */
                int upperLimit = maxGroup / element * element;
                /**
                 * 依次判断数组groups中是否存在元素j
                 */
                for (int j = element; j <= upperLimit; j += element) {
                    if (!groupIsVisited[j]) {
                        List<Integer> groupIndexes = groupIndexesArray[j];
                        /**
                         * 将数组groups中所有元素j所在的索引在result中值改为元素element在数组elements中的索引i
                         */
                        groupIndexes.forEach(groupIndex -> result[groupIndex] = ii);
                        groupIsVisited[j] = true;
                        total -= groupIndexes.size();
                        /**
                         * 数组groups中所有元素都已找到能被整除的因数，结束计算
                         */
                        if (total == 0) {
                            break outer;
                        }
                    }
                }
            }
        }
        return result;
    }
}
