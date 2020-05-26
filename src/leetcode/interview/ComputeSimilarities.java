package leetcode.interview;

import java.util.*;

/**
 * Description: 面试题 17.26. 稀疏相似度
 *
 * @author Baltan
 * @date 2020-05-26 22:26
 */
public class ComputeSimilarities {
    public static void main(String[] args) {
        int[][] docs1 = {{14, 15, 100, 9, 3}, {32, 1, 9, 3, 5}, {15, 29, 2, 6, 8, 7}, {7, 10}};
        System.out.println(computeSimilarities(docs1));
    }

    public static List<String> computeSimilarities(int[][] docs) {
        List<String> result = new LinkedList<>();
        int length = docs.length;
        /**
         * sameCount[i][j]表示文档i和文档j的并集中元素的个数
         */
        int[][] sameCount = new int[length][length];
        /**
         * 元素key -> 含有元素key的文档的id集合
         */
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int value : docs[i]) {
                map.putIfAbsent(value, new ArrayList<>());
                map.get(value).add(i);
            }
        }

        for (List<Integer> docIds : map.values()) {
            int size = docIds.size();
            /**
             * 如果size小于2，说明只有一个文档中出现过这个元素
             */
            if (size < 2) {
                continue;
            }

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int min = Math.min(docIds.get(i), docIds.get(j));
                    int max = Math.max(docIds.get(i), docIds.get(j));
                    /**
                     * id为min和max的文档中都出现过这个元素，将这两个文档并集元素的个数加1
                     */
                    sameCount[min][max]++;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (sameCount[i][j] > 0) {
                    /**
                     * 文档i和文档j并集元素的个数=文档i元素的个数+文档j元素的个数-文档i和文档j交集元素的个数
                     */
                    String similarity = String.format("%.4f",
                            1.0 * sameCount[i][j] / (docs[i].length + docs[j].length - sameCount[i][j]));
                    result.add(i + "," + j + ": " + similarity);
                }
            }
        }
        return result;
    }
}
