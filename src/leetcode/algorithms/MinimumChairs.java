package leetcode.algorithms;

/**
 * Description: 3168. Minimum Number of Chairs in a Waiting Room
 *
 * @author baltan
 * @date 2024/6/4 14:06
 */
public class MinimumChairs {
    public static void main(String[] args) {
        System.out.println(minimumChairs("EEEEEEE"));
        System.out.println(minimumChairs("ELELEEL"));
        System.out.println(minimumChairs("ELEELEELLL"));
    }

    public static int minimumChairs(String s) {
        int result = 0;
        /**
         * 当前房间内的人数
         */
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'E') {
                count++;
                result = Math.max(result, count);
            } else {
                count--;
            }
        }
        return result;
    }
}
