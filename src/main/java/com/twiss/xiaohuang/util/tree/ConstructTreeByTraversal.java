package com.twiss.xiaohuang.util.tree;

import java.util.Arrays;

/**
 * 1. 根据中序遍历和后序遍历确定二叉树
 * 2. 根据前序序遍历和后序遍历确定二叉树
 * 3. 根据前序遍历和中序遍历确定二叉树
 * @Author: Twiss
 * @Date: 2021/10/8 10:10 下午
 */
public class ConstructTreeByTraversal {

    /**
     * 1. 根据中序遍历和后序遍历确定二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode constructFromInorderPost(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null) {
            return null;
        }
        return helper(inorder,postorder);
    }

    private TreeNode helper(int[] in, int[] post) {
        if(in.length==0) {
            return null;
        }
        //根据后序数组的最后一个元素，创建根节点
        TreeNode root = new TreeNode(post[post.length-1]);
        //在中序数组中查找值等于【后序数组最后一个元素】的下标
        for(int i=0;i<in.length;++i) {
            if(in[i]==post[post.length-1]) {
                //确定这个下标i后，将中序数组分成两部分，后序数组分成两部分
                int[] inLeft = Arrays.copyOfRange(in,0,i);
                int[] inRight = Arrays.copyOfRange(in,i+1,in.length);
                int[] postLeft = Arrays.copyOfRange(post,0,i);
                int[] postRight = Arrays.copyOfRange(post,i,post.length-1);
                //递归处理中序数组左边，后序数组左边
                root.leftChild = helper(inLeft,postLeft);
                //递归处理中序数组右边，后序数组右边
                root.rightChild = helper(inRight,postRight);
                break;
            }
        }
        return root;
    }

    /**
     * 2. 根据前序序遍历和后序遍历确定二叉树
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre==null || pre.length==0) {
            return null;
        }
        return dfs(pre,post);
    }

    private TreeNode dfs(int[] pre,int[] post) {
        if(pre==null || pre.length==0) {
            return null;
        }
        //数组长度为1时，直接返回即可
        if(pre.length==1) {
            return new TreeNode(pre[0]);
        }
        //根据前序数组的第一个元素，创建根节点
        TreeNode root = new TreeNode(pre[0]);
        int n = pre.length;
        for(int i=0;i<post.length;++i) {
            if(pre[1]==post[i]) {
                //根据前序数组第二个元素，确定后序数组左子树范围
                int left_count = i+1;
                //拆分前序和后序数组，分成四份
                int[] pre_left = Arrays.copyOfRange(pre,1,left_count+1);
                int[] pre_right = Arrays.copyOfRange(pre,left_count+1,n);
                int[] post_left = Arrays.copyOfRange(post,0,left_count);
                int[] post_right = Arrays.copyOfRange(post,left_count,n-1);
                //递归执行前序数组左边、后序数组左边
                root.leftChild = dfs(pre_left,post_left);
                //递归执行前序数组右边、后序数组右边
                root.rightChild = dfs(pre_right,post_right);
                break;
            }
        }
        //返回根节点
        return root;
    }

    /**
     * 3. 根据前序遍历和中序遍历确定二叉树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode constructFromPreInorder(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if(preorder[0]==inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.leftChild = constructFromPreInorder(pre_left,in_left);
                root.rightChild = constructFromPreInorder(pre_right,in_right);
                break;
            }
        }
        return root;
    }

    public void show(TreeNode root){
        Common common = new Common();
        common.show(root);
    }

    public static void main(String[] args) {

        // 1. 根据中序遍历和后序遍历确定二叉树
        System.out.println("1. 根据中序遍历和后序遍历确定二叉树: ");
        int[] pre1 = {9,3,15,20,7}, post1 = {9,15,7,20,3};
        ConstructTreeByTraversal cbt1 = new ConstructTreeByTraversal();
        TreeNode root = cbt1.constructFromInorderPost(pre1,post1);
        cbt1.show(root);

        // 2. 根据前序序遍历和后序遍历确定二叉树
        System.out.println("2. 根据前序序遍历和后序遍历确定二叉树: ");
        int[] pre2 = {1,2,4,5,3,6,7}, post2 = {4,5,2,6,7,3,1};
        ConstructTreeByTraversal cbt2 = new ConstructTreeByTraversal();
        TreeNode root2 = cbt2.constructFromPrePost(pre2,post2);
        cbt2.show(root2);

        // 3. 根据前序遍历和中序遍历确定二叉树
        System.out.println("3. 根据前序遍历和中序遍历确定二叉树: ");
        int[] pre3 = {3,9,20,15,7}, post3 = {9,3,15,20,7};
        ConstructTreeByTraversal cbt3 = new ConstructTreeByTraversal();
        TreeNode root3 = cbt3.constructFromPreInorder(pre3,post3);
        cbt3.show(root3);
    }
}
