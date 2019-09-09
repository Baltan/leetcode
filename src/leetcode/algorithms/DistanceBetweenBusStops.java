package leetcode.algorithms;

/**
 * Description: 1184. Distance Between Bus Stops
 *
 * @author Baltan
 * @date 2019-09-09 09:35
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] distance1 = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops(distance1, 0, 1));

        int[] distance2 = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops(distance2, 0, 2));

        int[] distance3 = {1, 2, 3, 4};
        System.out.println(distanceBetweenBusStops(distance3, 0, 3));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        /**
         * 计算所有车站之间的总距离
         */
        int totalDistance = 0;
        /**
         * 计算从较小编号车站顺着编号递增的方向开往较大编号车站的总距离（可能start->destination，也可能
         * destination->start）
         */
        int partDistance = 0;
        int stopNum = distance.length;
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);

        for (int i = 0; i < min; i++) {
            totalDistance += distance[i];
        }

        for (int i = min; i < max; i++) {
            totalDistance += distance[i];
            partDistance += distance[i];
        }

        for (int i = max; i < stopNum; i++) {
            totalDistance += distance[i];
        }
        return Math.min(partDistance, totalDistance - partDistance);
    }
}
