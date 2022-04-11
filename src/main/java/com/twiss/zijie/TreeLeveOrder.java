package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 树的层序遍历
 * @Author: Twiss
 * @Date: 2022/4/11 7:35 下午
 */
public class TreeLeveOrder {

    public List<List<Integer>> getLevelOrder(ZJTree tree){
        List<List<Integer>> ans = new ArrayList<>();
        Deque<ZJTree> deque = new ArrayDeque<>();
        deque.offer(tree);
        while (!deque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = deque.size();
            for (int i=0;i<currentLevelSize;++i){
                ZJTree node = deque.poll();
                level.add(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        ZJTree tree = new ZJTree(3);
        tree.left = new ZJTree(9);
        tree.right = new ZJTree(20);
        tree.right.left = new ZJTree(15);
        tree.right.right = new ZJTree(7);
        List<List<Integer>> ans = new TreeLeveOrder().getLevelOrder(tree);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
