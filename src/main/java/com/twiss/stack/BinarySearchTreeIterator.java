package com.twiss.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/8/31 11:11 上午
 */
public class BinarySearchTreeIterator {

    private Deque<StackTree> deque = new ArrayDeque<>();

    public BinarySearchTreeIterator(StackTree root){
        dfsLeft(root);
    }

    public int next(){
        // 步骤一：取出栈顶元素
        StackTree root = deque.pollLast();
        // 步骤二：将root值保存下来
        int ans = root.val;
        // 步骤三：将root换成右节点
        root = root.right;
        // 步骤四：继续遍历
        dfsLeft(root);
        // 步骤五：返回当前值
        return ans;
    }

    public boolean hasNext(){
        return deque.isEmpty();
    }

    private void dfsLeft(StackTree root){
        while (root!=null){
            deque.addLast(root);
            root = root.left;
        }
    }

    /**
     *          7
     *         / \
     *        3   15
     *          /     \
     *         9      20
     * @param args
     */
    public static void main(String[] args) {
        StackTree root = new StackTree(7);
        StackTree rightNode = new StackTree(15,new StackTree(9),new StackTree(20));
        root.left = new StackTree(3);
        root.right = rightNode;

        BinarySearchTreeIterator res = new BinarySearchTreeIterator(root);

        System.out.println(JSONObject.toJSONString(res.next()));
    }
}
