package leetcode.algorithms;

import java.util.*;

/**
 * Description: 721. Accounts Merge
 *
 * @author Baltan
 * @date 2022/11/16 11:54
 */
public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts1 = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );
        System.out.println(accountsMerge(accounts1));

        List<List<String>> accounts2 = Arrays.asList(
                Arrays.asList("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                Arrays.asList("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                Arrays.asList("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                Arrays.asList("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        System.out.println(accountsMerge(accounts2));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        /**
         * 邮箱 -> 属于同一个人的所有邮箱
         */
        Map<String, List<String>> accountMap = new HashMap<>();
        /**
         * 邮箱 -> 邮箱的所有人姓名
         */
        Map<String, String> emailNameMap = new HashMap<>();
        /**
         * 所有已判断过的邮箱
         */
        Set<String> isVisited = new HashSet<>();
        /**
         * 合并属于同一个人的所有邮箱
         */
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> emails = new ArrayList<>(account.subList(1, account.size()));

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailNameMap.put(email, name);

                if (accountMap.containsKey(email)) {
                    accountMap.get(email).addAll(emails);
                } else {
                    accountMap.put(email, emails);
                }
            }
        }
        /**
         * 对每一个邮箱，查找和它同属于同一个人的所有其他的邮箱
         */
        for (String email : accountMap.keySet()) {
            List<String> mergedEmails = new ArrayList<>();
            dfs(mergedEmails, email, accountMap, isVisited);
            Collections.sort(mergedEmails);
            /**
             * 这部分邮箱的所有人姓名
             */
            String name = emailNameMap.get(email);

            if (!mergedEmails.isEmpty()) {
                List<String> account = new ArrayList<>(mergedEmails.size() + 1);
                account.add(name);
                account.addAll(mergedEmails);
                result.add(account);
            }
        }
        return result;
    }

    /**
     * 深度优先搜索属于同一个人的所有邮箱
     *
     * @param mergedEmails
     * @param email
     * @param accountMap
     * @param isVisited
     */
    public static void dfs(List<String> mergedEmails, String email, Map<String, List<String>> accountMap, Set<String> isVisited) {
        if (isVisited.contains(email)) {
            return;
        }
        mergedEmails.add(email);
        isVisited.add(email);

        if (accountMap.containsKey(email)) {
            for (String otherEmail : accountMap.get(email)) {
                dfs(mergedEmails, otherEmail, accountMap, isVisited);
            }
        }
    }
}
