package leetcode.algorithms;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Description: 2502. Design Memory Allocator
 *
 * @author Baltan
 * @date 2022/12/14 14:07
 */
public class Allocator {
    /**
     * 内存总大小
     */
    private int memorySize;
    /**
     * 可分配的内存大小
     */
    private int availableMemorySize;
    /**
     * mID -> mID已占用的连续内存空间列表，Point.x表示某个连续内存空间最左边的内存块的索引，Point.y表示某个连续内存空间最右边的内存块的索引
     */
    Map<Integer, List<Point>> allocateMap;
    /**
     * 已占用的所有连续内存空间集合，Point.x表示某个连续内存空间最左边的内存块的索引，Point.y表示某个连续内存空间最右边的内存块的索引
     */
    Set<Point> allocatedBlocks = new HashSet<>();

    public Allocator(int n) {
        memorySize = n;
        availableMemorySize = n;
        allocateMap = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        /**
         * 需要分配的内存大于可分配的内存大小，无法分配出大小为size的连续内存空间
         */
        if (size > availableMemorySize) {
            return -1;
        }
        List<Point> allocatedBlockList = new ArrayList<>(allocatedBlocks);
        /**
         * 对已占用的所有连续内存空间进行排序，按照每个连续内存空间最左边的内存块的索引升序排列
         */
        Collections.sort(allocatedBlockList, Comparator.comparingInt(block -> block.x));

        if (allocatedBlockList.size() == 0 || allocatedBlockList.get(0).x >= size) {
            /**
             * 先尝试从索引为0的内存块开始分配大小为size的连续内存空间
             */
            Point block = new Point(0, size - 1);
            doAllocate(mID, block);
            return 0;
        } else {
            int blockCount = allocatedBlockList.size();
            /**
             * 再尝试从左至右在已占用的所有连续内存空间之间分配大小为size的连续内存空间
             */
            for (int i = 1; i < blockCount; i++) {
                if (allocatedBlockList.get(i).x - allocatedBlockList.get(i - 1).y - 1 >= size) {
                    Point block = new Point(allocatedBlockList.get(i - 1).y + 1, allocatedBlockList.get(i - 1).y + size);
                    doAllocate(mID, block);
                    return allocatedBlockList.get(i - 1).y + 1;
                }
            }
            /**
             * 再尝试在最后一段连续内存空间分配大小为size的连续内存空间
             */
            if (memorySize - 1 - (allocatedBlockList.get(blockCount - 1).y + 1) + 1 >= size) {
                Point block = new Point(allocatedBlockList.get(blockCount - 1).y + 1, allocatedBlockList.get(blockCount - 1).y + size);
                doAllocate(mID, block);
                return allocatedBlockList.get(blockCount - 1).y + 1;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int result = 0;
        List<Point> blockList = allocateMap.remove(mID);
        /**
         * mID没有占用内存空间
         */
        if (Objects.isNull(blockList)) {
            return 0;
        }

        for (Point block : blockList) {
            int freedMemorySize = block.y - block.x + 1;
            result += freedMemorySize;
            allocatedBlocks.remove(block);
            availableMemorySize += freedMemorySize;
        }
        return result;
    }

    /**
     * 分配内存
     *
     * @param mID
     * @param block
     */
    private void doAllocate(int mID, Point block) {
        List<Point> mIDAllocatedBlockList = allocateMap.computeIfAbsent(mID, i -> new ArrayList<>());
        mIDAllocatedBlockList.add(block);
        availableMemorySize -= (block.y - block.x + 1);
        allocatedBlocks.add(block);
    }

    public static void main(String[] args) {
        Allocator allocator1 = new Allocator(10);
        System.out.println(allocator1.allocate(1, 1));
        System.out.println(allocator1.allocate(1, 2));
        System.out.println(allocator1.allocate(1, 3));
        System.out.println(allocator1.free(2));
        System.out.println(allocator1.allocate(3, 4));
        System.out.println(allocator1.allocate(1, 1));
        System.out.println(allocator1.allocate(1, 1));
        System.out.println(allocator1.free(1));
        System.out.println(allocator1.allocate(10, 2));
        System.out.println(allocator1.free(7));

        System.out.println("--------------------------------");

        Allocator allocator2 = new Allocator(5);
        System.out.println(allocator2.free(4));
        System.out.println(allocator2.allocate(9, 5));
        System.out.println(allocator2.allocate(5, 8));
        System.out.println(allocator2.allocate(4, 8));
        System.out.println(allocator2.allocate(3, 2));
        System.out.println(allocator2.free(6));
        System.out.println(allocator2.allocate(9, 9));
        System.out.println(allocator2.free(6));
    }
}
