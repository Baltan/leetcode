package leetcode.entity;

import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2018/7/27 14:48
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
