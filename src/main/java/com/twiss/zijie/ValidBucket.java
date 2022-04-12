package com.twiss.zijie;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 * 时间复杂度O(n)
 * 时间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/12 5:19 下午
 */
public class ValidBucket {

    public boolean isValid(String s){
        if (s==null||s.length()==0){
            return false;
        }
        int n = s.length();
        if (n%2==1){
            return false;
        }
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put('}','{');
        pairs.put(')','(');
        pairs.put(']','[');
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<n;++i){
            Character character = s.charAt(i);
            if (pairs.containsKey(character)){
                if (stack.isEmpty()||stack.peek()!=pairs.get(character)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}()";
        boolean ans = new ValidBucket().isValid(s);
        System.out.println(ans);
    }
}
