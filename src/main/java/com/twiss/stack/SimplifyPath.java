package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/9 8:23 下午
 */
public class SimplifyPath {

    public String getPath(String path){
        String[] dirs = path.split("/");
        if (dirs.length==0){
            return "/";
        }

        Deque<String> stack = new ArrayDeque<>();
        for (String dir:dirs){
            if (".".equals(dir)||"".equals(dir)){
                continue;
            }
            if ("..".equals(dir)){
                if (!stack.isEmpty()){
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(dir);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()){
            stringBuilder.insert(0,"/");
        }
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.removeLast());
            stringBuilder.insert(0,"/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/home/";
        String res = new SimplifyPath().getPath(path);
        System.out.println(res);
    }
}
