package com.twiss.microsoftII;

/**
 * 二叉树的最近公共祖先
 * @Author: Twiss
 * @Date: 2022/2/19 2:01 下午
 */
public class LowestCommonAncestor {

    public TreeNode getAncestor(TreeNode root,TreeNode p, TreeNode q){
        if (root==null){
            return null;
        }
        // 如果p、q为跟节点，则公共祖先是root
        if (p.val==root.val||q.val==root.val){
            return root;
        }
        // 如果p、q的最近祖先是在左子树
        if (find(root.left,p)&&find(root.left,q)){
            return getAncestor(root.left,p,q);
        }
        // 如果p、q的最近祖先是在右子树
        if (find(root.right,p)&&find(root.right,q)){
            return getAncestor(root.right,p,q);
        }
        return root;
    }

    private boolean find(TreeNode root, TreeNode t){
        if (root==null){
            return false;
        }
        if (root.val==t.val){
            return true;
        }
        return find(root.left,t)||find(root.right,t);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(0);
        TreeNode ans = new LowestCommonAncestor().getAncestor(root,root.left.left,root.left);
        System.out.println(ans.val);
    }
}
