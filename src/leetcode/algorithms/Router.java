package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 3508. Implement Router
 *
 * @author Baltan
 * @date 2025/4/19 22:42
 * 参考：<a href="https://leetcode.cn/problems/implement-router/solutions/3641772/mo-ni-ha-xi-biao-dui-lie-er-fen-cha-zhao-y7l7/"></a>
 */
public class Router {
    private int memoryLimit;
    /**
     * 保存所有未转发的数据包
     */
    private Queue<Packet> packetQueue;
    /**
     * 用于对未转发的数据包去重
     */
    private Set<Packet> packetSet;
    /**
     * 数据包目标机器唯一标识符 -> 到达目标机器的所有数据包的时间
     */
    private Map<Integer, Timeline> timelineMap;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packetQueue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.timelineMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        /**
         * 数据包packet为重复数据包，不进行任何操作
         */
        if (packetSet.contains(packet)) {
            return false;
        }
        /**
         * 未转发的数据包个数已达内存上线，将最早的数据包移除
         */
        if (packetQueue.size() == memoryLimit) {
            forwardPacket();
        }
        /**
         * 新数据包packet入队
         */
        packetQueue.offer(packet);
        packetSet.add(packet);
        /**
         * 记录到达目标机器destination的所有数据包的时间
         */
        timelineMap.computeIfAbsent(packet.destination, i -> new Timeline(new ArrayList<>(), 0)).timestamps.add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        /**
         * 没有未转发的数据包
         */
        if (packetQueue.isEmpty()) {
            return new int[0];
        }
        /**
         * 数据包packet出队
         */
        Packet packet = packetQueue.poll();
        packetSet.remove(packet);
        /**
         * 更新下一个将要到达目标机器packet.destination的数据包的时间
         */
        timelineMap.get(packet.destination).index++;
        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        Timeline timeline = timelineMap.get(destination);
        /**
         * 不存在未转发到目标机器destination的数据包，或将要转发到目标机器destination的所有数据包的时间都不在[startTime,endTime]范围内
         */
        if (timeline == null || timeline.index >= timeline.timestamps.size() || timeline.timestamps.get(timeline.index) > endTime || timeline.timestamps.getLast() < startTime) {
            return 0;
        }
        int startIndex = getStartIndex(timeline, startTime);
        int endIndex = getEndIndex(timeline, endTime);
        /**
         * 时间[startTime,endTime]范围内，将要转发到目标机器destination的数据包的时间依次为timeline.timestamps[startIndex]到
         * timeline.timestamps[endIndex]，一共endIndex-startIndex+1个数据包
         */
        return endIndex - startIndex + 1;
    }

    /**
     * 在有序队列timeline.timestamps中二分查找第一个索引不小于timeline.index，值不小于startTime的元素的索引
     * @param timeline
     * @param startTime
     * @return
     */
    private int getStartIndex(Timeline timeline, int startTime) {
        int lo = timeline.index;
        int hi = timeline.timestamps.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (timeline.timestamps.get(mid) < startTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /**
     * 在有序队列timeline.timestamps中二分查找第一个索引不小于timeline.index，值不大于endTime的元素的索引
     * @param timeline
     * @param endTime
     * @return
     */
    private int getEndIndex(Timeline timeline, int endTime) {
        int lo = timeline.index;
        int hi = timeline.timestamps.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (timeline.timestamps.get(mid) > endTime) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    /**
     * 数据包对象
     * @param source
     * @param destination
     * @param timestamp
     */
    private record Packet(int source, int destination, int timestamp) {
    }

    /**
     * 到达指定目标机器的所有数据包的时间
     */
    private static class Timeline {
        /**
         * 到达目标机器的所有数据包的时间
         */
        private final List<Integer> timestamps;
        /**
         * 指向时间队列timestamps中，下一个将要到达目标机器的数据包的时间
         */
        private int index;

        public Timeline(List<Integer> timestamps, int index) {
            this.timestamps = timestamps;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Router router1 = new Router(3);
        System.out.println(router1.addPacket(1, 4, 90));
        System.out.println(router1.addPacket(2, 5, 90));
        System.out.println(router1.addPacket(1, 4, 90));
        System.out.println(router1.addPacket(3, 5, 95));
        System.out.println(router1.addPacket(4, 5, 105));
        OutputUtils.print1DIntegerArray(router1.forwardPacket());
        System.out.println(router1.addPacket(5, 2, 110));
        System.out.println(router1.getCount(5, 100, 110));

        System.out.println("--------------------------------------------------------");

        Router router2 = new Router(2);
        System.out.println(router2.addPacket(7, 4, 90));
        OutputUtils.print1DIntegerArray(router2.forwardPacket());
        OutputUtils.print1DIntegerArray(router2.forwardPacket());

        System.out.println("--------------------------------------------------------");

        Router router3 = new Router(4);
        System.out.println(router3.addPacket(4, 5, 1));
        System.out.println(router3.getCount(5, 1, 1));

        System.out.println("--------------------------------------------------------");

        Router router4 = new Router(3);
        System.out.println(router4.addPacket(1, 4, 6));
        System.out.println(router4.getCount(4, 1, 4));

        System.out.println("--------------------------------------------------------");

        Router router5 = new Router(2);
        System.out.println(router5.addPacket(2, 5, 1));
        OutputUtils.print1DIntegerArray(router5.forwardPacket());
        System.out.println(router5.getCount(5, 1, 1));

        System.out.println("--------------------------------------------------------");

        Router router6 = new Router(3);
        System.out.println(router6.addPacket(5, 4, 1));
        OutputUtils.print1DIntegerArray(router6.forwardPacket());
        System.out.println(router6.addPacket(1, 2, 1));

        System.out.println("--------------------------------------------------------");

        Router router7 = new Router(5);
        System.out.println(router7.addPacket(3, 4, 4));
        System.out.println(router7.getCount(4, 1, 1));
        OutputUtils.print1DIntegerArray(router7.forwardPacket());

        System.out.println("--------------------------------------------------------");

        Router router8 = new Router(4);
        System.out.println(router8.addPacket(2, 3, 1));
        OutputUtils.print1DIntegerArray(router8.forwardPacket());
        OutputUtils.print1DIntegerArray(router8.forwardPacket());

        System.out.println("--------------------------------------------------------");

        Router router9 = new Router(50000);
        System.out.println(router9.addPacket(2, 1, 5));
        System.out.println(router9.addPacket(2, 1, 6));
        System.out.println(router9.getCount(1, 3, 6));
        System.out.println(router9.addPacket(2, 1, 8));
        System.out.println(router9.getCount(1, 7, 8));
        System.out.println(router9.getCount(1, 1, 8));

        System.out.println("--------------------------------------------------------");

        Router router10 = new Router(2);
        System.out.println(router10.addPacket(4, 3, 1));
        System.out.println(router10.addPacket(5, 2, 1));
        System.out.println(router10.getCount(3, 1, 1));
        System.out.println(router10.addPacket(4, 3, 1));
    }
}
