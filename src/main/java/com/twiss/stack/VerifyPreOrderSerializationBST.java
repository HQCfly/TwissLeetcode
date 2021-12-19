package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/12/19 11:09 下午
 */
public class VerifyPreOrderSerializationBST {

    public boolean isValidSerialization(String preorder){
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i<n){
            if (stack.isEmpty()){
                return false;
            }
            if (preorder.charAt(i)==','){
                i++;
            }else if (preorder.charAt(i)=='#'){
                int top = stack.pop()-1;
                if (top>0){
                    stack.push(top);
                }
                i++;
            }else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String preorder ="9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean res = new VerifyPreOrderSerializationBST().isValidSerialization(preorder);
        System.out.println(res);
    }
}
