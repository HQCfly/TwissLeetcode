package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 完全二叉树非叶子部分后续遍历
 * @Author: Twiss
 * @Date: 2022/7/13 10:16 下午
 */
public class PostTravelArray {

    public List<Integer> getResult(List<Integer> tree){
        List<Integer> ans = new ArrayList<>();
        if (tree==null){
            return ans;
        }
        int n = tree.size();
        int level = (int) (Math.log(n) / Math.log(2))-1;
        int index = 1;
        while (level>=0){
            index+=Math.pow(2,level-1);
            level--;
        }
        int leafIndex = index+1;
        List<Integer> removeElement = new ArrayList<>();
        for (int i=leafIndex;i<n;i++){
            removeElement.add(tree.get(i));
        }
        tree.removeAll(removeElement);
        postTraversal(tree,0,ans);
        return ans;
    }

    private void postTraversal(List<Integer> tree, int index, List<Integer> ans){
        if (index>=tree.size()){
            return;
        }
        postTraversal(tree,2*index+1,ans);
        postTraversal(tree,2*index+2,ans);
        ans.add(tree.get(index));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrs = sc.nextLine().split(" ");
        List<Integer> tree = new ArrayList<>();
        for (String arr:arrs){
            tree.add(Integer.parseInt(arr));
        }
        List<Integer> ans = new PostTravelArray().getResult(tree);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
