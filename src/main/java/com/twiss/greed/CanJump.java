package com.twiss.greed;

/**
 * 跳跃到最后一个位置
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/1 11:22 下午
 */
public class CanJump {

    public boolean canJumpTail(int[] arrays){
        int n = arrays.length-1;
        int maxStep = 0;
        for (int i=0;i<n;++i){
            if (maxStep==n){
                return true;
            }
            maxStep = Math.max(maxStep,i+arrays[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays = {2,3,1,1,4};
        boolean ans = new CanJump().canJumpTail(arrays);
        System.out.println(ans);

        int[] arrays2 = {3,2,1,0,4};
        boolean ans2 = new CanJump().canJumpTail(arrays2);
        System.out.println(ans2);
    }
}
