package leetcode.entity;

import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-07-02 12:06
 * @see NestedInteger
 */
public interface NestedInteger1 {
    /**
     * Return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**
     * Return the single integer that this NestedInteger holds, if it holds a single integer.
     * Return null if this NestedInteger holds a nested list.
     */
    Integer getInteger();


    /**
     * Set this NestedInteger to hold a single integer.
     */
    void setInteger(int value);

    /**
     * Set this NestedInteger to hold a nested list and adds a nested integer to it.
     */
    void add(NestedInteger1 ni);

    /**
     * Return the nested list that this NestedInteger holds, if it holds a nested list.
     * Return null if this NestedInteger holds a single integer.
     */
    List<NestedInteger1> getList();
}
