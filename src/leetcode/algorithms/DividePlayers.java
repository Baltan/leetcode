package leetcode.algorithms;

/**
 * Description: 2491. Divide Players Into Teams of Equal Skill
 *
 * @author Baltan
 * @date 2022/12/5 16:10
 */
public class DividePlayers {
    public static void main(String[] args) {
        System.out.println(dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
        System.out.println(dividePlayers(new int[]{3, 4}));
        System.out.println(dividePlayers(new int[]{1, 1, 2, 3}));
    }

    public static long dividePlayers(int[] skill) {
        long result = 0L;
        /**
         * 二人团队数
         */
        int groups = skill.length / 2;
        /**
         * 所有玩家的技能点之和
         */
        int sum = 0;
        /**
         * skillCount[i]表示技能点为i的玩家的个数。根据题意，技能点skill[i]∈[1,1000]
         */
        int[] skillCount = new int[1001];

        for (int value : skill) {
            sum += value;
            skillCount[value]++;
        }
        /**
         * 所有玩家的技能点之和不能平均分成groups个二人团队
         */
        if (sum % groups != 0) {
            return -1L;
        }
        /**
         * 每个二人团队的技能点之和
         */
        int skillPerGroup = sum / groups;

        for (int oneSkill = 0; oneSkill <= 1000; oneSkill++) {
            if (skillCount[oneSkill] == 0) {
                continue;
            }
            /**
             * 另一个玩家的技能点
             */
            int otherSkill = skillPerGroup - oneSkill;

            if (oneSkill == otherSkill) {
                if (skillCount[oneSkill] % 2 != 0) {
                    return -1L;
                }
                /**
                 * 共skillCount[oneSkill]/2个二人团队
                 */
                result += 1L * oneSkill * oneSkill * skillCount[oneSkill] / 2;
            } else {
                if (skillCount[oneSkill] != skillCount[otherSkill]) {
                    return -1L;
                }
                /**
                 * 共skillCount[oneSkill]个二人团队
                 */
                result += 1L * oneSkill * otherSkill * skillCount[oneSkill];
                /**
                 * 已经计算过的技能点归零，避免重复累计
                 */
                skillCount[oneSkill] = 0;
                skillCount[otherSkill] = 0;
            }
        }
        return result;
    }
}
