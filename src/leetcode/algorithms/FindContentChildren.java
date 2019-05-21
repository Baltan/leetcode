package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 455. Assign Cookies
 *
 * @author Baltan
 * @date 2018/1/2 21:37
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(findContentChildren(new int[]{}, new int[]{1}));
        System.out.println(findContentChildren(new int[]{1}, new int[]{}));
        System.out.println(findContentChildren(new int[]{}, new int[]{}));
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        int contentNum = 0;
        for (int i = 0; i < g.length; i++) {
            if (sIndex >= s.length) {
                break;
            }
            for (int j = sIndex; sIndex < s.length && j < s.length; j++) {
                if (s[j] >= g[i]) {
                    contentNum++;
                    sIndex = j + 1;
                    break;
                }
            }
        }
        return contentNum;
    }
}
