package com.twiss.microsoft;


/**
 * @Author: Twiss
 * @Date: 2022/1/13 6:15 下午
 */
public class DeleteNodeBst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 左右节点都不为null
            if (root.left!=null&&root.right!=null){
                TreeNode temp = root.right;
                if (temp.left!=null){
                    // 寻找最左侧节点
                    while (temp.left.left!=null){
                        temp = temp.left;
                    }
                    root.val = temp.left.val;
                    // 将最左侧节替换成其右节点树
                    temp.left = temp.left.right;
                }else {
                    root.val = temp.val;
                    root.right = temp.right;
                }
                return root;
            }
            // 删除节点，右孩子补位 ，返回右孩子为根节点
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
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        TreeNode res = new DeleteNodeBst().deleteNode(root,5);
        res.show(res);
    }
}
