package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Binary Watch
 *
 * @author Baltan
 * @date 2018/1/4 13:33
 */
public class ReadBinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(0));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> timeList = new ArrayList<>();
        if (num < 0 || num > 8) {
            return timeList;
        }
        for (int i = 0; i < 12; i++) {
            String hour = String.valueOf(i);
            int hourOnNum = Integer.bitCount(i);
            int leftNum = num - hourOnNum;
            for (int j = 0; j < 60; j++) {
                int minuteOnNum = Integer.bitCount(j);
                if (leftNum == minuteOnNum) {
                    String minute = j < 10 ? "0" + j : String.valueOf(j);
                    timeList.add(hour + ":" + minute);
                }
            }
        }
        return timeList;
    }
}
