package leetcode.entity;

import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-06-25 09:53
 */
public class NestedIntegerImpl implements NestedInteger {
    private Object obj;

    public NestedIntegerImpl(Object obj) {
        if (obj != null && !(obj instanceof Integer) && !(obj instanceof List)) {
            throw new IllegalArgumentException("obj应为integer类型或NestedInteger List类型");
        }
        this.obj = obj;
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
    public List<NestedInteger> getList() {
        if (!isInteger()) {
            return (List<NestedInteger>) obj;
        }
        return null;
    }
}
