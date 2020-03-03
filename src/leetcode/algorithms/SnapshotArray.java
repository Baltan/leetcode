package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 1146. Snapshot Array
 *
 * @author Baltan
 * @date 2020-03-03 17:44
 */
public class SnapshotArray {
    /**
     * 快照版本号 -> 对应版本的快照数据
     */
    private Map<Integer, Map<Integer, Integer>> snapshotMap;
    /**
     * 最近一个版本的下一版本快照的版本号
     */
    private int snapshotId;
    /**
     * 当前还没生成快照的数据
     */
    private Map<Integer, Integer> snapshot;

    public SnapshotArray(int length) {
        this.snapshotMap = new HashMap<>();
        this.snapshotId = 0;
        this.snapshot = new HashMap<>();
    }

    public void set(int index, int val) {
        snapshot.put(index, val);
    }

    public int snap() {
        /**
         * 将当前数据生成一个版本的快照保存下来
         */
        snapshotMap.put(snapshotId, new HashMap<>(snapshot));
        int oldSnapshotId = snapshotId;
        snapshotId++;
        return oldSnapshotId;
    }

    public int get(int index, int snap_id) {
        return snapshotMap.get(snap_id).getOrDefault(index, 0);
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray1 = new SnapshotArray(3);
        snapshotArray1.set(0, 5);
        System.out.println(snapshotArray1.snap());
        snapshotArray1.set(0, 6);
        System.out.println(snapshotArray1.get(0, 0));

        System.out.println("-------------------");

        SnapshotArray snapshotArray2 = new SnapshotArray(1);
        snapshotArray2.set(0, 4);
        snapshotArray2.set(0, 16);
        snapshotArray2.set(0, 13);
        System.out.println(snapshotArray2.snap());
        System.out.println(snapshotArray2.get(0, 0));
        System.out.println(snapshotArray2.snap());
    }
}
