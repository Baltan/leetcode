package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: 3508. Implement Router
 *
 * @author Baltan
 * @date 2025/4/19 22:42
 */
public class Router {
    private int memoryLimit;
    private LinkedHashSet<String> packets;
    private Map<Integer, TreeMap<Integer, Integer>> destinationMap;
    private String pattern;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new LinkedHashSet<>();
        this.destinationMap = new HashMap<>();
        this.pattern = "%d.%d.%d";
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String packet = pattern.formatted(source, destination, timestamp);

        if (packets.contains(packet)) {
            return false;
        }

        if (packets.size() == memoryLimit) {
            int[] removedPacket = parsePacketPattern(packets.removeFirst());
            packets.add(packet);

            if (destination == removedPacket[1] && timestamp == removedPacket[2]) {
                return true;
            }
            TreeMap<Integer, Integer> timestampMap = destinationMap.get(removedPacket[1]);

            if (timestampMap.get(removedPacket[2]) == 1) {
                timestampMap.remove(removedPacket[2]);
            } else {
                timestampMap.merge(removedPacket[2], -1, Integer::sum);
            }
            destinationMap.computeIfAbsent(destination, x -> new TreeMap<>())
                    .merge(timestamp, 1, Integer::sum);
        } else {
            packets.add(packet);
            destinationMap.computeIfAbsent(destination, x -> new TreeMap<>())
                    .merge(timestamp, 1, Integer::sum);
        }
        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        }
        int[] removedPacket = parsePacketPattern(packets.removeFirst());
        TreeMap<Integer, Integer> timestampMap = destinationMap.get(removedPacket[1]);

        if (timestampMap.get(removedPacket[2]) == 1) {
            timestampMap.remove(removedPacket[2]);
        } else {
            timestampMap.merge(removedPacket[2], -1, Integer::sum);
        }
        return removedPacket;
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> timestampMap = destinationMap.get(destination);

        if (timestampMap == null) {
            return 0;
        }
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : timestampMap.subMap(startTime, true, endTime, true).entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    private int[] parsePacketPattern(String packetPattern) {
        int firstSeparator = packetPattern.indexOf('.');
        int lastSeparator = packetPattern.lastIndexOf('.');
        return new int[]{Integer.parseInt(packetPattern.substring(0, firstSeparator)),
                Integer.parseInt(packetPattern.substring(firstSeparator + 1, lastSeparator)),
                Integer.parseInt(packetPattern.substring(lastSeparator + 1))};
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
    }
}
