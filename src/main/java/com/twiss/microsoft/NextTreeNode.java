package com.twiss.microsoft;

/**
 * 二叉树的下一个结点。原始节点的next是按照中序遍历
 * @Author: Twiss
 * @Date: 2022/2/14 1:43 下午
 */
public class NextTreeNode {

    public TreeNode getNext(TreeNode node){
        if (node==null){
            return null;
        }

        // 节点有右子树，则在右子树中寻找最左子节点
        if (node.right!=null){
            node = node.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }
        // 没右子树，则找第一个当前节点是父节点左孩子的节点
        while (node.next!=null){
            if (node.next.left==node){
                return node.next;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);

        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(8);
        node.left.right.right = new TreeNode(9);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);

        // 7->4
        node.left.left.next = node.left.left;
        // 4->2
        node.left.left.next = node.left;
        // 2->8
        node.left.next = node.left.right.left;
        // 8->5
        node.left.right.left.next = node.left.right;
        // 5->9
        node.left.right.next = node.left.right.right;
        // 9->1
        node.left.right.right.next = node;
        // 1->3
        node.next = node.right;
        // 3->6
        node.right.next = node.right.right;

        // 4的后继节点
        TreeNode nextNode = new NextTreeNode().getNext(node.left);
        System.out.println(nextNode.val);
    }
}
