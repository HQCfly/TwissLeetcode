package com.twiss.stack;

/**
 * @Author: Twiss
 * @Date: 2021/12/18 7:29 下午
 */
public class VerifyPreorderSequenceBST {
    private int idx;

    public boolean verifyPreorder(int[] preorder){
        dfs(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return idx==preorder.length;
    }

    private void dfs(int[] preorder,int min,int max){
        if (idx==preorder.length){
            return;
        }
        int val = preorder[idx];
        if (min<preorder[idx]&&preorder[idx]<max){
            // 在此范围内，则new子节点，将idx向后移一位
            idx++;
            // 其左子树的范围应该是min到当前节点；右子树范围应该是当前节点到max
            dfs(preorder, min, val);
            dfs(preorder, val, max);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1,3,2};
        boolean res = new VerifyPreorderSequenceBST().verifyPreorder(preorder);
        System.out.println(res);

    }
}
