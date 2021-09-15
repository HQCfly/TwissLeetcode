package com.twiss.xiaohuang.cp4bst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二叉搜索树
 *
 * @Author: Twiss
 * @Date: 2021/9/15 3:27 下午
 */
public class BinarySearchTree extends AbstractBinaryTree {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTree.class);

    private TreeNode rootNode;

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 查找指定节点
     *
     * @param key
     * @return
     */
    @Override
    public TreeNode find(int key) {
        TreeNode currentNode = this.rootNode;
        while (currentNode != null && (currentNode.key != key)) {
            // 遵循左节点小于其父节点
            if (currentNode.key > key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        return currentNode;
    }

    /**
     * 更新节点值
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Boolean update(int key, int value) {
        return null;
    }

    /**
     * 插入节点
     *
     * @param key
     * @param val
     */
    @Override
    public void insert(int key, int val) {
        if (this.rootNode == null) {
            this.rootNode = new TreeNode(key, val);
            return;
        }
        TreeNode currentNode = this.rootNode;
        TreeNode parentNode = this.rootNode;
        boolean isLeftChild = false;
        while (currentNode != null && (currentNode.key != key)) {
            parentNode = currentNode;
            // 遵循左节点小于其父节点
            if (currentNode.key > key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        // 插入节点
        if (parentNode != currentNode) {
            TreeNode newNode = new TreeNode(key, val);
            if (isLeftChild) {
                parentNode.leftChild = newNode;
            } else {
                parentNode.rightChild = newNode;
            }
        } else {
            currentNode.setVal(val);
        }
    }

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    @Override
    public Boolean delete(int key) {
        TreeNode currentNode = this.rootNode;
        TreeNode parentNode = this.rootNode;
        Boolean isLeftChild = true;
        while (currentNode != null && (currentNode.key != key)) {
            parentNode = currentNode;
            // 遵循左节点小于其父节点
            if (currentNode.key > key) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        if (currentNode==null){
            return false;
        }
        // 要删除的节点为叶子节点
        if ((currentNode.leftChild==null)&&(currentNode.rightChild)==null){
            if (currentNode==this.rootNode){
                this.rootNode = null;
            }else if (isLeftChild){
                currentNode.leftChild = null;
            }else {
                currentNode.rightChild = null;
            }
        }else if ((currentNode.rightChild==null)&&(currentNode.leftChild!=null)){
            if (currentNode==this.rootNode){
                this.rootNode = currentNode.leftChild;
            }else if (isLeftChild){
                parentNode.leftChild = currentNode.leftChild;
            }else {
                parentNode.rightChild = currentNode.leftChild;
            }
        }else if ((currentNode.rightChild!=null)&&(currentNode.leftChild==null)){
            if (currentNode==this.rootNode){
                this.rootNode = currentNode.rightChild;
            }else if (isLeftChild){
                parentNode.leftChild = currentNode.rightChild;
            }else {
                parentNode.leftChild = currentNode.rightChild;
            }
        }else {
            TreeNode directNode = this.getDelNodeSuccessor(currentNode);
            currentNode.key = directNode.key;
            currentNode.val = directNode.val;
        }
        return true;
    }

    /**
     * 得到删除节点的中继后节点
     *
     * @param delNode
     * @return
     */
    @Override
    public TreeNode getDelNodeSuccessor(TreeNode delNode) {
        TreeNode parentNode = delNode;
        TreeNode directPostNode = delNode;
        TreeNode current = delNode.rightChild;
        while (current!=null){
            parentNode = directPostNode;
            directPostNode = current;
            current = current.leftChild;
        }
        if (directPostNode!=delNode.rightChild){
            parentNode.leftChild = directPostNode.rightChild;;
            directPostNode.rightChild = null;
        }
        return directPostNode;
    }

    /**
     * 先序遍历
     *
     * @param rootNode
     */
    @Override
    public void preOrder(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.println(rootNode.key + " " + rootNode.val);
            this.preOrder(rootNode.leftChild);
            this.preOrder(rootNode.rightChild);
        }
    }

    /**
     * 中序遍历
     *
     * @param rootNode
     */
    @Override
    public void inOrder(TreeNode rootNode) {
        if (rootNode != null) {
            this.inOrder(rootNode.leftChild);
            System.out.println(rootNode.key + " " + rootNode.val);
            this.inOrder(rootNode.rightChild);
        }
    }

    /**
     * 后序遍历
     *
     * @param rootNode
     */
    @Override
    public void postOrder(TreeNode rootNode) {
        if (rootNode != null) {
            this.postOrder(rootNode.leftChild);
            this.postOrder(rootNode.rightChild);
            System.out.println(rootNode.key + " " + rootNode.val);
        }
    }

    private void commentFindNodeIndex(TreeNode currentNode, TreeNode parentNode, int key, Boolean isLeftChild) {

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6,6);
        tree.insert(3,3);
        tree.insert(14,14);
        tree.insert(16,16);
        tree.insert(10,10);
        tree.insert(9,9);
        tree.insert(13,13);
        tree.insert(11,11);
        tree.insert(12,12);
        System.out.println("删除前是递增有序");
        tree.inOrder(tree.getRootNode());// 中序遍历操作
        tree.update(12, 200);
        System.out.println("更新节点值中序遍历结果  key=12的值");
        tree.inOrder(tree.getRootNode());
        System.out.println("删除节点10之后遍历结果");

        tree.delete(10);// 删除操作
        tree.inOrder(tree.getRootNode());
    }
}
