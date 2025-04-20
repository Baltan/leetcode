package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * Description: 3508. Implement Router
 *
 * @author Baltan
 * @date 2025/4/19 22:42
 */
public class Router {
    private final int maxDestination = 200000;
    private int memoryLimit;
    private LinkedHashSet<Packet> packets;
    private List<Integer>[] timestampsArray;
    private int[] indexes;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new LinkedHashSet<>();
        this.timestampsArray = new List[maxDestination + 1];
        this.indexes = new int[maxDestination + 1];

        for (int i = 0; i <= maxDestination; i++) {
            timestampsArray[i] = new ArrayList<>();
        }
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet addedPacket = new Packet(source, destination, timestamp);

        if (packets.contains(addedPacket)) {
            return false;
        }

        if (packets.size() == memoryLimit) {
            Packet removedPacket = packets.removeFirst();
            indexes[removedPacket.destination]++;
        }
        packets.addLast(addedPacket);
        List<Integer> prefixSums = timestampsArray[addedPacket.destination];
        prefixSums.add(addedPacket.timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        Packet removedPacket = packets.removeFirst();
        indexes[removedPacket.destination]++;
        return new int[]{removedPacket.source, removedPacket.destination, removedPacket.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> prefixSums = timestampsArray[destination];

        if (indexes[destination] >= prefixSums.size() || prefixSums.get(indexes[destination]) > endTime || prefixSums.getLast() < startTime) {
            return 0;
        }
        int startIndex = getStartIndex(prefixSums, startTime, indexes[destination]);
        int endIndex = getEndIndex(prefixSums, endTime, indexes[destination]);
        return endIndex - startIndex + 1;
    }

    private int getStartIndex(List<Integer> prefixSums, int startTime, int first) {
        int lo = first;
        int hi = prefixSums.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (prefixSums.get(mid) < startTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int getEndIndex(List<Integer> prefixSums, int endTime, int first) {
        int lo = first;
        int hi = prefixSums.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;

            if (prefixSums.get(mid) > endTime) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static class Packet {
        private int source;
        private int destination;
        private int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
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
    }
}
