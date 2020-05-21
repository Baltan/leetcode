package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1452. People Whose List of Favorite Companies Is Not a Subset of Another List
 *
 * @author Baltan
 * @date 2020-05-20 22:24
 * @see PeopleIndexes1
 */
public class PeopleIndexes {
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
        /**
         * 公司清单 -> 该公司清单在favoriteCompanies中的索引
         */
        Map<List<String>, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            map.put(favoriteCompanies.get(i), i);
        }

        outer:
        for (Map.Entry<List<String>, Integer> entry : map.entrySet()) {
            /**
             * 当前要判断的公司清单
             */
            List<String> list = entry.getKey();

            for (List<String> key : map.keySet()) {
                if (key == list) {
                    continue;
                }
                /**
                 * 当前要判断的公司清单和其他某个公司清单合并后的清单
                 */
                Set<String> merge = new HashSet<>(key);
                merge.addAll(list);
                /**
                 * 如果其他某个公司清单的大小和合并后的公司清单中的公司数量相同，说明list是key的子集
                 */
                if (merge.size() == key.size()) {
                    continue outer;
                }
            }
            result.add(entry.getValue());
        }
        /**
         * 将result中的所有索引按照升序排列
         */
        Collections.sort(result);
        return result;
    }
}
