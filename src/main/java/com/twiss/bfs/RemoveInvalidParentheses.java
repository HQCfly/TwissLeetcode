package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/8/27 9:58 下午
 */
public class RemoveInvalidParentheses {
    public List<String> getRemoveInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        // 广度优先遍历须要的队列和防止重复遍历的哈希表 visited
        Set<String> visited = new HashSet<>();
        visited.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        // 找到目标值以后推出循环
        boolean found = false;
        while (!queue.isEmpty()) {
            // 最优解一定在同一层
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String front = queue.poll();
                if (isValid(front)) {
                    res.add(front);
                    found = true;
                }

                int currentWordLen = front.length();
                char[] charArray = front.toCharArray();
                for (int j = 0; j < currentWordLen; j++) {
                    if (front.charAt(j) != '(' && front.charAt(j) != ')') {
                        continue;
                    }

                    // 注意 new String() 方法的 API，第 1 个参数是字符数组，第 2 个参数是字符数组的起始下标，第 3 个参数是截取的字符的长度
                    String next = new String(charArray, 0, j) + new String(charArray, j + 1, currentWordLen - j - 1);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            // 这一层找到以后，退出外层循环，返回结果
            if (found) {
                break;
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> res = new RemoveInvalidParentheses().getRemoveInvalidParentheses(s);
        System.out.println(JSONObject.toJSONString(res));
    }
}
