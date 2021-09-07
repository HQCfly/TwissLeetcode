package com.twiss.xiaohuang.cp3stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/9/7 4:16 下午
 */
public class BucketMatching {

    public boolean isValidBucket(String s){
        int n = s.length();
        if (n%2==1){
            return false;
        }
        // 保存匹配括号
        Map<Character,Character> bucket = new HashMap<Character,Character>(){{
                put(')','(');
                put(']','[');
                put('}','{');
        }};
        // 保存左符号
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<n;++i){
            Character ch = s.charAt(i);
            if (bucket.containsKey(ch)){
                if (stack.isEmpty()||stack.peek()!=bucket.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        boolean res = new BucketMatching().isValidBucket(s);
        System.out.println("res: "+res);

        String s2 = "{[]})";
        boolean res2 = new BucketMatching().isValidBucket(s2);
        System.out.println("res2: "+res2);
    }
}
