package com.twiss.microsoftII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树序列化和反序列化
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/2/27 1:47 下午
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String str = "";
        return reSerialize(root, str);
    }

    private String reSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = reSerialize(root.left, str);
            str = reSerialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return reDeserialize(dataList);
    }

    private TreeNode reDeserialize(List<String> dataList) {
        if ("None".equals(dataList.get(0))){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = reDeserialize(dataList);
        root.right = reDeserialize(dataList);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = null;

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = null;
        root.right.left.left = null;

        root.right.right = new TreeNode(5);
        root.right.right.right = null;
        root.right.right.left = null;

        String ans = new Codec().serialize(root);
        System.out.println(ans);
    }
}
