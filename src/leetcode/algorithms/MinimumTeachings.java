package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description: 1733. Minimum Number of People to Teach
 *
 * @author Baltan
 * @date 2022/8/4 09:57
 */
public class MinimumTeachings {
    public static void main(String[] args) {
        int n1 = 2;
        int[][] languages1 = {{1}, {2}, {1, 2}};
        int[][] friendships1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(minimumTeachings(n1, languages1, friendships1));

        int n2 = 3;
        int[][] languages2 = {{2}, {1, 3}, {1, 2}, {3}};
        int[][] friendships2 = {{1, 4}, {1, 2}, {3, 4}, {2, 3}};
        System.out.println(minimumTeachings(n2, languages2, friendships2));
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int result = Integer.MAX_VALUE;
        /**
         * userLanguages[i]表示第i+1位用户掌握的语言集合
         */
        Set[] userLanguages = new Set[languages.length];
        /**
         * 初始状态下，无法相互沟通的好友关系
         */
        List<int[]> unrelatedFriendships = new ArrayList<>();

        for (int i = 0; i < languages.length; i++) {
            userLanguages[i] = Arrays.stream(languages[i]).boxed().collect(Collectors.toSet());
        }

        outer:
        for (int[] friendship : friendships) {
            int x = friendship[0];
            int y = friendship[1];
            /**
             * 初始状态下用户x掌握的语言集合
             */
            Set<Integer> xLanguages = userLanguages[x - 1];
            /**
             * 初始状态下用户y掌握的语言集合
             */
            Set<Integer> yLanguages = userLanguages[y - 1];

            for (int xLanguage : xLanguages) {
                /**
                 * 当x掌握的某一门语言y也掌握时，他们可以相互沟通
                 */
                if (yLanguages.contains(xLanguage)) {
                    continue outer;
                }
            }
            unrelatedFriendships.add(friendship);
        }
        /**
         * 假设所有好友之间最终都用第i门语言相互沟通，计算每一门语言需要教会的用户数
         */
        for (int i = 1; i <= n; i++) {
            int teachUsers = 0;
            /**
             * 初始状态下每位用户掌握的语言集合
             */
            Set[] clonedUserLanguages = userLanguages.clone();

            for (int[] unrelatedFriendship : unrelatedFriendships) {
                int x = unrelatedFriendship[0];
                int y = unrelatedFriendship[1];
                /**
                 * 初始状态下用户x掌握的语言集合
                 */
                Set<Integer> xLanguages = clonedUserLanguages[x - 1];
                /**
                 * 初始状态下用户y掌握的语言集合
                 */
                Set<Integer> yLanguages = clonedUserLanguages[y - 1];

                if (!xLanguages.contains(i)) {
                    teachUsers++;
                    xLanguages.add(i);
                }

                if (!yLanguages.contains(i)) {
                    teachUsers++;
                    yLanguages.add(i);
                }
            }
            result = Math.min(result, teachUsers);
        }
        return result;
    }
}
