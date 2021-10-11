package com.twiss.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: Twiss
 * @Date: 2021/10/9 9:48 上午
 */
public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid){
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        // get media of x[] and y[] using quick sort
        int mx = x.get(quickSort(x,0,x.size()-1,x.size()/2+1));
        int my = y.get(quickSort(y,0,y.size()-1,y.size()/2+1));
        // calculate the total Manhattan distance
        int total = 0;
        for (int i=0;i<x.size();++i){
            total+=Math.abs(x.get(i)-mx)+Math.abs(y.get(i)-my);
        }
        return total;
    }

    private int quickSort(List<Integer> nums, int low, int high, int k){
        // randomly pick a pivot and put it to a[hi]
        // we need to do this, otherwise quick sort is slow!
        Random random = new Random();
        int p = low+random.nextInt(high-low+1);
        Collections.swap(nums,p,high);
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int i = low, j = high, pivot = nums.get(high);
        while (i<j){
            if (nums.get(i++)>pivot){
                Collections.swap(nums,--i,--j);
            }
        }
        Collections.swap(nums,i,high);

        // count the nums that are <= pivot from lo
        int m = i-low+1;
        // pivot is the one!
        if (m==k){
            return i;
        }
        // pivot is too big, so it must be on the left
        else if (m>k){
            return quickSort(nums,low,i-1,k);
        }
        // pivot is too small, so it must be on the right
        else {
            return quickSort(nums,i+1,high,k-m);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0},
        };
        int res = new BestMeetingPoint().minTotalDistance(grid);
        System.out.println(res);
    }
}
