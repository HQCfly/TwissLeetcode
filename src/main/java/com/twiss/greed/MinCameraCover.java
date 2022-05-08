package com.twiss.greed;

/**
 * 二叉树监控
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/8 2:51 下午
 */
public class MinCameraCover {

    int res = 0;
    public int getMinMonitor(GreedTreeNode root){
        if (cameraCover(root)==0){
            res++;
        }
        return res;
    }

    /**
     * 节点的状态值：
     *     0 表示无覆盖
     *     1 表示 有摄像头
     *     2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     * @param root
     * @return
     */
    private int cameraCover(GreedTreeNode root){
        // 节点为空表示已覆盖
        if (root==null){
            return 2;
        }
        int left = cameraCover(root.left);
        int right = cameraCover(root.right);

        if (left==2&&right==2){
            // 表示当前节点没有摄像头，无覆覆盖状态
            return 0;
        }else if (left==0||right==0){
            // 左右节点只有一个未覆盖，表示当前需要摄像头
            res++;
            return 1;
        }else {
            // 其他情况表示已覆盖
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            return 2;
        }

    }

    public static void main(String[] args) {
        GreedTreeNode root = new GreedTreeNode(0);
        root.left = new GreedTreeNode(1);
        root.left.left = new GreedTreeNode(2);
        root.left.left.left = new GreedTreeNode(3);
        root.right = new GreedTreeNode(4);
        root.right.right = new GreedTreeNode(5);
        root.right.right.right = new GreedTreeNode(6);
        int ans = new MinCameraCover().getMinMonitor(root);
        System.out.println(ans);
    }
}
