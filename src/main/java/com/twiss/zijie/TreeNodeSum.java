package com.twiss.zijie;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根节点到叶子节点数字之和
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/4/15 9:48 下午
 */
public class TreeNodeSum {

    public int getSum(ZJTree root){
        if (root==null){
            return 0;
        }

        return dfs(root,0);
    }

    private int dfs(ZJTree root,int preSum){
        if (root==null){
            return 0;
        }
        int sum = preSum*10+root.val;
        if (root.left==null&&root.right==null){
            return sum;
        }else {
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }

    public static void main(String[] args) {
        ZJTree root = new ZJTree(1);
        root.left = new ZJTree(2);
        root.right = new ZJTree(3);
        int ans = new TreeNodeSum().getSum(root);
        System.out.println(ans);
    }
}
