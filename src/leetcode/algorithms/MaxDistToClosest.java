package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 849. Maximize Distance to Closest Person
 *
 * @author Baltan
 * @date 2018/8/9 15:11
 */
public class MaxDistToClosest {
    public static void main(String[] args) {
        int[] seats1 = {1, 0, 0, 0, 1, 0, 1};
        System.out.println(maxDistToClosest(seats1));

        int[] seats2 = {1, 0, 0, 0};
        System.out.println(maxDistToClosest(seats2));

        int[] seats3 = {0, 0, 1, 0, 0, 0};
        System.out.println(maxDistToClosest(seats3));
    }

    public static int maxDistToClosest(int[] seats) {
        List<Integer> personList = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                personList.add(i);
            }
        }
        int maxDistance = 0;
        for (int i = 1; i < personList.size(); i++) {
            int distance = personList.get(i) - personList.get(i - 1);
            maxDistance = Math.max(maxDistance, distance / 2);
        }
        maxDistance = Math.max(maxDistance, personList.get(0));
        maxDistance = Math.max(maxDistance, seats.length - 1 - personList.get(personList.size() - 1));
        return maxDistance;
    }
}
