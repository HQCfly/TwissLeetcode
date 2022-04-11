package com.twiss.zijie;

/**
 * @Author: Twiss
 * @Date: 2022/4/11 7:41 下午
 */
public class ZJTree {
    int val;
    ZJTree left, right;
    ZJTree(){};
    ZJTree(int val){
        this.val = val;
    }
    ZJTree(int val,ZJTree left, ZJTree right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
