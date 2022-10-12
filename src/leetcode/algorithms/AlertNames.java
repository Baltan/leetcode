package leetcode.algorithms;

import java.util.*;

/**
 * Description: 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
 *
 * @author Baltan
 * @date 2022/10/7 21:32
 */
public class AlertNames {
    public static void main(String[] args) {
        String[] keyName1 = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime1 = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        System.out.println(alertNames(keyName1, keyTime1));

        String[] keyName2 = {"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
        String[] keyTime2 = {"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};
        System.out.println(alertNames(keyName2, keyTime2));

        String[] keyName3 = {"john", "john", "john"};
        String[] keyTime3 = {"23:58", "23:59", "00:01"};
        System.out.println(alertNames(keyName3, keyTime3));

        String[] keyName4 = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        String[] keyTime4 = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        System.out.println(alertNames(keyName4, keyTime4));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        int length = keyName.length;
        /**
         * 员工姓名 -> 使用员工卡的时间列表
         */
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> times = map.computeIfAbsent(name, x -> new ArrayList<>());
            times.add(time);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<String> times = entry.getValue();

            if (times.size() < 3) {
                continue;
            }
            /**
             * 将使用员工卡的时间按照升序排列
             */
            Collections.sort(times);
            int size = times.size();
            /**
             * 每次使用员工卡对应的小时时间
             */
            List<Integer> hours = new ArrayList<>(size);
            /**
             * 每次使用员工卡对应的分钟时间
             */
            List<Integer> minutes = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                String time = times.get(i);
                String[] hm = time.split(":");
                hours.add(Integer.valueOf(hm[0]));
                minutes.add(Integer.valueOf(hm[1]));
            }

            for (int i = 2; i < size; i++) {
                int startHour = hours.get(i - 2);
                int startMinute = minutes.get(i - 2);
                int endHour = hours.get(i);
                int endMinute = minutes.get(i);
                /**
                 * 第x次使用员工卡和第x-2次使用员工卡相差的分钟数
                 */
                int diff = (endHour - startHour) * 60 + (endMinute - startMinute);

                if (diff <= 60) {
                    result.add(name);
                    break;
                }
            }
        }
        /**
         * 将收到系统警告的员工姓名按照升序排列
         */
        Collections.sort(result);
        return result;
    }
}
