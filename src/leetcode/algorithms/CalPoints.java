package leetcode.algorithms;

import java.util.ArrayList;

/**
 * Description:Baseball Game
 *
 * @author Baltan
 * @date 2017/12/29 11:13
 */
public class CalPoints {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] ops) {
        ArrayList<Integer> validScoreList = new ArrayList<>();
        String reg = "^-?\\d+$";
        int point = 0;
        for (int i = 0; i < ops.length; i++) {
            String currString = ops[i];
            if (currString.matches(reg)) {
                int score = Integer.valueOf(currString);
                point += score;
                validScoreList.add(score);
            } else if ("+".equals(currString)) {
                int validScoreListSize = validScoreList.size();
                if (validScoreListSize >= 2) {
                    point = point + validScoreList.get(validScoreListSize - 1) + validScoreList.get(validScoreListSize - 2);
                    validScoreList.add(validScoreList.get(validScoreListSize - 1) + validScoreList.get(validScoreListSize - 2));
                } else if (validScoreListSize == 1) {
                    point += validScoreList.get(0);
                    validScoreList.add(validScoreList.get(0));
                }
            } else if ("D".equals(currString)) {
                int validScoreListSize = validScoreList.size();
                if (validScoreListSize >= 1) {
                    point += validScoreList.get(validScoreListSize - 1) * 2;
                    validScoreList.add(validScoreList.get(validScoreListSize - 1) * 2);
                }
            } else if ("C".equals(currString)) {
                int validScoreListSize = validScoreList.size();
                if (validScoreListSize >= 1) {
                    point -= validScoreList.get(validScoreListSize - 1);
                    validScoreList.remove(validScoreListSize - 1);
                }
            }
        }
        return point;
    }
}
