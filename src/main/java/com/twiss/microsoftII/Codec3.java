package com.twiss.microsoftII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树编码解码
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/3/10 11:04 下午
 */
public class Codec3 {

    public String serialize(TreeNode root) {
        String ans = rserialize(root, "");
        return ans.substring(0,ans.length()-1);
    }

    private String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val)+",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] dataString = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataString));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if ("None".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }
        TreeNode newRoot = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        newRoot.left = rdeserialize(dataList);
        newRoot.right = rdeserialize(dataList);
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String ser = new Codec3().serialize(root);
        System.out.println(ser);
    }
}
