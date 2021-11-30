package com.twiss.binarysearchtree;

import com.twiss.xiaohuang.util.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Twiss
 * @Date: 2021/10/2 4:02 下午
 */
public class BTIntoBST {

    //Node of binary tree
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // tree root
    static Node root;
    // temp tree array: stored inorder traversal of tree
    int[] treeArray;
    // index
    int index = 0;

    // convert binary tree to binary search tree
    public void convertBTBST(Node node) {
        // get tree size
        int treeSize = elementsOfTree(node);
        treeArray = new int[treeSize];
        convertBtToArray(node);
        Arrays.sort(treeArray);
        index = 0;
        arrayToBST(treeArray, root);
    }

    public void arrayToBST(int[] arr, Node root) {
        if (root == null) {
            return;
        }
        // update the left subtree
        arrayToBST(arr, root.left);
        // update root's val and increment index
        root.val = arr[index];
        index++;
        // finally update the right subtree
        arrayToBST(arr, root.right);
    }

    /**
     * inorder traversal of the tree and store the data into array.
     *
     * @param node
     */
    private void convertBtToArray(Node node) {
        // Check whether tree is empty or not.
        if (root == null) {
            return;
        } else {
            // add all elements to tree array
            if (node.left != null) {
                convertBtToArray(node.left);
            }
            treeArray[index] = node.val;
            index++;
            if (node.right != null) {
                convertBtToArray(node.right);
            }

        }
    }

    /**
     * get all elements of tree
     *
     * @param node
     * @return
     */
    private int elementsOfTree(Node node) {
        int height = 0;
        if (node == null) {
            return 0;
        } else {
            height = elementsOfTree(node.left) + elementsOfTree(node.right) + 1;
        }
        return height;
    }

    public static void addByLeve(Integer[] arrays) {
        int i = 1;
        root = new Node(arrays[0]);  // 根节点
        Node current = null;
        Integer value = null;

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (i < arrays.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = arrays[i++];
            if (value != null) {
                Node left = new Node(value);
                current.setLeft(left);//创建当前节点的左孩子
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            value = arrays[i++];
            if (value != null) {
                Node right = new Node(value);
                current.setRight(right);//创建当前节点的右孩子
                queue.offer(right);// 在链表尾部 右孩子入队
            }

        }
        levelIetrator(root);
    }

    private static int levelIetrator(Node root) {
        if (root == null) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Node current = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
//                System.out.println("节点" + current.val + "的左孩子是" + current.getLeft().val);
            }  //                System.out.println("节点" + current.val + "没有左孩子");

            if (current.getRight() != null) {
                queue.offer(current.getRight());
//                System.out.println("节点" + current.val + "的右孩子是" + current.getRight().val);
            }  //                System.out.println("节点" + current.val + "没有右孩子");

        }
        return 1;

    }

    /**
     * original tree
     *		  1
     * 		/   \
     *    2       3
     *   / \     / \
     *  4   5   6   7
     *
     * BST tree
     * 		  4
     * 		/   \
     * 	  2       6
     * 	 / \     / \
     *  1   3   5   7
     *
     * @param arg
     */
    public static void main(String[] arg) {
        // build tree
//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
        Integer[] array2 = {1, 2, 3, 4, 5, 6, 7};

        BTIntoBST bst = new BTIntoBST();
        bst.addByLeve(array2);
        System.out.println("OriginalTree:");
        bst.show(root);
        bst.convertBTBST(root);
        System.out.println("BST:");
        bst.show(root);
    }

    private int getTreeDepth(Node root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    public void show(Node root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public void writeArray(Node currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }
}
