package com.twiss.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2022/2/11 9:43 下午
 */
public class BuildTree {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode build(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; ++i) {
            indexMap.put(inorder[i],i);
        }
        return buildTreeProcess(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode buildTreeProcess(int[] preorder, int[] inorder,
                                      int preLeft, int preRight,
                                      int inorderLeft, int inorderRight){
        if (preLeft>=preRight){
            return null;
        }
        // 从先序遍历获取根节点
        int preorderRoot = preLeft;
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderRoot]);

        // 获取中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        // 计算子数size
        int subLeftTree = inorderRoot - inorderLeft;
        // 构建左子树
        root.left = buildTreeProcess(preorder, inorder, preLeft + 1, preLeft + subLeftTree, inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeProcess(preorder, inorder, preLeft + subLeftTree + 1, preRight, inorderRoot + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = new BuildTree().build(preorder,inorder);
        System.out.println(node.val);
    }
}
