package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Description: Reorder Log Files
 *
 * @author Baltan
 * @date 2019-03-15 09:14
 */
public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] logs1 = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        OutputUtils.print1DStringArray(reorderLogFiles(logs1));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Map<String, String> letterLogMap = new TreeMap<>();
        List<String> digitLogList = new ArrayList<>();
        int length = logs.length;
        String[] result = new String[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            String log = logs[i];
            if (isDigitLog(log)) {
                digitLogList.add(log);
            } else {
                letterLogMap.put(log.substring(log.indexOf(" ") + 1), log);
            }
        }

        for (String key : letterLogMap.keySet()) {
            result[index++] = letterLogMap.get(key);
        }

        for (String log : digitLogList) {
            result[index++] = log;
        }
        return result;
    }

    public static boolean isDigitLog(String log) {
        String str = log.split(" ")[1];
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
