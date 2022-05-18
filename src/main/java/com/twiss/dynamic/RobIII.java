package com.twiss.dynamic;

/**
 * 打家劫舍III
 * @Author: Twiss
 * @Date: 2022/5/18 3:51 下午
 */
public class RobIII {

    public int getMaxMoney(TreeNode root){
        int[] res = robAction(root);
        return Math.max(res[0],res[1]);
    }

    private int[] robAction(TreeNode root){
        int[] res =  new int[2];
        if (root==null){
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 不使用当前节点
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        // 使用当前节点，其子节点不选即可
        res[1] = root.val+left[0]+right[0];
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int maxValue = new RobIII().getMaxMoney(root);
        System.out.println(maxValue);
    }
}

class TreeNode{
    public TreeNode left, right;
    public int val;
    public TreeNode(int val){
        this.val = val;
    }
}
