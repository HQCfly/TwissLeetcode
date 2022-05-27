package com.twiss.doublepoint;

/**
 * 移除元素
 * 不能使用额外空间，可以改变元素位置
 * @Author: Twiss
 * @Date: 2022/5/27 11:06 上午
 */
public class RemoveElement {

    public int getNewArray(int[] nums, int val){
        if (nums==null||nums.length==0){
            return 0;
        }
        int left = 0, right = nums.length;
        while (left<right){
            if (nums[left]==val){
                nums[left]=nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,3,0,4,2};
        int tar = 2;
        int size = new RemoveElement().getNewArray(array,tar);
        System.out.println(size);
    }
}
