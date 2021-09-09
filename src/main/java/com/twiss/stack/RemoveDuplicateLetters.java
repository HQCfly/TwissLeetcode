package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/6 10:09 下午
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String letters) {
        // 存放去重结果
        Deque<Character> stack = new ArrayDeque<>();
        // 记录出现字符次数
        int[] count = new int[256];

        for (int i = 0; i < letters.length(); ++i) {
            count[letters.charAt(i)]++;
        }
        // 记录栈中是否存在某个字符
        boolean[] inStack = new boolean[256];
        for (char c : letters.toCharArray()) {
            // 每遍历一个字符，都将对应对应计数减1
            count[c]--;

            // 如果栈中存在c字符，则跳过
            if (inStack[c]) {
                continue;
            }

            while ((!stack.isEmpty()) && (stack.peek() > c)) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String letters = "bcac";
        String res = new RemoveDuplicateLetters().removeDuplicateLetters(letters);
        System.out.println(res);
    }
}
