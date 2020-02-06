package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Random;

/**
 * Description: 497. Random Point in Non-overlapping Rectangles
 *
 * @author Baltan
 * @date 2020-02-06 13:26
 */
public class Solution11 {
    /**
     * areas[i]为一个含有两个元素的数组，其中areas[i][0]为rects[0]-rects[i-1]整数点的总个数，
     * areas[i][1]的值为i-1。最后得到areas为[[0,0],[S1,0],[S2,1],[S3,2],……,[Si,i-1]]。
     * 产生随机点的步骤为：
     * 1、产生一个在[0,Si)之间的随机数k，通过二分查找确定k位于areas的哪个区间中，如果k∈[0,S1)
     * 就在第0个矩形或线段上产生随机点；如果k∈[S1,S2)，就在第1个矩形或线段上产生随机点；以此类推，
     * 如果k∈[Si-1,Si)，就在第i-1个矩形或线段上产生随机点。
     * 2、在以上确定的矩形或线段上产生随机整数点。
     * 3、所有矩形或线段上的整数点的总个数的m，第i个矩形或线段上的整数点的总个数为n，则第一步后要
     * 在第i个矩形或线段上产生随机点的概率为n/m，其中这n个点每个点被选中的概率为1/n，所以所有矩形
     * 或线段上的整数点每一个被选中的概率P=(n/m)*(1/n)=1/m。
     */
    private int[][] areas;
    private int[][] rects;
    private Random rand;
    /**
     * 所有矩形或线段上的整数点的总个数
     */
    private int totalArea;

    public Solution11(int[][] rects) {
        int length = rects.length;
        this.rects = rects;
        this.areas = new int[length + 1][2];

        for (int i = 0; i < length; i++) {
            int[] rect = rects[i];
            /**
             * 每个矩形或者线段上的整数点的个数为(x2-x1+1)*(y2-y1+1)
             */
            areas[i + 1] = new int[]{areas[i][0] + (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1), i};
        }

        this.rand = new Random();
        this.totalArea = areas[length][0];
    }

    public int[] pick() {
        int num = rand.nextInt(totalArea);
        int index = getIndex(num);
        int[] rect = rects[index];
        int x = rect[0] == rect[2] ? rect[0] : rect[0] + rand.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] == rect[3] ? rect[1] : rect[1] + rand.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }

    /**
     * 二分查找确定num位于areas的哪个区间中
     */
    private int getIndex(int num) {
        int lo = 1;
        int hi = rects.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (num >= areas[mid][0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return areas[hi][1];
    }

    public static void main(String[] args) {
        int[][] rects1 = {{1, 1, 5, 5}};
        Solution11 solution111 = new Solution11(rects1);

        for (int i = 0; i < 20; i++) {
            OutputUtils.print1DIntegerArray(solution111.pick());
        }

        System.out.println();

        int[][] rects2 = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
        Solution11 solution112 = new Solution11(rects2);

        for (int i = 0; i < 20; i++) {
            OutputUtils.print1DIntegerArray(solution112.pick());
        }
    }
}
