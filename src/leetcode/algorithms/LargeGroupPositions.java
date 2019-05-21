package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 830. Positions of Large Groups
 *
 * @author Baltan
 * @date 2018/8/2 15:06
 */
public class LargeGroupPositions {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("aaa"));
        System.out.println(largeGroupPositions("aaabbbb"));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();

        int times = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                times++;
                if (i == S.length() - 1) {
                    if (times >= 3) {
                        List<Integer> indexList = new ArrayList<>();
                        indexList.add(i - times + 1);
                        indexList.add(i);
                        list.add(indexList);
                    }
                }
            } else {
                if (times >= 3) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(i - times);
                    indexList.add(i - 1);
                    list.add(indexList);
                }
                times = 1;
            }
        }
        return list;
    }
}
