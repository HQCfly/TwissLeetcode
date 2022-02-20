package com.twiss.microsoftII;

/**
 * 删除二叉搜索树中的的节点
 * 时间复杂度O(logN)
 * 空间复杂度O(H) H是树的高度
 * @Author: Twiss
 * @Date: 2022/2/20 2:32 下午
 */
public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root,int key){
        if (root==null){
            return null;
        }
        if (root.val>key){
            root.left = deleteNode(root.left,key);
        }else if (root.val<key){
            root.right = deleteNode(root.right,key);
        }else {
            // 当左右节点都不为空的时候
            if (root.right!=null&&root.left!=null){
                // 进行操作右子树中寻找后继节点
                TreeNode tmp = root.right;
                // 左子树不为空
                if (tmp.left!=null){
                    while (tmp.left.left!=null){
                        tmp = tmp.left;
                    }
                    // 将当前的节点值替换成后继节点值
                    root.val = tmp.left.val;
                    // 将后继节点的右子树替换
                    tmp.left = tmp.left.right;
                }else {
                    // 左子树为空，用右子树替换即可
                    root.val = tmp.val;
                    root.right = tmp.right;
                }
                return root;
            }
            // 只右子树
            if (root.right!=null){
                return root.right;
            }else {
                return root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);

        TreeNode ans = new DeleteNodeBST().deleteNode(root,3);
        System.out.println(root.left.val);
    }
}
