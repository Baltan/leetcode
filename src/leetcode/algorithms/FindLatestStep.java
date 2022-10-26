package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1562. Find Latest Group of Size M
 *
 * @author Baltan
 * @date 2022/10/25 09:12
 */
public class FindLatestStep {
    public static void main(String[] args) {
        System.out.println(findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
        System.out.println(findLatestStep(new int[]{3, 1, 5, 4, 2}, 2));
        System.out.println(findLatestStep(new int[]{1}, 1));
        System.out.println(findLatestStep(new int[]{2, 1}, 2));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/find-latest-group-of-size-m/solutions/386109/on-de-jie-jue-fang-fa-by-time-limit/"></a>
     *
     * @param arr
     * @param m
     * @return
     */
    public static int findLatestStep(int[] arr, int m) {
        int result = -1;
        int length = arr.length;
        /**
         * counts[i]表示长度为i的"一组1"的数量
         */
        int[] counts = new int[length + 1];
        /**
         * 当arr[i]为"一组1"的一个端点时，groups[i]表示"这组1"的另一个端点的索引位置，当groups[i]为-1时，表示arr[i]不是
         * "一组1"的一个端点
         */
        int[] groups = new int[length];
        Arrays.fill(groups, -1);

        for (int i = 0; i < length; i++) {
            int index = arr[i];
            /**
             * 根据题意，数组arr中的索引值都是1-based，转换为0-based
             */
            index--;
            /**
             * arr[index-1]是否是一组1的一个端点，即紧邻arr[index]左边是否存在一组1
             */
            boolean leftIsGroup = index - 1 >= 0 && groups[index - 1] != -1;
            /**
             * arr[index+1]是否是一组1的一个端点，即紧邻arr[index]右边是否存在一组1
             */
            boolean rightIsGroup = index + 1 < length && groups[index + 1] != -1;
            /**
             * 1、如果左右各存在一组1，arr[index]会将两组1拼接在一起构成更长的一组1
             * 2、如果左边存在一组1，arr[index]会将这组1的长度向右延长1
             * 3、如果右边存在一组1，arr[index]会将这组1的长度向左延长1
             * 4、如果左右都不存在一组1，arr[index]会构成长度为1的一组1
             */
            if (leftIsGroup && rightIsGroup) {
                /**
                 * 左边这组1的右端点
                 */
                int leftGroupRightEnd = index - 1;
                /**
                 * 左边这组1的左端点
                 */
                int leftGroupLeftEnd = groups[leftGroupRightEnd];
                /**
                 * 右边这组1的左端点
                 */
                int rightGroupLeftEnd = index + 1;
                /**
                 * 右边这组1的右端点
                 */
                int rightGroupRightEnd = groups[rightGroupLeftEnd];
                /**
                 * [leftGroupLeftEnd,leftGroupRightEnd]和[rightGroupLeftEnd,rightGroupRightEnd]左右两组1都不再存
                 * 在，合并成了[leftGroupLeftEnd,rightGroupRightEnd]
                 */
                counts[leftGroupRightEnd - leftGroupLeftEnd + 1]--;
                counts[rightGroupRightEnd - rightGroupLeftEnd + 1]--;
                /**
                 * 左边这组1的右端点和右边这组1的左端点不再是一组1的一个端点
                 */
                groups[leftGroupRightEnd] = -1;
                groups[rightGroupLeftEnd] = -1;
                /**
                 * 新的一组1的范围为[leftGroupLeftEnd,rightGroupRightEnd]
                 */
                groups[leftGroupLeftEnd] = rightGroupRightEnd;
                groups[rightGroupRightEnd] = leftGroupLeftEnd;
                counts[rightGroupRightEnd - leftGroupLeftEnd + 1]++;
            } else if (leftIsGroup) {
                /**
                 * 左边这组1的右端点
                 */
                int leftGroupRightEnd = index - 1;
                /**
                 * 左边这组1的左端点
                 */
                int leftGroupLeftEnd = groups[leftGroupRightEnd];
                /**
                 * [leftGroupLeftEnd,leftGroupRightEnd]这组1不再存在，向右延伸为了[leftGroupLeftEnd,index]
                 */
                counts[leftGroupRightEnd - leftGroupLeftEnd + 1]--;
                /**
                 * 左边这组1的右端点不再是一组1的一个端点
                 */
                groups[leftGroupRightEnd] = -1;
                /**
                 * 新的一组1的范围为[leftGroupLeftEnd,index]
                 */
                groups[leftGroupLeftEnd] = index;
                groups[index] = leftGroupLeftEnd;
                counts[index - leftGroupLeftEnd + 1]++;
            } else if (rightIsGroup) {
                /**
                 * 右边这组1的左端点
                 */
                int rightGroupLeftEnd = index + 1;
                /**
                 * 右边这组1的右端点
                 */
                int rightGroupRightEnd = groups[rightGroupLeftEnd];
                /**
                 * [rightGroupLeftEnd,rightGroupRightEnd]这组1不再存在，向左延伸为了[index,rightGroupRightEnd]
                 */
                counts[rightGroupRightEnd - rightGroupLeftEnd + 1]--;
                /**
                 * 右边这组1的左端点不再是一组1的一个端点
                 */
                groups[rightGroupLeftEnd] = -1;
                /**
                 * 新的一组1的范围为[index,rightGroupRightEnd]
                 */
                groups[rightGroupRightEnd] = index;
                groups[index] = rightGroupRightEnd;
                counts[rightGroupRightEnd - index + 1]++;
            } else {
                groups[index] = index;
                counts[1]++;
            }
            /**
             * 判断是否存在长度恰好为m的一组1
             */
            if (counts[m] > 0) {
                result = i + 1;
            }
        }
        return result;
    }
}
