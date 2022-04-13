package com.twiss.zijie;

/**
 * 对称树
 * 时间复杂度O(n)
 * 空复杂度O(n)
 * 双指针方法
 * @Author: Twiss
 * @Date: 2022/4/13 9:15 下午
 */
public class Symmetric {

    public boolean isSymmetric(ZJTree root) {
        if (root == null) {
            return false;
        }
        return check(root, root);
    }

    private boolean check(ZJTree p, ZJTree q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val &&
                check(p.left, q.right) &&
                check(p.right, q.left);
    }

    public static void main(String[] args) {
        ZJTree root = new ZJTree(1);
        root.left = new ZJTree(2);
        root.left.left = new ZJTree(3);
        root.left.right = new ZJTree(4);
        root.right = new ZJTree(2);
        root.right.right = new ZJTree(3);
        root.right.left = new ZJTree(4);

        boolean ans = new Symmetric().isSymmetric(root);
        System.out.println(ans);
    }
}
