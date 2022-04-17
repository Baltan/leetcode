package leetcode.algorithms;

/**
 * Description: 1947. Maximum Compatibility Score Sum
 *
 * @author Baltan
 * @date 2022/4/17 18:35
 * @see NextPermutation
 */
public class MaxCompatibilitySum {
    public static void main(String[] args) {
        int[][] students1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        int[][] mentors1 = {{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(maxCompatibilitySum(students1, mentors1));

        int[][] students2 = {{0, 0}, {0, 0}, {0, 0}};
        int[][] mentors2 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(maxCompatibilitySum(students2, mentors2));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/maximum-compatibility-score-sum/solution/zui-da-jian-rong-xing-ping-fen-he-by-lee-be2l/"></a>
     *
     * @param students
     * @param mentors
     * @return
     */
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int result = Integer.MIN_VALUE;
        /**
         * 学生和老师人数
         */
        int m = students.length;
        /**
         * 每张问卷的问题数
         */
        int n = students[0].length;
        /**
         * compatibilityMatrix[i][j]表示第i个学生和第j个老师的兼容性得分
         */
        int[][] compatibilityMatrix = new int[m][m];
        /**
         * 学生的排列
         */
        int[] permutation = new int[m];
        /**
         * 所有学生排列的情况总数，值为m!
         */
        int permutationCount = 1;

        for (int i = 0; i < m; i++) {
            /**
             * 初始化学生的排列为{0,1,2,……,m}
             */
            permutation[i] = i;
            permutationCount *= (m - i);
            /**
             * 计算students[i]和mentors[j]的n个问题答案的兼容性得分
             */
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    compatibilityMatrix[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        /**
         * 从最小的学生排列情况{0,1,2,……,m}到最大的学生排列情况{m,m-1,m-2,……,0}依次和老师的排列情况{0,1,2,……,m}配对计算n
         * 个问题答案的兼容性得分
         */
        for (int i = 0; i < permutationCount; i++) {
            int compatibility = 0;

            for (int j = 0; j < m; j++) {
                compatibility += compatibilityMatrix[permutation[j]][j];
            }
            result = Math.max(result, compatibility);
            nextPermutation(permutation);
        }
        return result;
    }

    /**
     * permutation的下一个排列
     *
     * @param permutation
     */
    public static void nextPermutation(int[] permutation) {
        int index = -1;
        /**
         * 找到索引最大的相邻两数顺序排列的一对数字
         */
        for (int i = permutation.length - 2; i >= 0; i--) {
            if (permutation[i] < permutation[i + 1]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            /**
             * 冒泡排序将nums中索引index之后部分的数字按照升序排列
             */
            for (int i = permutation.length - 2; i > index; i--) {
                for (int j = index + 1; j <= i; j++) {
                    if (permutation[j] > permutation[j + 1]) {
                        int temp = permutation[j];
                        permutation[j] = permutation[j + 1];
                        permutation[j + 1] = temp;
                    }
                }
            }
            /**
             * 找到nums中索引index之后部分的第一个大于nums[index]的数字nums[i]，交换两数
             */
            for (int i = index + 1; i < permutation.length; i++) {
                if (permutation[i] > permutation[index]) {
                    int temp = permutation[i];
                    permutation[i] = permutation[index];
                    permutation[index] = temp;
                    break;
                }
            }
        }
    }
}
