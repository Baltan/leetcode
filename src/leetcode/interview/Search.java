package leetcode.interview;

/**
 * Description: 面试题 10.03. 搜索旋转数组
 *
 * @author Baltan
 * @date 2020-03-18 13:19
 * @see leetcode.algorithms.Search
 * @see leetcode.algorithms.Search1
 * @see leetcode.algorithms.Search2
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
        System.out.println(search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 11));
    }

    public static int search(int[] arr, int target) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
