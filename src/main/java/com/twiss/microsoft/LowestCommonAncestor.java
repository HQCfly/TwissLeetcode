package com.twiss.microsoft;

import com.alibaba.fastjson.JSON;

/**
 * @Author: Twiss
 * @Date: 2021/12/28 10:32 下午
 */
public class LowestCommonAncestor {

    public TreeNode getLowerCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null){
            return null;
        }
        // 如果p，q为跟节点，则公共祖先为根节点
        if (root.val==p.val||root.val==q.val){
            return root;
        }
        // 如果p,q在左子树，则公共祖先在左子树查找
        if (find(root.left,p)&&find(root.left,q)){
            return getLowerCommonAncestor(root.left,p,q);
        }
        // 如果p,q在右子树，则公共祖先在右子树查找
        if (find(root.right,p)&&find(root.right,q)){
            return getLowerCommonAncestor(root.right,p,q);
        }
        // 如果p,q分属两侧，则公共祖先为根节点
        return root;
    }

    private boolean find(TreeNode root, TreeNode c){
        if (root==null){
            return false;
        }
        if (root.val==c.val){
            return true;
        }
        return find(root.left,c)||find(root.right,c);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,new TreeNode(6),new TreeNode(2)),
                new TreeNode(1,new TreeNode(0),new TreeNode(8)));
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(5);
        TreeNode res = new LowestCommonAncestor().getLowerCommonAncestor(root,p,q);
        System.out.println(res.val);
    }
}
