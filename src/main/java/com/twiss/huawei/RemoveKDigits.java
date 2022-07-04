package com.twiss.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 移除k位数字后的最小值
 * @Author: Twiss
 * @Date: 2022/7/4 12:07 下午
 */
public class RemoveKDigits {

    public static String getMaxValue(String str, int k){
        Deque<Character> stack = new LinkedList<>();
        int n = str.length();
        for (int i=0;i<n;i++){
            Character c = str.charAt(i);
            while (!stack.isEmpty()&&k>0&&c<stack.peekLast()){
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        for (int i=0;i<k;i++){
            stack.pollLast();
        }

        boolean isLeaderZero = true;
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            // 从栈底开始推出
            Character c = stack.pollFirst();
            if (isLeaderZero&&c=='0'){
                continue;
            }
            isLeaderZero = false;
            ans.append(c);
        }
        return ans.length()==0?"0":new String(ans);
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int k = sc.nextInt();
            String ans = getMaxValue(str,k);
            System.out.println(ans);
        }
    }
}
