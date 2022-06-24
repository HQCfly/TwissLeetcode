package com.twiss.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化与反序列化二叉树
 * @Author: Twiss
 * @Date: 2022/6/18 5:08 下午
 */
public class TreeNodeSerialize {

    public String serialize(TreeNode root){
        return rserialize(root,"");
    }

    public TreeNode deserialize(String data){
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str){
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }

    public static void main(String[] args) {

    }
}