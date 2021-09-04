package com.twiss.stack;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/9/4 10:52 下午
 */
public class NestedIteratorByIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIteratorByIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1;i>=0;--i){
            stack.addLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext()?stack.pollLast().getInteger():-1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()){
            return false;
        }else {
            NestedInteger item = stack.peekLast();
            if (item.isInteger()){
                return true;
            }else {
                item = stack.pollLast();
                List<NestedInteger> list = item.getList();
                for (int i=list.size()-1;i>=0;--i){
                    stack.addLast(list.get(i));
                }
                return hasNext();
            }
        }
    }



}
