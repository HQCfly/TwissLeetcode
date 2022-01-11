package com.twiss.microsoft;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/1/11 4:48 下午
 */
public class TreeCodec {

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
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

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }

    public String serializeByBfs(TreeNode root) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                res.append("" + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                res.append("null");
            }
            res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    public TreeNode deserializeByBfs(String data) {
        String[] dataArrays = data.substring(1,data.length()-1).split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArrays));
        TreeNode root = getNode(dataList.get(0));
        Deque<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i=1;i<dataList.size();++i){
            TreeNode curr = getNode(dataList.get(i));
            if (isLeft){
                parent.left = curr;
            }else {
                parent.right = curr;
            }

            if (curr!=null){
                parents.add(curr);
            }
            isLeft = !isLeft;
            if (isLeft){
                // 将父母节点替换成当前一层最初始节点
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val){
        if ("null".equals(val)){
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

    public static void main(String[] args) {
        String test = "[1,2,3,null,null,4,5]";
        TreeNode res = new TreeCodec().deserializeByBfs(test);
        System.out.println(res.right.val);
        String resSerialize = new TreeCodec().serializeByBfs(res);
        System.out.println(resSerialize);
        String resSerialize2 = new TreeCodec().serialize(res);
        System.out.println(resSerialize2);
    }
}
