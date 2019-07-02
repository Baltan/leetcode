package leetcode.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-07-02 12:06
 * @see NestedIntegerImpl
 */
public class NestedInteger1Impl implements NestedInteger1 {
    private Object obj;

    public NestedInteger1Impl() {
    }

    public NestedInteger1Impl(int value) {
        this.obj = value;
    }

    @Override
    public boolean isInteger() {
        return obj instanceof Integer;
    }

    @Override
    public Integer getInteger() {
        if (isInteger()) {
            return (Integer) obj;
        }
        return null;
    }

    @Override
    public void setInteger(int value) {
        this.obj = value;
    }

    @Override
    public void add(NestedInteger1 ni) {
        List<NestedInteger1> list = new LinkedList<>();
        list.add(ni);
        this.obj = list;
    }

    @Override
    public List<NestedInteger1> getList() {
        if (!isInteger()) {
            return (List<NestedInteger1>) obj;
        }
        return null;
    }
}
