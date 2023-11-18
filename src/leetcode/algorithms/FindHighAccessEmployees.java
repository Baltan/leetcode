package leetcode.algorithms;

import java.util.*;

/**
 * Description: 2933. High-Access Employees
 *
 * @author Baltan
 * @date 2023/11/18 21:44
 */
public class FindHighAccessEmployees {
    public static void main(String[] args) {
        List<List<String>> accessTimes1 = Arrays.asList(
                Arrays.asList("a", "0549"),
                Arrays.asList("b", "0457"),
                Arrays.asList("a", "0532"),
                Arrays.asList("a", "0621"),
                Arrays.asList("b", "0540")
        );
        System.out.println(findHighAccessEmployees(accessTimes1));

        List<List<String>> accessTimes2 = Arrays.asList(
                Arrays.asList("d", "0002"),
                Arrays.asList("c", "0808"),
                Arrays.asList("c", "0829"),
                Arrays.asList("e", "0215"),
                Arrays.asList("d", "1508"),
                Arrays.asList("d", "1444"),
                Arrays.asList("d", "1410"),
                Arrays.asList("c", "0809")
        );
        System.out.println(findHighAccessEmployees(accessTimes2));

        List<List<String>> accessTimes3 = Arrays.asList(
                Arrays.asList("cd", "1025"),
                Arrays.asList("ab", "1025"),
                Arrays.asList("cd", "1046"),
                Arrays.asList("cd", "1055"),
                Arrays.asList("ab", "1124"),
                Arrays.asList("ab", "1120")
        );
        System.out.println(findHighAccessEmployees(accessTimes3));
    }

    public static List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        List<String> result = new ArrayList<>();
        /**
         * 员工姓名 -> 员工当天的访问时间，从早到晚排序
         */
        Map<String, Queue<String>> map = new HashMap<>();

        for (List<String> accessTime : accessTimes) {
            String name = accessTime.get(0);
            String time = accessTime.get(1);
            map.computeIfAbsent(name, i -> new PriorityQueue<>()).offer(time);
        }
        outer:
        for (Map.Entry<String, Queue<String>> entry : map.entrySet()) {
            Queue<String> times = entry.getValue();
            /**
             * 如果员工当天访问次数不到3次，肯定不是高访问员工
             */
            if (times.size() < 3) {
                continue;
            }
            int first = getOffset(times.poll());
            int second = getOffset(times.poll());
            /**
             * 判断员工是否存在第i次访问时间和第i+2次访问时间间隔小于60分钟的情况，如有，则为高访问员工
             */
            while (!times.isEmpty()) {
                int third = getOffset(times.poll());

                if (third - first < 60) {
                    result.add(entry.getKey());
                    continue outer;
                }
                first = second;
                second = third;
            }
        }
        return result;
    }

    /**
     * 计算时刻time相对于当天00:00经过的分钟数
     *
     * @param time
     * @return
     */
    public static int getOffset(String time) {
        char[] charArray = time.toCharArray();
        return ((charArray[0] - '0') * 10 + (charArray[1] - '0')) * 60 + (charArray[2] - '0') * 10 + (charArray[3] - '0');
    }
}
