package com.twiss.xiaohuang.util.tree;


/**
 * @Author: Twiss
 * @Date: 2021/9/15 7:08 下午
 */
public abstract class AbstractBinaryTree {
    /**
     * 查找指定节点
     * @param val
     * @return
     */
    public abstract TreeNode find(int val);

    /**
     * 更新节点值
     * @param val
     * @return
     */
    public abstract Boolean update(int val);

    /**
     * 插入节点
     * @param val
     */
    public abstract void insert(int val);

    /**
     * 删除节点
     * @param val
     * @return
     */
    public abstract Boolean delete(int val);

    /**
     * 打印树
     * @param root
     */
    public abstract void show(TreeNode root);
    /**
     * 得到删除节点的中继后节点
     * @param delNode
     * @return
     */
    public abstract TreeNode getDelNodeSuccessor(TreeNode delNode);

    /**
     * 先序遍历
     * @param rootNode
     */
    public abstract void preOrder(TreeNode rootNode);
    /**
     * 中序遍历
     * @param rootNode
     */
    public abstract void inOrder(TreeNode rootNode);
    /**
     * 后序遍历
     * @param rootNode
     */
    public abstract void postOrder(TreeNode rootNode);
}
