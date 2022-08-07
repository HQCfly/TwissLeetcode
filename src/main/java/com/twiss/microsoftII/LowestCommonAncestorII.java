package com.twiss.microsoftII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最近公共祖先
 * @Author: Twiss
 * @Date: 2022/8/7 4:37 下午
 */
public class LowestCommonAncestorII {

    private TreeNode ans;

    public TreeNode getCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
        ans = new TreeNode();
        dfs(root,p,q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p,TreeNode q){
        if (root==null){
            return false;
        }
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if ((lson&&rson)||((root.val == p.val || root.val == q.val) && (lson || rson))){
            ans = root;
        }
        return lson||rson||(root.val==p.val||root.val==q.val);
    }

    private Map<Integer,TreeNode> parent;
    private Set<Integer> visited;

    public TreeNode getCommonAncestorByIterator(TreeNode root, TreeNode p,TreeNode q){
        parent = new HashMap<>();
        visited = new HashSet<>();
        dfsByIterator(root);
        while (p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q!=null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfsByIterator(TreeNode root){
        if (root.left!=null){
            parent.put(root.left.val,root);
            dfsByIterator(root.left);
        }
        if (root.right!=null){
            parent.put(root.right.val,root);
            dfsByIterator(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        TreeNode res = new LowestCommonAncestorII().getCommonAncestor(root,root.left,root.right);
    }
}
