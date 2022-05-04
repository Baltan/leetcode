package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 1882. Process Tasks Using Servers
 *
 * @author Baltan
 * @date 2022/5/4 12:57
 */
public class AssignTasks {
    public static void main(String[] args) {
        int[] servers1 = {3, 3, 2};
        int[] tasks1 = {1, 2, 3, 2, 1, 2};
        OutputUtils.print1DIntegerArray(assignTasks(servers1, tasks1));

        int[] servers2 = {5, 1, 4, 3, 2};
        int[] tasks2 = {2, 1, 2, 4, 5, 2, 1};
        OutputUtils.print1DIntegerArray(assignTasks(servers2, tasks2));

        int[] servers3 = {10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71};
        int[] tasks3 = {70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5};
        OutputUtils.print1DIntegerArray(assignTasks(servers3, tasks3));

        int[] servers4 =
                {338, 890, 301, 532, 284, 930, 426, 616, 919, 267, 571, 140, 716, 859, 980, 469, 628, 490,
                        195, 664, 925, 652, 503, 301, 917, 563, 82, 947, 910, 451, 366, 190, 253, 516, 503,
                        721, 889, 964, 506, 914, 986, 718, 520, 328, 341, 765, 922, 139, 911, 578, 86, 435,
                        824, 321, 942, 215, 147, 985, 619, 865};
        int[] tasks4 =
                {773, 537, 46, 317, 233, 34, 712, 625, 336, 221, 145, 227, 194, 693, 981, 861, 317, 308, 400,
                        2, 391, 12, 626, 265, 710, 792, 620, 416, 267, 611, 875, 361, 494, 128, 133, 157, 638,
                        632, 2, 158, 428, 284, 847, 431, 94, 782, 888, 44, 117, 489, 222, 932, 494, 948, 405,
                        44, 185, 587, 738, 164, 356, 783, 276, 547, 605, 609, 930, 847, 39, 579, 768, 59, 976,
                        790, 612, 196, 865, 149, 975, 28, 653, 417, 539, 131, 220, 325, 252, 160, 761, 226,
                        629, 317, 185, 42, 713, 142, 130, 695, 944, 40, 700, 122, 992, 33, 30, 136, 773, 124,
                        203, 384, 910, 214, 536, 767, 859, 478, 96, 172, 398, 146, 713, 80, 235, 176, 876,
                        983, 363, 646, 166, 928, 232, 699, 504, 612, 918, 406, 42, 931, 647, 795, 139, 933,
                        746, 51, 63, 359, 303, 752, 799, 836, 50, 854, 161, 87, 346, 507, 468, 651, 32, 717,
                        279, 139, 851, 178, 934, 233, 876, 797, 701, 505, 878, 731, 468, 884, 87, 921, 782,
                        788, 803, 994, 67, 905, 309, 2, 85, 200, 368, 672, 995, 128, 734, 157, 157, 814, 327,
                        31, 556, 394, 47, 53, 755, 721, 159, 843};
        OutputUtils.print1DIntegerArray(assignTasks(servers4, tasks4));
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {
        int[] result = new int[tasks.length];
        int currentTime = 0;
        /**
         * 队列存储所有空闲的服务器，其中每个元素为数组[服务器权重，服务器索引，服务器下次空闲时间]，优先按照服务器权重升序排列，
         * 服务器权重相同时，按照服务器索引升序排列
         */
        Queue<int[]> freeServers =
                new PriorityQueue<>(servers.length, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        /**
         * 队列存储所有正在处理任务的服务器，其中每个元素为数组[服务器权重，服务器索引，服务器下次空闲时间]，按照服务器下次空闲时
         * 间升序排列
         */
        Queue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        /**
         * 初始时，所有服务器都处于空闲状态，即所有服务器的下次空闲时间都为0，将它们加入队列freeServers
         */
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{servers[i], i, 0});
        }
        /**
         * 逐一按顺序处理每个任务
         */
        for (int i = 0; i < tasks.length; ) {
            /**
             * 当前时刻刚好处理完任务的所有服务器重新加入队列freeServers
             */
            while (!busyServers.isEmpty() && busyServers.peek()[2] == currentTime) {
                freeServers.offer(busyServers.poll());
            }
            /**
             * 所以任务开始时间在currentTime之前，还没被处理的任务，都应被当前空闲的服务器处理
             */
            while (currentTime >= i && i < tasks.length && !freeServers.isEmpty()) {
                int[] server = freeServers.poll();
                /**
                 * server处理当前任务后，下次空闲的时间为currentTime+tasks[i]
                 */
                server[2] = currentTime + tasks[i];
                busyServers.offer(server);
                result[i] = server[1];
                i++;
            }
            /**
             * 如果当前已经没有空闲的服务器了，之间将时间跳转到所有处理任务的服务器中最早结束的时刻，避免逐一增加时间导致测试用例
             * 超时
             */
            if (freeServers.isEmpty()) {
                currentTime = busyServers.peek()[2];
            } else {
                currentTime++;
            }
        }
        return result;
    }
}
