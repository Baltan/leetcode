package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3433. Count Mentions Per User
 *
 * @author Baltan
 * @date 2025/1/31 14:42
 */
public class CountMentions {
    public static void main(String[] args) {
        OutputUtils.print1DIntegerArray(countMentions(3, Arrays.asList(
                List.of("MESSAGE", "1", "ALL"), List.of("OFFLINE", "66", "1"), List.of("MESSAGE", "66", "HERE"), List.of("OFFLINE", "5", "1"))));
        OutputUtils.print1DIntegerArray(countMentions(3, Arrays.asList(
                List.of("MESSAGE", "2", "HERE"), List.of("OFFLINE", "2", "1"), List.of("OFFLINE", "1", "0"), List.of("MESSAGE", "61", "HERE"))));
        OutputUtils.print1DIntegerArray(countMentions(2, Arrays.asList(
                List.of("MESSAGE", "10", "id1 id0"), List.of("OFFLINE", "11", "0"), List.of("MESSAGE", "71", "HERE"))));
        OutputUtils.print1DIntegerArray(countMentions(2, Arrays.asList(
                List.of("MESSAGE", "10", "id1 id0"), List.of("OFFLINE", "11", "0"), List.of("MESSAGE", "12", "ALL"))));
        OutputUtils.print1DIntegerArray(countMentions(2, Arrays.asList(
                List.of("OFFLINE", "10", "0"), List.of("MESSAGE", "12", "HERE"))));
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] result = new int[numberOfUsers];
        /**
         * 保存所有上线事件，其中每个元素[i,t]表示用户i将在t时刻重新上线
         */
        Queue<int[]> onlineQueue = new LinkedList<>();
        /**
         * isOffline[i]表示用户i是否为离线状态，初始时，所有用户都不是离线状态
         */
        boolean[] isOffline = new boolean[numberOfUsers];
        /**
         * 将所有消息事件和离线事件按照事件发生的时间升序排列，对于同时发生的事件，离线事件都排在消息事件之前
         */
        Collections.sort(events, (x, y) -> !Objects.equals(x.get(1), y.get(1)) ? Integer.parseInt(x.get(1)) - Integer.parseInt(y.get(1)) :
                Objects.equals(x.getFirst(), "OFFLINE") ? -1 : 1);

        for (List<String> event : events) {
            int time = Integer.parseInt(event.get(1));
            /**
             * 处理当前事件event前，先将在时刻time前（包含time）要上线的用户状态更新
             */
            while (!onlineQueue.isEmpty() && onlineQueue.peek()[1] <= time) {
                isOffline[onlineQueue.poll()[0]] = Boolean.FALSE;
            }

            if (Objects.equals(event.get(0), "MESSAGE")) {
                if (Objects.equals(event.get(2), "HERE")) {
                    /**
                     * 所有在线用户被提及
                     */
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!isOffline[i]) {
                            result[i]++;
                        }
                    }
                } else if (Objects.equals(event.get(2), "ALL")) {
                    /**
                     * 所有用户被提及
                     */
                    for (int i = 0; i < numberOfUsers; i++) {
                        result[i]++;
                    }
                } else {
                    /**
                     * 指定id的用户被提及
                     */
                    for (String part : event.get(2).split(" ")) {
                        int id = Integer.parseInt(part.substring(2));
                        result[id]++;
                    }
                }
            } else {
                /**
                 * 指定id的用户离线，并且准备在time+60时刻重新上线
                 */
                int id = Integer.parseInt(event.get(2));
                isOffline[id] = Boolean.TRUE;
                onlineQueue.offer(new int[]{id, time + 60});
            }
        }
        return result;
    }
}
