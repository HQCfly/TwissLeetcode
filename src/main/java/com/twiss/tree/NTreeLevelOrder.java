package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉树遍历
 * @Author: Twiss
 * @Date: 2022/6/18 11:54 上午
 */
public class NTreeLevelOrder {

    public List<List<Integer>> getLevelOrder(NTreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        // 构建队列
        Deque<NTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++){
                NTreeNode node = queue.poll();
                tmp.add(node.val);
                List<NTreeNode> children = node.children;
                if (children==null||children.size()==0){
                    continue;
                }
                for (NTreeNode child:children){
                    queue.offer(child);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        NTreeNode root = new NTreeNode(1);
        List<NTreeNode> chi = new ArrayList<>();
        NTreeNode child1 = new NTreeNode(2);
        NTreeNode child2 = new NTreeNode(3);
        NTreeNode child3 = new NTreeNode(4);
        chi.add(child1);
        chi.add(child2);
        chi.add(child3);
        root.children = chi;
        List<List<Integer>> ans = new NTreeLevelOrder().getLevelOrder(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}

class NTreeNode{
    public int val;
    public List<NTreeNode> children;

    public NTreeNode(int val){
        this.val = val;
    }


    public NTreeNode(int val,List<NTreeNode> children){
        this.val = val;
        this.children = children;
    }
}