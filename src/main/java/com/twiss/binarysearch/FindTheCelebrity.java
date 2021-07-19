package com.twiss.binarysearch;

import java.util.Stack;

/**
 * @Author: Twiss
 * @Date: 2021/7/19 4:23 下午
 */
public class FindTheCelebrity {

    private int getTheCelebrityIndex(int[][] candidates) {
        Stack<Integer> people = new Stack<>();
        int length = candidates.length;
        if (length <= 0) {
            return -1;
        }
        if (length == 1) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            people.push(i);
        }
        int a, b = 0;
        while (people.size() > 1) {
            a = people.pop();
            b = people.pop();
            if (knows(candidates, a, b)) {
                people.push(b);
            } else {
                people.push(a);
            }
        }
        int c = people.pop();
        for (int i = 0; i < length; i++) {
            if (i!=c&&knows(candidates,c,i)||!knows(candidates,i,c)){
                return -1;
            }
        }
        return c;
    }

    private boolean knows(int[][] candidates, int a, int b) {
        return candidates[a][b] == 1;
    }

    public static void main(String[] args) {
        int[][] circle = {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int res = new FindTheCelebrity().getTheCelebrityIndex(circle);
        System.out.println(res);
    }
}
