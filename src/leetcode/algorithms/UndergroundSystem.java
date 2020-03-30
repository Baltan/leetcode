package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1396. Design Underground System
 *
 * @author Baltan
 * @date 2020-03-30 15:52
 */
public class UndergroundSystem {
    /**
     * 出发车站 -> [到达车站 -> 出发车站至到达车站这段行程的累计总时间]
     */
    private Map<String, Map<String, Integer>> totalTimeMap;
    /**
     * 出发车站 -> [到达车站 -> 出发车站至到达车站这段行程的累计总趟数]
     */
    private Map<String, Map<String, Integer>> tripCountMap;
    /**
     * 乘客id -> 乘客进入地铁站时的出发车站和出发时间信息
     */
    private Map<Integer, CheckInInfo> checkInMap;

    public UndergroundSystem() {
        this.totalTimeMap = new HashMap<>();
        this.tripCountMap = new HashMap<>();
        this.checkInMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        /**
         * 保存该id的乘客最后一次进入地铁站时的出发车站和出发时间信息
         */
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        /**
         * 该id的乘客最后一次进入地铁站时的出发车站和出发时间信息
         */
        CheckInInfo checkInInfo = checkInMap.get(id);
        /**
         * 该id的乘客最后一次的出发车站
         */
        String startStation = checkInInfo.startStation;
        /**
         * 该id的乘客最后一次的出发时间
         */
        int startTime = checkInInfo.startTime;
        /**
         * 到达车站 -> 出发车站至到达车站这段行程的累计总时间
         */
        Map<String, Integer> m1 = totalTimeMap.getOrDefault(startStation, new HashMap<>());
        m1.put(stationName, m1.getOrDefault(stationName, 0) + t - startTime);
        totalTimeMap.put(startStation, m1);
        /**
         * 到达车站 -> 出发车站至到达车站这段行程的累计总趟数
         */
        Map<String, Integer> m2 = tripCountMap.getOrDefault(startStation, new HashMap<>());
        m2.put(stationName, m2.getOrDefault(stationName, 0) + 1);
        tripCountMap.put(startStation, m2);
    }

    public double getAverageTime(String startStation, String endStation) {
        /**
         * startStation至endStation这段行程的累计总时间
         */
        int totalTime = totalTimeMap.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, 0);
        /**
         * startStation至endStation这段行程的累计总趟数
         */
        int tripCount = tripCountMap.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, 0);
        return tripCount == 0 ? 0 : 1.0 * totalTime / tripCount;
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem1 = new UndergroundSystem();
        undergroundSystem1.checkIn(45, "Leyton", 3);
        undergroundSystem1.checkIn(32, "Paradise", 8);
        undergroundSystem1.checkIn(27, "Leyton", 10);
        undergroundSystem1.checkOut(45, "Waterloo", 15);
        undergroundSystem1.checkOut(27, "Waterloo", 20);
        undergroundSystem1.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem1.getAverageTime("Paradise", "Cambridge"));
        System.out.println(undergroundSystem1.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem1.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem1.getAverageTime("Leyton", "Waterloo"));
        undergroundSystem1.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem1.getAverageTime("Leyton", "Waterloo"));
    }

    /**
     * 记录出发车站和出发时间
     */
    private class CheckInInfo {
        /**
         * 出发车站
         */
        private String startStation;
        /**
         * 出发时间
         */
        private int startTime;

        public CheckInInfo(String startStation, int startTime) {
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }
}
