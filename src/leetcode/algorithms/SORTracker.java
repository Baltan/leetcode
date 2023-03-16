package leetcode.algorithms;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Description: 2102. Sequentially Ordinal Rank Tracker
 *
 * @author Baltan
 * @date 2023/3/4 13:13
 */
public class SORTracker {
    /**
     * 从好到坏保存所有景点中最好的那些
     */
    private TreeSet<Location> treeSet1;
    /**
     * 从好到坏保存除了treeSet1中的景点以外的其他所有景点
     */
    private TreeSet<Location> treeSet2;
    /**
     * 下一次查询的次数
     */
    private int callCount;

    public SORTracker() {
        treeSet1 = new TreeSet<>();
        treeSet2 = new TreeSet<>();
        callCount = 1;
    }

    public void add(String name, int score) {
        treeSet1.add(new Location(name, score));
    }

    public String get() {
        /**
         * 第callCount好的景点可能是新加入treeSet1中的景点，也可能是treeSet2中最好的那个景点
         */
        if (!treeSet2.isEmpty()) {
            treeSet1.add(treeSet2.pollFirst());
        }
        /**
         * 在treeSet1中只留下最好的callCount个景点，剩余的先放在treeSet2中
         */
        while (treeSet1.size() > callCount) {
            treeSet2.add(treeSet1.pollLast());
        }
        callCount++;
        return treeSet1.last().name;
    }

    public static void main(String[] args) {
        SORTracker tracker1 = new SORTracker();
        tracker1.add("bradford", 2);
        tracker1.add("branford", 3);
        System.out.println(tracker1.get());
        tracker1.add("alps", 2);
        System.out.println(tracker1.get());
        tracker1.add("orland", 2);
        System.out.println(tracker1.get());
        tracker1.add("orlando", 3);
        System.out.println(tracker1.get());
        tracker1.add("alpine", 2);
        System.out.println(tracker1.get());
        System.out.println(tracker1.get());

        System.out.println("-----------------------------------");

        SORTracker tracker2 = new SORTracker();
        tracker2.add("x", 56);
        System.out.println(tracker2.get());
        tracker2.add("t", 93);
        tracker2.add("q", 32);
        System.out.println(tracker2.get());
        tracker2.add("aw", 77);
        System.out.println(tracker2.get());
        tracker2.add("o", 11);
        System.out.println(tracker2.get());
        tracker2.add("y", 71);
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        tracker2.add("w", 18);
        System.out.println(tracker2.get());
        tracker2.add("ax", 19);
        tracker2.add("ak", 89);
        tracker2.add("ag", 84);
        System.out.println(tracker2.get());
        tracker2.add("v", 50);
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        tracker2.add("g", 31);
        tracker2.add("k", 20);
        tracker2.add("z", 43);
        System.out.println(tracker2.get());
        tracker2.add("aa", 89);
        tracker2.add("u", 4);
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        tracker2.add("m", 78);
        System.out.println(tracker2.get());
        tracker2.add("ae", 7);
        System.out.println(tracker2.get());
        tracker2.add("au", 72);
        tracker2.add("e", 46);
        System.out.println(tracker2.get());
        System.out.println(tracker2.get());
        tracker2.add("r", 34);
        System.out.println(tracker2.get());
        tracker2.add("f", 27);
        System.out.println(tracker2.get());
        tracker2.add("a", 17);
        System.out.println(tracker2.get());
    }

    private static class Location implements Comparable {
        private String name;
        private int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return score == location.score && Objects.equals(name, location.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
        }

        @Override
        public int compareTo(Object o) {
            Location other = (Location) o;
            return score == other.score ? name.compareTo(other.name) : other.score - score;
        }
    }
}
