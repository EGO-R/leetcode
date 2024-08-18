package neetcode.medium.flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private List<NestedInteger> list;
    private int val;
    private boolean isInteger;

    public NestedInteger(int val) {
        this.val = val;
        isInteger = true;
    }

    public NestedInteger(List<Integer> list) {
        this.list = new ArrayList<>();
        for (var val : list)
            this.list.add(new NestedInteger(val));
        isInteger = false;
    }


    public boolean isInteger() {
        return isInteger;
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
