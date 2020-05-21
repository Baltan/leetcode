package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1452. People Whose List of Favorite Companies Is Not a Subset of Another List
 *
 * @author Baltan
 * @date 2020-05-20 22:24
 * @see PeopleIndexes
 */
public class PeopleIndexes1 {
    public static void main(String[] args) {
        List<List<String>> favoriteCompanies1 = Arrays.asList(Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"), Arrays.asList("google", "facebook"),
                Arrays.asList("google"), Arrays.asList("amazon"));
        System.out.println(peopleIndexes(favoriteCompanies1));

        List<List<String>> favoriteCompanies2 = Arrays.asList(Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"), Arrays.asList("facebook", "google"));
        System.out.println(peopleIndexes(favoriteCompanies2));

        List<List<String>> favoriteCompanies3 =
                Arrays.asList(Arrays.asList("leetcode"), Arrays.asList("google"), Arrays.asList("facebook"),
                        Arrays.asList("amazon"));
        System.out.println(peopleIndexes(favoriteCompanies3));
    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new LinkedList<>();
        int size = favoriteCompanies.size();
        List<Combo> combos = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            combos.add(new Combo(i, new HashSet<>(favoriteCompanies.get(i))));
        }
        /**
         * 将所有元素按照用户收藏的公司清单中的公司数量降序排列
         */
        Collections.sort(combos, (x, y) -> y.favoriteCompanySet.size() - x.favoriteCompanySet.size());

        outer:
        for (int i = 0; i < size; i++) {
            /**
             * 当前要判断的公司清单favoriteCompanySet
             */
            Set<String> favoriteCompanySet = combos.get(i).favoriteCompanySet;
            /**
             * 当前要判断的公司清单favoriteCompanySet是否是索引i之前的某个公司清单的子集
             */
            for (int j = 0; j < i; j++) {
                /**
                 * 合并索引为i的公司清单和索引为j的公司清单
                 */
                Set<String> mergedFavoriteCompanySet = new HashSet<>(combos.get(j).favoriteCompanySet);
                mergedFavoriteCompanySet.addAll(favoriteCompanySet);
                /**
                 * 如果合并后的公司清单和索引为j的公司清单中的公司数量相同，则说明favoriteCompanySet是索引为j的
                 * 公司清单的子集
                 */
                if (mergedFavoriteCompanySet.size() == combos.get(j).favoriteCompanySet.size()) {
                    continue outer;
                }
            }
            result.add(combos.get(i).index);
        }
        /**
         * 将result中的所有索引按照升序排列
         */
        Collections.sort(result);
        return result;
    }

    private static class Combo {
        /**
         * 收藏清单中的索引
         */
        private int index;
        /**
         * 收藏清单中第index（0-based）名用户收藏的公司清单
         */
        private Set<String> favoriteCompanySet;

        public Combo(int index, Set<String> favoriteCompanySet) {
            this.index = index;
            this.favoriteCompanySet = favoriteCompanySet;
        }
    }
}
