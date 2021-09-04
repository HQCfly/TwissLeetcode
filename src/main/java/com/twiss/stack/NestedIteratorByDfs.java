package com.twiss.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/9/4 10:52 下午
 */
public class NestedIteratorByDfs implements Iterator<Integer> {

    Deque<Integer> queue = new LinkedList<>();

    public NestedIteratorByDfs(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext()?queue.poll():-1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger: nestedList){
            if (nestedInteger.isInteger()){
                queue.offer(nestedInteger.getInteger());
            }else {
                dfs(nestedList);
            }
        }
    }

}
