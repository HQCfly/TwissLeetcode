package com.twiss.doublepoint;

/**
 * 移除元素
 * 不能使用额外空间，可以改变元素位置
 * 双指针
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

    public int getNewArrayByDoublePoint(int[] nums, int va){
        if (nums==null||nums.length==0){
            return 0;
        }
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex=0;fastIndex<nums.length;fastIndex++){
            if (nums[fastIndex]!=va){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }


    public int getNewArraySize(int[] nums, int val){
        if (nums==null||nums.length==0){
            return 0;
        }
        int slow = 0, fast;
        for (fast=0;fast<nums.length;fast++){
            if (nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,3,0,4,2};
        int tar = 2;
        int size = new RemoveElement().getNewArray(array,tar);
        System.out.println(size);
        int[] array2 = {0,1,2,3,3,0,4,2};
        int size2 = new RemoveElement().getNewArraySize(array2,tar);
        System.out.println(size2);

        int[] array3 = {0,1,2,3,3,0,4,2};
        int size3 = new RemoveElement().getNewArrayByDoublePoint(array3,tar);
        System.out.println(size3);
    }
}
