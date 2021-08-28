package com.twiss.dfs;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/8/28 10:20 下午
 */
public class RemoveInvalidParentheses {

    private int len;
    private char[] charArray;
    private Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s){
        this.len = s.length();
        this.charArray = s.toCharArray();
        this.validExpressions = new HashSet<>();

        // 第一步：遍历一次，计算多余的左右括号
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i=0;i<len;++i){
            if (charArray[i]=='('){
                leftRemove++;
            }else if (charArray[i]==')'){
                if (leftRemove==0){
                    // 遇到有括号的时候，需要根据已经存在的左括号数量觉得
                    rightRemove++;
                }
                if (leftRemove>0){
                    // 关键：一个有括号出现可以抵消之前遇到到的左括号
                    leftRemove--;
                }
            }
        }

        // 第2步：回溯算法，尝试每一种可能删除的操作
        StringBuilder path = new StringBuilder();
        dfs(0,0,0,leftRemove,rightRemove,path);
        return new ArrayList<>(this.validExpressions);
    }

    /**
     *
     * @param index 当前遍历下标
     * @param leftCount 已经遍历到的左括号个数
     * @param rightCount 已经遍历到的右括号个数
     * @param leftRemove 最少应该删除的左括号个数
     * @param rightRemove 最少应该删除的右括号个数
     * @param path 一个可能的结果
     */
    private void dfs(int index, int leftCount,
                     int rightCount, int leftRemove,
                     int rightRemove, StringBuilder path){
        if (index==len){
            if (leftRemove==0&&rightRemove==0){
                validExpressions.add(path.toString());
            }
            return;
        }

        char character = charArray[index];
        // 可能操作1：删除当前遍历到的字符
        if (character=='('&&leftRemove>0){
            // 由于leftRemove>0，并且当前遇到的事左括号，因此可以尝试删除
            // 当前遇到的左括号
            dfs(index+1,leftCount,rightCount,leftRemove-1,rightRemove,path);
        }
        if (character==')'&&rightRemove>0){
            // 由于rightRemove>0，并且当前遇到的事有括号，因此可以尝试删除遇到的右括号
            dfs(index+1,leftCount,rightCount,leftRemove,rightRemove-1,path);
        }

        // 可能操作2：保留当前遍历到的字符
        path.append(character);
        if (character!='('&&character!=')'){
            // 如果不是括号，继续深度优先遍历
            dfs(index+1,leftCount,rightCount,leftRemove,rightRemove,path);
        }else if (character=='('){
            // 考虑左括号
            dfs(index+1,leftCount+1,rightCount,leftRemove,rightRemove,path);
        }else if (rightCount<leftCount){
            // 考虑右括号
            dfs(index+1,leftCount,rightCount+1,leftRemove,rightRemove,path);
        }
        path.deleteCharAt(path.length()-1);
    }

    public static void main(String[] args) {
        String s = "()())()";
        List<String> res = new RemoveInvalidParentheses().removeInvalidParentheses(s);
        System.out.println(JSONObject.toJSONString(res));
    }
}
