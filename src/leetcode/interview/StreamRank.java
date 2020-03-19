package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 面试题 10.10. 数字流的秩
 *
 * @author Baltan
 * @date 2020-03-19 13:33
 */
public class StreamRank {
    private List<Integer> list;

    public StreamRank() {
        this.list = new ArrayList<>();
    }

    public void track(int x) {
        if (list.isEmpty()) {
            list.add(x);
            return;
        }

        int lo = 0;
        int hi = list.size() - 1;
        /**
         * 二分查找list中第一个大于x的数的索引位置
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 如果list.get(hi)不大于x，说明list中没有比x大的数，将x插入到list最后即可，否则将x插入到
         * list.get(hi)之前
         */
        if (list.get(hi) > x) {
            list.add(hi, x);
        } else {
            list.add(x);
        }
    }

    public int getRankOfNumber(int x) {
        if (list.isEmpty()) {
            return 0;
        }

        int lo = 0;
        int hi = list.size() - 1;
        /**
         * 二分查找list中第一个大于x的数的索引位置
         */
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        /**
         * 如果list.get(hi)不大于x，说明list中没有比x大的数，否则list.get(hi)之前的数小于等于x
         */
        return list.get(hi) > x ? hi : hi + 1;
    }

    public static void main(String[] args) {
        StreamRank streamRank1 = new StreamRank();
        System.out.println(streamRank1.getRankOfNumber(1));
        streamRank1.track(0);
        System.out.println(streamRank1.getRankOfNumber(0));

        System.out.println("-----------------");

        StreamRank streamRank2 = new StreamRank();
        streamRank2.track(4);
        streamRank2.track(3);
        streamRank2.track(5);
        System.out.println(streamRank2.getRankOfNumber(8));
        streamRank2.track(3);
        System.out.println(streamRank2.getRankOfNumber(2));
        streamRank2.track(1);
        streamRank2.track(5);
        System.out.println(streamRank2.getRankOfNumber(3));
        System.out.println(streamRank2.getRankOfNumber(5));
        streamRank2.track(1);
        System.out.println(streamRank2.getRankOfNumber(9));
        streamRank2.track(6);
        System.out.println(streamRank2.getRankOfNumber(3));
        streamRank2.track(4);
        streamRank2.track(1);
        System.out.println(streamRank2.getRankOfNumber(7));
        streamRank2.track(9);
        streamRank2.track(2);
        streamRank2.track(9);
    }
}
