package com.twiss.binarysearchtree;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/2 9:22 上午
 */
public class BinarySearchTreeImplementation {
    // BST structure
    class Node{
        int val;
        Node left, right;

        public Node(int data){
            this.val = data;
            left = right = null;
        }
        public Node(int data, Node left, Node right){
            this.val = data;
            this.left = left;
            this.right = right;
        }
    }

    // BST root node
    public Node root;

    public Node getRoot() {
        return root;
    }

    // initial empty tree
    public BinarySearchTreeImplementation(){
        root = null;
    }

    // insert a node in BST
    public void insert(int key){
       this.root = insertElement(root,key);
    }
    // create BST
    private Node insertElement(Node root, int key){
        // tree is empty
        if (root==null){
            root = new Node(key);
            return root;
        }
        // insert in left subtree
        if (key< root.val){
            root.left = insertElement(root.left,key);
        }else if (key> root.val){
            root.right = insertElement(root.right,key);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTreeImplementation bst = new BinarySearchTreeImplementation();
        bst.insert(2);
        bst.insert(6);
        bst.insert(4);
        bst.insert(9);
        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
    }
}
