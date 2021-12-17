package com.twiss.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/12/15 9:08 下午
 */
public class ValidParentheses {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public boolean isValid(String s){
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean res = new ValidParentheses().isValid(s);
        System.out.println(res);
    }
}
