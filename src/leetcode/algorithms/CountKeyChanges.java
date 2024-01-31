package leetcode.algorithms;

/**
 * Description: 3019. Number of Changing Keys
 *
 * @author Baltan
 * @date 2024/1/28 19:52
 */
public class CountKeyChanges {
    public static void main(String[] args) {
        System.out.println(countKeyChanges("aAbBcC"));
        System.out.println(countKeyChanges("AaAaAaaA"));
    }

    public static int countKeyChanges(String s) {
        int result = 0;
        s = s.toLowerCase();
        /**
         * 将字符串s中的所有字母都转为小写，计算相邻两个字母不同的次数
         */
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result++;
            }
        }
        return result;
    }
}
