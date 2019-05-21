package leetcode.algorithms;

/**
 * Description: 434. Number of Segments in a String
 *
 * @author Baltan
 * @date 2017/11/24 16:18
 */
public class CountSegments {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments(""));
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        if ("".equals(s.trim())) {
            return 0;
        }
        int segmentNum = 0;
        if (!" ".equals(s.substring(0, 1))) {
            segmentNum++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!" ".equals(s.substring(i, i + 1)) && " ".equals(s.substring(i - 1, i))) {
                segmentNum++;
            }
        }
        return segmentNum;
    }
}
