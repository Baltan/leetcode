package leetcode.algorithms;

import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 1125. Smallest Sufficient Team
 *
 * @author Baltan
 * @date 2024/5/5 19:36
 */
public class SmallestSufficientTeam {
    public static void main(String[] args) {
        String[] reqSkills1 = {"java", "nodejs", "reactjs"};
        List<List<String>> people1 = Arrays.asList(
                Arrays.asList("java"),
                Arrays.asList("nodejs"),
                Arrays.asList("nodejs", "reactjs")
        );
        OutputUtils.print1DIntegerArray(smallestSufficientTeam(reqSkills1, people1));

        String[] reqSkills2 = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> people2 = Arrays.asList(
                Arrays.asList("algorithms", "math", "java"),
                Arrays.asList("algorithms", "math", "reactjs"),
                Arrays.asList("java", "csharp", "aws"),
                Arrays.asList("reactjs", "csharp"),
                Arrays.asList("csharp", "math"),
                Arrays.asList("aws", "java")
        );
        OutputUtils.print1DIntegerArray(smallestSufficientTeam(reqSkills2, people2));

        String[] reqSkills3 = {"hdbxcuzyzhliwv", "uvwlzkmzgis", "sdi", "bztg", "ylopoifzkacuwp", "dzsgleocfpl"};
        List<List<String>> people3 = Arrays.asList(
                Arrays.asList("hdbxcuzyzhliwv", "dzsgleocfpl"),
                Arrays.asList("hdbxcuzyzhliwv", "sdi", "ylopoifzkacuwp", "dzsgleocfpl"),
                Arrays.asList("bztg", "ylopoifzkacuwp"),
                Arrays.asList("bztg", "dzsgleocfpl"),
                Arrays.asList("hdbxcuzyzhliwv", "bztg"),
                Arrays.asList("dzsgleocfpl"),
                Arrays.asList("uvwlzkmzgis"),
                Arrays.asList("dzsgleocfpl"),
                Arrays.asList("hdbxcuzyzhliwv"),
                Arrays.asList(),
                Arrays.asList("dzsgleocfpl"),
                Arrays.asList("hdbxcuzyzhliwv"),
                Arrays.asList(),
                Arrays.asList("hdbxcuzyzhliwv", "ylopoifzkacuwp"),
                Arrays.asList("sdi"),
                Arrays.asList("bztg", "dzsgleocfpl"),
                Arrays.asList("hdbxcuzyzhliwv", "uvwlzkmzgis", "sdi", "bztg", "ylopoifzkacuwp"),
                Arrays.asList("hdbxcuzyzhliwv", "sdi"),
                Arrays.asList("hdbxcuzyzhliwv", "ylopoifzkacuwp"),
                Arrays.asList("sdi", "bztg", "ylopoifzkacuwp", "dzsgleocfpl"),
                Arrays.asList("dzsgleocfpl"),
                Arrays.asList("sdi", "ylopoifzkacuwp"),
                Arrays.asList("hdbxcuzyzhliwv", "uvwlzkmzgis", "sdi"),
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList("ylopoifzkacuwp"),
                Arrays.asList(),
                Arrays.asList("sdi", "bztg"),
                Arrays.asList("bztg", "dzsgleocfpl"),
                Arrays.asList("sdi", "bztg")
        );
        OutputUtils.print1DIntegerArray(smallestSufficientTeam(reqSkills3, people3));
    }

    /**
     * 参考：<a href="https://leetcode.cn/problems/smallest-sufficient-team/solutions/2213332/zui-xiao-de-bi-yao-tuan-dui-by-leetcode-2mbmz/"></a>
     *
     * @param reqSkills
     * @param people
     * @return
     */
    public static int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        /**
         * 用一个二进制数表示已获得的技能，二进制数由低到高第1位为1表示掌握了技能reqSkills[0]；二进制数由低到高第2位为1表示掌握了技能
         * reqSkills[1]……则掌握数组reqSkills中的所有技能用二进制数表示为0b111……111（共reqSkills.length个1），其值为fullSkill
         */
        int fullSkill = (1 << reqSkills.length) - 1;
        /**
         * 掌握每一个技能在二进制数中的表示方式
         */
        Map<String, Integer> skillMap = new HashMap<>();
        /**
         * persons[i]表示people[i]的技能包的二进制数表示
         */
        int[] persons = new int[people.size()];

        for (int i = 0; i < reqSkills.length; i++) {
            skillMap.put(reqSkills[i], i);
        }

        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i)) {
                /**
                 * 二进制数由低到高第skillMap.get(skill)+1位为1表示掌握了技能skill
                 */
                persons[i] |= 1 << skillMap.get(skill);
            }
        }
        /**
         * dp[i][j]表示从团队people中的前i个人员中选择组成技能包的二进制值为j的最少人数方案，题目所求为dp[people.length][fullSkill]
         */
        List<Integer>[][] dp = new List[people.size() + 1][fullSkill + 1];
        /**
         * 一个人都不选则技能包为空
         */
        dp[0][0] = new ArrayList<>();

        for (int i = 1; i <= persons.length; i++) {
            for (int j = 0; j <= fullSkill; j++) {
                if (dp[i - 1][j] != null) {
                    /**
                     * 如果不选择人员people[i-1]，从团队people中的前i个人员中选择组成技能包的二进制值为j的最少人数方案，和从团队people
                     * 中的前i-1个人员中选择相同，如果当前得到的方案人数更少则更新dp[i][j]
                     */
                    if (dp[i][j] == null || dp[i][j].size() >= dp[i - 1][j].size()) {
                        dp[i][j] = new ArrayList<>(dp[i - 1][j]);
                    }
                    /**
                     * 如果选择人员people[i-1]，并且团队people中的前i-1个人员中选择组成技能包的二进制值为j，则加上people[i-1]后，技能
                     * 包的二进制值为j|persons[i-1]，如果当前得到的方案人数更少则更新dp[i][j]
                     */
                    if (dp[i][j | persons[i - 1]] == null || dp[i][j | persons[i - 1]].size() >= dp[i - 1][j].size() + 1) {
                        dp[i][j | persons[i - 1]] = new ArrayList<>(dp[i - 1][j]);
                        dp[i][j | persons[i - 1]].add(i - 1);
                    }
                }
            }
        }
        return dp[persons.length][fullSkill].stream().mapToInt(x -> x).toArray();
    }
}
