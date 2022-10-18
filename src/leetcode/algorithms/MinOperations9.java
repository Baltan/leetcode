package leetcode.algorithms;

import java.util.Objects;

/**
 * Description: 1598. Crawler Log Folder
 *
 * @author Baltan
 * @date 2022/10/11 15:52
 */
public class MinOperations9 {
    public static void main(String[] args) {
        System.out.println(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(minOperations(new String[]{"d1/", "../", "../", "../"}));
    }

    public static int minOperations(String[] logs) {
        int result = 0;

        for (String log : logs) {
            if (Objects.equals(log, "../")) {
                if (result > 0) {
                    /**
                     * 跳转到父文件夹
                     */
                    result--;
                }
            } else if (!Objects.equals(log, "./")) {
                /**
                 * 跳转到指定名称的子文件夹中
                 */
                result++;
            }
        }
        return result;
    }
}
