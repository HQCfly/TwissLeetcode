package com.twiss.xiaohuang.util.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 构建二叉搜索树
 * @Author: Twiss
 * @Date: 2021/10/7 7:18 下午
 */
public class OperationBinarySearchTree extends AbstractBinaryTree{
    private static final Logger logger = LoggerFactory.getLogger(OperationBinarySearchTree.class);

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
     * @param val
     * @return
     */
    @Override
    public TreeNode find(int val) {
        TreeNode currentNode = this.rootNode;
        while (currentNode != null && (currentNode.val != val)) {
            // 遵循左节点小于其父节点
            if (currentNode.val > val) {
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
     * @param val
     * @return
     */
    @Override
    public Boolean update(int val) {
        return null;
    }

    /**
     * 插入节点
     *
     * @param val
     * @param val
     */
    @Override
    public void insert(int val) {
        if (this.rootNode == null) {
            this.rootNode = new TreeNode(val);
            return;
        }
        TreeNode currentNode = this.rootNode;
        TreeNode parentNode = this.rootNode;
        boolean isLeftChild = false;
        while (currentNode != null && (currentNode.val != val)) {
            parentNode = currentNode;
            // 遵循左节点小于其父节点
            if (currentNode.val > val) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        // 插入节点
        if (parentNode != currentNode) {
            TreeNode newNode = new TreeNode(val);
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
     * @param val
     * @return
     */
    @Override
    public Boolean delete(int val) {
        TreeNode currentNode = this.rootNode;
        TreeNode parentNode = this.rootNode;
        Boolean isLeftChild = true;
        while (currentNode != null && (currentNode.val != val)) {
            parentNode = currentNode;
            // 遵循左节点小于其父节点
            if (currentNode.val > val) {
                currentNode = currentNode.leftChild;
                isLeftChild = true;
            } else {
                currentNode = currentNode.rightChild;
                isLeftChild = false;
            }
        }
        if (currentNode == null) {
            return false;
        }
        // 要删除的节点为叶子节点
        if ((currentNode.leftChild == null) && (currentNode.rightChild) == null) {
            if (currentNode == this.rootNode) {
                this.rootNode = null;
            } else if (isLeftChild) {
                currentNode.leftChild = null;
            } else {
                currentNode.rightChild = null;
            }
        } else if ((currentNode.rightChild == null) && (currentNode.leftChild != null)) {
            if (currentNode == this.rootNode) {
                this.rootNode = currentNode.leftChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.leftChild;
            } else {
                parentNode.rightChild = currentNode.leftChild;
            }
        } else if ((currentNode.rightChild != null) && (currentNode.leftChild == null)) {
            if (currentNode == this.rootNode) {
                this.rootNode = currentNode.rightChild;
            } else if (isLeftChild) {
                parentNode.leftChild = currentNode.rightChild;
            } else {
                parentNode.leftChild = currentNode.rightChild;
            }
        } else {
            TreeNode directNode = this.getDelNodeSuccessor(currentNode);
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
        while (current != null) {
            parentNode = directPostNode;
            directPostNode = current;
            current = current.leftChild;
        }
        if (directPostNode != delNode.rightChild) {
            parentNode.leftChild = directPostNode.rightChild;
            ;
            directPostNode.rightChild = null;
        }
        return directPostNode;
    }

    @Override
    public void show(TreeNode root) {
        Common common = new Common();
        common.show(root);
    }

    /**
     * 先序遍历
     *
     * @param rootNode
     */
    @Override
    public void preOrder(TreeNode rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.val+", ");
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
            System.out.print(rootNode.val+", ");
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
            System.out.print(rootNode.val+"， ");
        }
    }

    public void buildTree(OperationBinarySearchTree tree, int[] arrays) {
        for (int i : arrays) {
            tree.insert(i);
        }
    }

    public static void main(String[] args) {
        OperationBinarySearchTree tree6 = new OperationBinarySearchTree();
        int[] arrays = {5,7,2,1,8,3,6,9};
        tree6.buildTree(tree6,arrays);
        tree6.show(tree6.getRootNode());

        System.out.print("先序序遍历：");
        tree6.preOrder(tree6.getRootNode());
        System.out.println();

        System.out.print("中序遍历：");
        tree6.inOrder(tree6.getRootNode());
        System.out.println();

        System.out.print("后序遍历：");
        tree6.postOrder(tree6.getRootNode());
    }
}
