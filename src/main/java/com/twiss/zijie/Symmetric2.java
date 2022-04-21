package com.twiss.zijie;

/**
 * 对称二叉树
 * @Author: Twiss
 * @Date: 2022/4/21 5:26 下午
 */
public class Symmetric2 {

    public boolean isValid(ZJTree root){
        if (root==null){
            return false;
        }
        return dfs(root,root);
    }

    private boolean dfs(ZJTree p, ZJTree q){
        if (p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            return false;
        }
        return p.val==q.val
                &&dfs(p.right,q.left)
                &&dfs(p.left,q.right);
    }

    public static void main(String[] args) {
        ZJTree root = new ZJTree(1);
        root.left = new ZJTree(2);
        root.left.left = new ZJTree(3);
        root.left.right = new ZJTree(4);
        root.right = new ZJTree(2);
        root.right.right = new ZJTree(3);
        root.right.left = new ZJTree(4);
        boolean ans = new Symmetric2().isValid(root);
        System.out.println(ans);
    }
}
