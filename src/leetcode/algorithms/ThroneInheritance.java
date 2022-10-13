package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 1600. Throne Inheritance
 *
 * @author Baltan
 * @date 2022/10/8 21:50
 */
public class ThroneInheritance {
    /**
     * King作为根节点生成一棵人物关系树
     */
    private Person king;
    /**
     * 姓名 -> 人，只保存当前活着的人
     */
    private Map<String, Person> nameMap;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName, new ArrayList<>());
        nameMap = new HashMap<>();
        nameMap.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person child = new Person(childName, new ArrayList<>());
        nameMap.get(parentName).getChildren().add(child);
        nameMap.put(childName, child);
    }

    public void death(String name) {
        nameMap.remove(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preOrder(order, king);
        return order;
    }

    /**
     * 前序遍历人物关系树
     *
     * @param order
     * @param king
     */
    private void preOrder(List<String> order, Person king) {
        if (nameMap.containsKey(king.getName())) {
            order.add(king.name);
        }

        for (Person child : king.getChildren()) {
            preOrder(order, child);
        }
    }

    public static class Person {
        private String name;
        private List<Person> children;

        public Person(String name, List<Person> children) {
            this.name = name;
            this.children = children;
        }

        public String getName() {
            return name;
        }

        public List<Person> getChildren() {
            return children;
        }
    }

    public static void main(String[] args) {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}
