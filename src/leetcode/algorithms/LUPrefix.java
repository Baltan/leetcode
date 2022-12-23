package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 2424. Longest Uploaded Prefix
 *
 * @author Baltan
 * @date 2022/12/14 11:28
 */
public class LUPrefix {
    /**
     * 保存最长上传前缀之外的视频的编号
     */
    private Queue<Integer> pq;
    /**
     * 最长上传前缀的长度
     */
    private int prefixLength;

    public LUPrefix(int n) {
        pq = new PriorityQueue<>(n);
        prefixLength = 0;
    }

    public void upload(int video) {
        if (video == prefixLength + 1) {
            prefixLength++;
            /**
             * 判断之前已有的视频编号能否使得上传前缀更长
             */
            while (!pq.isEmpty() && pq.peek() == prefixLength + 1) {
                pq.poll();
                prefixLength++;
            }
        } else {
            pq.offer(video);
        }
    }

    public int longest() {
        return prefixLength;
    }

    public static void main(String[] args) {
        LUPrefix luPrefix1 = new LUPrefix(4);
        luPrefix1.upload(3);
        System.out.println(luPrefix1.longest());
        luPrefix1.upload(1);
        System.out.println(luPrefix1.longest());
        luPrefix1.upload(2);
        System.out.println(luPrefix1.longest());
    }
}
