package com.twiss.huawei;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 删除目录
 * @Author: Twiss
 * @Date: 2022/7/4 5:52 下午
 */
public class RemoveDirectory {
    // Tree能够保证key的顺序性
    Map<Integer, List<Integer>> tree = new TreeMap<>();
    Integer root = -1;

    public void buildTree(List<Integer> parents, List<Integer> children){
        for (int i=0;i<children.size();i++){
            Integer parent = parents.get(i);
            Integer child = children.get(i);
            if (!tree.containsKey(child)){
                tree.put(child,new ArrayList<>());
            }
            if (parent.equals(0)){
                root = child;
                continue;
            }
            List<Integer> parentList = null;
            if (tree.containsKey(parent)){
                tree.get(parent).add(child);
            }else {
                parentList = new ArrayList<>();
                parentList.add(child);
                tree.put(parent,parentList);
            }
        }
        System.out.println(JSONObject.toJSONString(tree));
    }

    public void remove(Integer node){
        List<Integer> children = tree.get(node);
        if (children==null){
            return;
        }
        if (children.size()==0){
            tree.remove(node);
            return;
        }
        for (int i=0;i<children.size();i++){
            remove(children.get(i));
        }
        tree.remove(node);
    }

    public void print(){
        tree.keySet().forEach(e->{
            System.out.print(e);
            System.out.print(" ");
        });
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> parents = new ArrayList<>();
        List<Integer> children = new ArrayList<>();
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            children.add(sc.nextInt());
            parents.add(sc.nextInt());
        }
        int rmId = sc.nextInt();
        RemoveDirectory removeDirectory = new RemoveDirectory();
        removeDirectory.buildTree(parents,children);
        removeDirectory.remove(rmId);
        removeDirectory.print();
    }
}
