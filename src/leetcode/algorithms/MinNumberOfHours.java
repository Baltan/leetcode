package leetcode.algorithms;

/**
 * Description: 2383. Minimum Hours of Training to Win a Competition
 *
 * @author Baltan
 * @date 2023/2/13 09:38
 */
public class MinNumberOfHours {
    public static void main(String[] args) {
        System.out.println(minNumberOfHours(30, 78, new int[]{24, 91, 63, 38, 31, 63, 22, 35, 91, 54, 88, 46, 80, 14, 12, 19, 57, 92}, new int[]{18, 43, 36, 88, 84, 21, 82, 54, 61, 80, 68, 54, 75, 27, 99, 14, 86, 95}));
        System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println(minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int length = energy.length;
        /**
         * 假设一开始的精力为minEnergy，则
         * minEnergy>energy[0]
         * minEnergy-energy[0]>energy[1]
         * minEnergy-energy[0]-energy[1]>energy[2]
         * ……
         * 所以，minEnergy>energy[0]+energy[1]+energy[2]+……+energy[length-1]
         * 令totalEnergy=energy[0]+energy[1]+energy[2]+……+energy[length-1]
         */
        int totalEnergy = 0;
        /**
         * 假设一开始的经验为minExperience，则
         * minExperience>experience[0]
         * minExperience+experience[0]>experience[1] => minExperience>experience[1]-experience[0]
         * minExperience+experience[0]+experience[1]>experience[2] =>
         *                                              minExperience>experience[2]-experience[1]-experience[0]
         * ……
         * 令maxExperience=Math.max(experience[0],experience[1]-experience[0],experience[2]-experience[1]-experience[0],……)
         */
        int maxExperience = 0;
        /**
         * 循环过程中累计获得的经验
         */
        int addExperience = 0;

        for (int i = 0; i < length; i++) {
            totalEnergy += energy[i];
            maxExperience = Math.max(maxExperience, experience[i] - addExperience);
            addExperience += experience[i];
        }
        /**
         * 如果初始时精力和经验就满足需求，则不需要训练
         */
        int result = (totalEnergy + 1 <= initialEnergy ? 0 : totalEnergy + 1 - initialEnergy) + (maxExperience + 1 <= initialExperience ? 0 : maxExperience + 1 - initialExperience);
        return result;
    }
}
