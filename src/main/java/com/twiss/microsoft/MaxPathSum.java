package com.twiss.microsoft;

/**
 * @Author: Twiss
 * @Date: 2022/1/2 4:59 下午
 */
public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int getMaxSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归计算左右节点贡献值
        // 只有最大贡献值大于0，才会选择改点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        // 节点的最大路径取决于该节点的值与该节点的左右节点的贡献值
        int previousPath = root.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(previousPath, maxSum);
        // 返回节点的最大贡献值
        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int res = new MaxPathSum().getMaxSum(node);
        System.out.println(res);
    }
}
