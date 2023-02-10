package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2306. Naming a Company
 *
 * @author Baltan
 * @date 2023/2/10 11:17
 */
public class DistinctNames {
    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"alrgtxxdj", "illqfngl", "rlrgtxxdj"}));
        System.out.println(distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
        System.out.println(distinctNames(new String[]{"lack", "back"}));
    }

    public static long distinctNames(String[] ideas) {
        long result = 0L;
        Map<String, Integer> suffixMap = new HashMap<>();

        for (String idea : ideas) {
            String suffix = idea.substring(1);
            int status = suffixMap.getOrDefault(suffix, 0);
            status |= (1 << (idea.charAt(0) - 'a'));
            suffixMap.put(suffix, status);
        }
        List<Integer> statusList = new ArrayList<>(suffixMap.values());

        for (int i = 0; i < statusList.size(); i++) {
            for (int j = i + 1; j < statusList.size(); j++) {
                int status1 = statusList.get(i);
                int status2 = statusList.get(j);
                int count1 = 0;
                int count2 = 0;

                for (int k = 0; k < 26; k++) {
                    int bit1 = status1 >> k & 1;
                    int bit2 = status2 >> k & 1;

                    if (bit1 == 1 && bit2 == 0) {
                        count1++;
                    } else if (bit2 == 1 && bit1 == 0) {
                        count2++;
                    }
                }
                result += count1 * count2 * 2;
            }
        }
        return result;
    }
}
